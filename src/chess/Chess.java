package chess;

import java.util.Scanner;

public class Chess {

	static int turn;
	static String bKpos, wKpos;
	static Piece[][] emptyBoard = new Piece[8][8];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create chess board
		Piece[][] chessBoard = new Piece[8][8];
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++){
				chessBoard[i][j] = null;
			}
		}
		
		for (int i = 0; i < 8; i++) {
			chessBoard[6][i] = new Pawn(true);

		}
		for (int i = 0; i < 8; i++) {
			chessBoard[1][i] = new Pawn(false);
		} 
		
		chessBoard[0][0] = new Rook(false);
		chessBoard[0][7] = new Rook(false);
		chessBoard[7][0] = new Rook(true);
		chessBoard[7][7] = new Rook(true);

		chessBoard[0][1] = new Knight(false);
		chessBoard[0][6] = new Knight(false);
		chessBoard[7][1] = new Knight(true);
		chessBoard[7][6] = new Knight(true);

		chessBoard[0][2] = new Bishop(false);
		chessBoard[0][5] = new Bishop(false);
		chessBoard[7][2] = new Bishop(true);
		chessBoard[7][5] = new Bishop(true);

		chessBoard[0][3] = new Queen(false);
		chessBoard[7][3] = new Queen(true);

		chessBoard[0][4] = new King(false);
		bKpos = "e8";
		chessBoard[7][4] = new King(true);
		wKpos = "e1";

		Scanner input;
		String stuff;

		boolean game = true;
		boolean drawOffer = false;
		String move;
		turn = 1; // white's move if turn = -1
		String drawMove = "";

		printBoard(chessBoard);

		while (game) {
			turn *= -1;

			if (turn == -1) {
				System.out.print("White's move: ");
			} else {
				System.out.print("Black's move: ");
			}
			input = new Scanner(System.in);
			move = input.nextLine();
			System.out.println();


			/*String[] positions = move.split("\\s");
			char initFileChar = positions[0].charAt(0);
			char initRankChar = positions[0].charAt(1);
			char finalFileChar = positions[1].charAt(0);
			char finalRankChar = positions[1].charAt(1);
			int initFile = (int) Character.toLowerCase(initFileChar) - (int) ('a');
			int initRank = (int) Character.getNumericValue(initRankChar) - 1;
			int finalFile = (int) Character.toLowerCase(finalFileChar) - (int) ('a');
			int finalRank = (int) Character.getNumericValue(finalRankChar) - 1;
			*/
			int f1 = 8 - Character.getNumericValue(move.charAt(1));
			int r1 = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
			
			Piece piece = chessBoard[f1][r1];
			
		

			while (piece == null || !piece.isValidMove(chessBoard, move) || isMyKingInCheck(chessBoard)) {
				System.out.println("Illegal move, try again.");
				if (turn == -1) {
					System.out.println("White's move: ");
				} else {
					System.out.println("Black's move: ");
				}
				move = input.nextLine();
				System.out.println();
				f1 = 8 - Character.getNumericValue(move.charAt(1));
				r1 = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
				
				piece = chessBoard[f1][r1];

			}
			System.out.println("Slected piece is: " + chessBoard[f1][r1].getName());
			// draw
			if (move.length() == 11 && move.substring(6).equals("draw?")) {
				drawOffer = true;
				drawMove = move.substring(0, 5);
				continue;
			}

			if (move.equals("draw") && drawOffer) {
				System.out.println("draw");
				drawOffer = false;
				break;
			}

			if (drawOffer) {
				turn *= -1;
				move = drawMove;
				drawOffer = false;
			}

			// resign
			if (turn == -1) {
				if (move.equals("resign")) {
					System.out.println("Black wins");
					break;
				}
			} else {
				if (move.equals("resign")) {
					System.out.println("White wins");
					break;
				}
			}
			// System.out.println(move + "\n");

			// check
			System.out.println("Checking");
			if (ifCheck(chessBoard)) {
				
				System.out.println("Check");
			}

			// checkmate
			/* if (turn == -1) {
				// if(isValidMove){
				if (move.substring(3).equals(bKpos)) {
					System.out.println("Checkmate");
					System.out.println("White wins");
					break;
				}
				// }
			} else {
				// if(isValidMove){
				if (move.substring(3).equals(wKpos)) {
					System.out.println("Checkmate");
					System.out.println("Black wins");
					break;
				}
				// }
			}
			*/
			// System.out.println(getPos(7,4));
			
			if(chessBoard[f1][r1].isValidMove(chessBoard,move)){
			chessBoard = updateBoard(chessBoard, move);
			}
			printBoard(chessBoard);
		}
	}

	public static void printBoard(Piece[][] board) {
		int c = 1;
		int rank = 8;
		for (Piece[] i : board) {
			c *= -1;
			for (Piece j : i) {
				c *= -1;
				if (j == null) {
					if (c == 1) {
						System.out.print("   ");
					} else {
						System.out.print("## ");
					}
				} else {
					System.out.print(j.getName() + " ");
				}
			}
			System.out.println(rank-- + " ");
		}
		System.out.println(" a  b  c  d  e  f  g  h " + "\n");
	}

	public static String getPos(int file, int rank) {
		char x = 'a';
		x += rank;
		int y = 8 - file;
		return "" + x + y;

	}

	public static boolean ifCheck(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null) {
					continue;
				}
				if(board[i][j].getName().equals("bQ"))
				{
					System.out.println("CHECKING BLACK QUeen at " + i + " " + j);
					
				}
				String pos = getPos(i, j);
				String move;
				if (turn == -1 && board[i][j].isWhite()) {
					// white's turn
					move = pos + " " + bKpos;
					
					if (board[i][j].isValidMove(board, move)) {
						return true;
					}

				} else if (turn == 1 && !board[i][j].isWhite()) {
					//black's turn
					move = pos + " " + wKpos;
					if (board[i][j].isValidMove(board, move)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// a1 = 7,0 a 2 = 6,0
	public static Piece[][] updateBoard(Piece[][] board, String move) {

		int f1 = 8 - Character.getNumericValue(move.charAt(1));
		int r1 = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
		int f2 = 8 - Character.getNumericValue(move.charAt(4));
		int r2 = (int) Character.toLowerCase(move.charAt(3)) - (int) ('a');

		Piece temp = board[f1][r1];
		board[f1][r1] = null;
		board[f2][r2] = temp;

		System.out.println("" + f1 + " " + r1 + " " + f2 + " " + r2);

		return board;
	}

	public static boolean isMyKingInCheck(Piece[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null) {
					continue;
				}
				String pos = getPos(i, j);
				String move;
				if (turn == -1 && !board[i][j].isWhite()) {
					// white's turn, attacking piece is black
					move = pos + " " + wKpos;
					if (board[i][j].isValidMove(board, move)) {
						return true;
					}
				} else if (turn == 1 && board[i][j].isWhite()) {
					move = pos + " " + bKpos;
					if (board[i][j].isValidMove(board, move)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}