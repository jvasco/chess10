package chess;

import java.util.Arrays;
import java.util.Scanner;

public class Chess {

	static int turn;
	static String bKpos, wKpos;
	static boolean enp = false;
	static int fe = 0;
	static int re = 0;
	static boolean wCheck = false;
	static boolean bCheck = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create chess board
		boolean inCheck = false;
		Piece[][] chessBoard = new Piece[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
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

			while (!isValidInput(move)) {
				System.out.println("Invalid input");
				move = input.nextLine();
				System.out.println();
			}

			// draw
			if (move.length() == 11 && move.substring(6).equals("draw?")) {
				drawOffer = true;
				move = move.substring(0, 5);
			} else if (move.equals("draw") && drawOffer) {
				System.out.println("draw");
				break;
			} else if (drawOffer) {
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

			int f1 = 8 - Character.getNumericValue(move.charAt(1));
			int r1 = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
			int f2 = 8 - Character.getNumericValue(move.charAt(4));
			int r2 = (int) Character.toLowerCase(move.charAt(3)) - (int) ('a');

			Piece piece = chessBoard[f1][r1];
			Piece[][] temp = new Piece[8][8];
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					temp[i][j] = chessBoard[i][j];
				}
			}

			while (piece == null || !piece.isValidMove(chessBoard, move) || (turn == -1 && !piece.isWhite())
					|| (turn == 1 && piece.isWhite())) {

				System.out.println("Illegal move, try again." + "\n");
				if (turn == -1) {
					System.out.print("White's move: ");
				} else {
					System.out.print("Black's move: ");
				}
				move = input.nextLine();
				System.out.println();
				f1 = 8 - Character.getNumericValue(move.charAt(1));
				r1 = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
				f2 = 8 - Character.getNumericValue(move.charAt(4));
				r2 = (int) Character.toLowerCase(move.charAt(3)) - (int) ('a');

				piece = chessBoard[f1][r1];
			}
			// System.out.println("Slected piece is: " +
			// chessBoard[f1][r1].getName());

