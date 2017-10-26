package chess;

import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create chess board
		Piece [][] chessBoard = new Piece[8][8];
		for (int i = 0; i<8; i++)
		{
			chessBoard[6][i] = new Pawn(true);
					
		}
		for (int i = 0; i<8; i++)
		{
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
		chessBoard[7][4] = new King(true);
		
		
		System.out.println("Hello world");
		Scanner input = new Scanner(System.in);
		String stuff = input.next();
		String [] positions = stuff.split(" ");
		char initFile = positions[0].charAt(0);
		char initRank = positions[0].charAt(1);
		char finalFile = positions[1].charAt(0);
		char finalRank = positions[1].charAt(1);
		
	}

}