			while (isMyKingInCheck(temp, move)) {
				System.out.println("Illegal move, try again." + "\n");
				if (turn == -1) {
					System.out.print("White's move: ");
				} else {
					System.out.print("Black's move: ");
				}
				move = input.nextLine();
				System.out.println();
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						temp[i][j] = chessBoard[i][j];
					}
				}
			}
			/*
			 * Piece[][] temp = chessBoard; chessBoard = updateBoard(chessBoard,
			 * move); while(isMyKingInCheck(chessBoard)) {
			 * 
			 * System.out.println("Illegal move, try again." + "\n"); if (turn
			 * == -1) { System.out.print("White's move: "); } else {
			 * System.out.print("Black's move: "); } move = input.nextLine();
			 * System.out.println(); f1 = 8 -
			 * Character.getNumericValue(move.charAt(1)); r1 = (int)
			 * Character.toLowerCase(move.charAt(0)) - (int) ('a'); piece =
			 * chessBoard[f1][r1];
			 * 
			 * } chessBoard = temp;
			 */
			// System.out.println("Slected piece " + f1 + r1 + " is: " +
			// chessBoard[f1][r1].getName());

			// System.out.println(move + "\n");

			// check

			// checkmate
			/*
			 * if (turn == -1) { // if(isValidMove){ if
			 * (move.substring(3).equals(bKpos)) {
			 * System.out.println("Checkmate");
			 * System.out.println("White wins"); break; } // } } else { //
			 * if(isValidMove){ if (move.substring(3).equals(wKpos)) {
			 * System.out.println("Checkmate");
			 * System.out.println("Black wins"); break; } // } }
			 */
			// System.out.println(getPos(7,4));

			if (chessBoard[f1][r1].isValidMove(chessBoard, move)) {

				// enpassant

				if (!enp) {
					if (chessBoard[f1][r1] != null && chessBoard[f1][r1].getName().equals("wp") && f1 == 6 && f2 == 4) {
						enp = true;
						fe = f2;
						re = r2;
					} else if (chessBoard[f1][r1] != null && chessBoard[f1][r1].getName().equals("bp") && f1 == 1
							&& f2 == 3) {
						enp = true;
						fe = f2;
						re = r2;
					}
				} else if (enp) {
					if (chessBoard[f1][r1].getName().equals("wp") && (f2 == fe - 1) && (r2 == re)) {
						chessBoard[fe][re] = null;
					} else if (chessBoard[f1][r1].getName().equals("bp") && (f2 == fe + 1) && (r2 == re)) {
						chessBoard[fe][re] = null;
					}
					enp = false;
				}

				// castling
				if (chessBoard[f1][r1].getName().equals("wK") && !chessBoard[f1][r1].hasMoved) {
					if (f2 == 7 && r2 == 6) {
						if (!chessBoard[7][7].hasMoved) {
							chessBoard[7][7].hasMoved = true;
							chessBoard[7][5] = chessBoard[7][7];
							chessBoard[7][7] = null;
						}
					} else if (f2 == 7 && r2 == 2) {
						if (!chessBoard[7][0].hasMoved) {
							chessBoard[7][0].hasMoved = true;
							chessBoard[7][3] = chessBoard[7][0];
							chessBoard[7][0] = null;
						}
					}
					chessBoard[f1][r1].hasMoved = true;
				} else if (chessBoard[f1][r1].getName().equals("bK") && !chessBoard[f1][r1].hasMoved) {
					if (f2 == 0 && r2 == 6) {
						if (!chessBoard[0][7].hasMoved) {
							chessBoard[0][7].hasMoved = true;
							chessBoard[0][5] = chessBoard[0][7];
							chessBoard[0][7] = null;
						}
					} else if (f2 == 0 && r2 == 2) {
						if (!chessBoard[0][0].hasMoved) {
							chessBoard[0][0].hasMoved = true;
							chessBoard[0][3] = chessBoard[0][0];
							chessBoard[0][0] = null;
						}
					}
					chessBoard[f1][r1].hasMoved = true;
				}

				// update king pos
				if (chessBoard[f1][r1].getName().equals("wK")) {
					chessBoard[f1][r1].hasMoved = true;
					wKpos = getPos(f2, r2);
				} else if (chessBoard[f1][r1].getName().equals("bK")) {
					chessBoard[f1][r1].hasMoved = true;
					bKpos = getPos(f2, r2);
				}

				// pawn promotion
				if (chessBoard[f1][r1].getName().equals("wp") && f2 == 0) {
					if (move.length() == 7) {
						char c = move.charAt(6);
						if (c == 'B') {
							chessBoard[f1][r1] = new Bishop(true);
						} else if (c == 'N') {
							chessBoard[f1][r1] = new Knight(true);
						} else if (c == 'R') {
							chessBoard[f1][r1] = new Rook(true);
						} else if (c == 'Q') {
							chessBoard[f1][r1] = new Queen(true);
						} else if (c == 'p') {
							chessBoard[f1][r1] = new Pawn(true);
						}
					} else {
						chessBoard[f1][r1] = new Queen(true);
					}
				} else if (chessBoard[f1][r1].getName().equals("bp") && f2 == 7) {
					if (move.length() == 7) {
						char c = move.charAt(6);
						if (c == 'B') {
							chessBoard[f1][r1] = new Bishop(false);
						} else if (c == 'N') {
							chessBoard[f1][r1] = new Knight(false);
						} else if (c == 'R') {
							chessBoard[f1][r1] = new Rook(false);
						} else if (c == 'Q') {
							chessBoard[f1][r1] = new Queen(false);
						} else if (c == 'p') {
							chessBoard[f1][r1] = new Pawn(false);
						}
					} else {
						chessBoard[f1][r1] = new Queen(false);
					}
				}
				chessBoard = updateBoard(chessBoard, move);

			}

			printBoard(chessBoard);
			// check
			if (turn == -1) {
				bCheck = ifCheck(chessBoard);
				if (bCheck) {
					System.out.println("Check");
					if(turn == -1 && isCheckmate(chessBoard)){
						System.out.println("mate" + "\n" + "White wins");
						break;
					}else if(turn == 1 && isCheckmate(chessBoard)){
						System.out.println("mate" + "\n" + "Black wins");
						break;
					}
				}
			} else {
				wCheck = ifCheck(chessBoard);
				if (wCheck) {
					System.out.print("Check");
					if(turn == -1 && isCheckmate(chessBoard)){
						System.out.println("mate" + "\n" + "White wins");
						break;
					}else if(turn == 1 && isCheckmate(chessBoard)){
						System.out.println("mate" + "\n" + "Black wins");
						break;
					}
				}
			}
			
			
			System.out.println();
		}
	}

	public static boolean isValidInput(String move) {
		// TODO Auto-generated method stub
		if (move.length() == 11 && move.substring(6).equals("draw?")) {
			return true;
		}

		if (move.equals("draw")) {
			return true;
		}
		if (move.equals("resign")) {
			return true;
		}
		if (move.matches("[abcdefgh][12345678] [abcdefgh][12345678]")) {
			return true;
		}
		if (move.matches("[abcdefgh][12345678] [abcdefgh][12345678] [BNRQp]")) {
			return true;
		}
		return false;
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

	public static boolean isCheckmate(Piece[][] board){
		int f1,r1;
		String move;
		String temp = "";
		
		if(turn == -1 && bCheck){
			f1 = 8 - Character.getNumericValue(bKpos.charAt(1));
			r1 = (int) Character.toLowerCase(bKpos.charAt(0)) - (int) ('a');
			temp = bKpos;
			Piece tempBoard[][] = new Piece[8][8];
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					tempBoard[i][j] = board[i][j];
				}
			}
			
			move = bKpos + " " + getPos(f1-1,r1-1);
			if(board[f1][r1].isValidMove(board, move)){
				bKpos = getPos(f1-1, r1-1);
				if(!ifCheck(board)){
					bKpos = temp;
					return false;
				}
				bKpos = temp;
			}
			move = bKpos + " " + getPos(f1-1,r1);
			if(board[f1][r1].isValidMove(board, move)){
				bKpos = getPos(f1-1, r1);
				if(!ifCheck(board)){
					bKpos = temp;
					return false;
				}
				bKpos = temp;
			}
			move = bKpos + " " + getPos(f1-1,r1+1);
			if(board[f1][r1].isValidMove(board, move)){
				bKpos = getPos(f1-1, r1+1);
				if(!ifCheck(board)){
					bKpos = temp;
					return false;
				}
				bKpos = temp;
			}
			move = bKpos + " " + getPos(f1,r1-1);
			if(board[f1][r1].isValidMove(board, move)){
				bKpos = getPos(f1, r1-1);
				if(!ifCheck(board)){
					bKpos = temp;
					return false;
				}
				bKpos = temp;
			}
			move = bKpos + " " + getPos(f1,r1+1);
			if(board[f1][r1].isValidMove(board, move)){
				bKpos = getPos(f1, r1+1);
				if(!ifCheck(board)){
					bKpos = temp;
					return false;
				}
				bKpos = temp;
			}
			move = bKpos + " " + getPos(f1+1,r1-1);
			if(board[f1][r1].isValidMove(board, move)){
				bKpos = getPos(f1+1, r1-1);
				if(!ifCheck(board)){
					bKpos = temp;
					return false;
				}
				bKpos = temp;
			}
			move = bKpos + " " + getPos(f1+1,r1);
			if(board[f1][r1].isValidMove(board, move)){
				bKpos = getPos(f1+1, r1);
				if(!ifCheck(board)){
					bKpos = temp;
					return false;
				}
				bKpos = temp;
			}
			move = bKpos + " " + getPos(f1+1,r1+1);
			if(board[f1][r1].isValidMove(board, move)){
				bKpos = getPos(f1+1, r1+1);
				if(!ifCheck(board)){
					bKpos = temp;
					return false;
				}
				bKpos = temp;
			}
			
			
		}else if(turn == 1 && wCheck){
			f1 = 8 - Character.getNumericValue(wKpos.charAt(1));
			r1 = (int) Character.toLowerCase(wKpos.charAt(0)) - (int) ('a');
			temp = wKpos;
			
			move = wKpos + " " + getPos(f1-1,r1-1);
			if(board[f1][r1].isValidMove(board, move)){
				wKpos = getPos(f1-1, r1-1);
				if(!ifCheck(board)){
					wKpos = temp;
					return false;
				}
				wKpos = temp;
			}
			
			move = wKpos + " " + getPos(f1-1,r1);
			if(board[f1][r1].isValidMove(board, move)){
				wKpos = getPos(f1-1, r1);
				if(!ifCheck(board)){
					wKpos = temp;
					return false;
				}
				wKpos = temp;
			}
			move = wKpos + " " + getPos(f1-1,r1+1);
			if(board[f1][r1].isValidMove(board, move)){
				wKpos = getPos(f1-1, r1+1);
				if(!ifCheck(board)){
					wKpos = temp;
					return false;
				}
				wKpos = temp;
			}
			move = wKpos + " " + getPos(f1,r1-1);
			if(board[f1][r1].isValidMove(board, move)){
				wKpos = getPos(f1, r1-1);
				if(!ifCheck(board)){
					wKpos = temp;
					return false;
				}
				wKpos = temp;
			}
			move = wKpos + " " + getPos(f1,r1+1);
			if(board[f1][r1].isValidMove(board, move)){
				wKpos = getPos(f1, r1+1);
				if(!ifCheck(board)){
					wKpos = temp;
					return false;
				}
				wKpos = temp;
			}
			move = wKpos + " " + getPos(f1+1,r1-1);
			if(board[f1][r1].isValidMove(board, move)){
				wKpos = getPos(f1+1, r1-1);
				if(!ifCheck(board)){
					wKpos = temp;
					return false;
				}
				wKpos = temp;
			}
			move = wKpos + " " + getPos(f1+1,r1);
			if(board[f1][r1].isValidMove(board, move)){
				wKpos = getPos(f1+1, r1);
				if(!ifCheck(board)){
					wKpos = temp;
					return false;
				}
				wKpos = temp;
			}
			move = wKpos + " " + getPos(f1+1,r1+1);
			if(board[f1][r1].isValidMove(board, move)){
				wKpos = getPos(f1+1, r1+1);
				if(!ifCheck(board)){
					wKpos = temp;
					return false;
				}
				wKpos = temp;
			}
			
		}
		
		return true;
	}

	public static boolean ifCheck(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null) {
					continue;
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
					// black's turn
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

		// System.out.println("" + f1 + " " + r1 + " " + f2 + " " + r2);

		return board;
	}

	public static boolean isMyKingInCheck(Piece[][] board, String mov) {

		// mov
		String tempWK = wKpos;
		String tempBK = bKpos;

		int f1 = 8 - Character.getNumericValue(mov.charAt(1));
		int r1 = (int) Character.toLowerCase(mov.charAt(0)) - (int) ('a');
		int f2 = 8 - Character.getNumericValue(mov.charAt(4));
		int r2 = (int) Character.toLowerCase(mov.charAt(3)) - (int) ('a');

		if (board[f1][r1].getName().equals("wK")) {
			tempWK = getPos(f2, r2);
		} else if (board[f1][r1].getName().equals("bK")) {
			tempBK = getPos(f2, r2);
		}

		updateBoard(board, mov);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null) {
					continue;
				}
				String pos = getPos(i, j);
				String move;

				if (turn == -1 && !board[i][j].isWhite()) {
					// white's turn, attacking piece is black

					move = pos + " " + tempWK;
					if (board[i][j].isValidMove(board, move)) {
						return true;
					}
				} else if (turn == 1 && board[i][j].isWhite()) {
					// blacks turn
					move = pos + " " + tempBK;
					if (board[i][j].isValidMove(board, move)) {
						return true;
					}
				}
			}
		}
		wKpos = tempWK;
		bKpos = tempBK;

		return false;
	}

	public static boolean getEnp() {
		return enp;
	}

}