package chess;

public class Pawn extends Piece {
	public Pawn(boolean isWhite) {
		super(isWhite);
		// TODO Auto-generated constructor stub
	}

	boolean isWhite;
	String color;
	boolean firstMove;
	void setFirstMove()
	{
		if(isWhite)
		{
			
		}
	}
	boolean isValidMove(Piece[][] board, String move) {
		String[] positions = move.split(" ");
		char initFileChar = positions[0].charAt(0);
		char initRankChar = positions[0].charAt(1);
		char finalFileChar = positions[1].charAt(0);
		char finalRankChar = positions[1].charAt(1);
		int initFile = (int) Character.toLowerCase(initFileChar) - (int)('a');
		int initRank = (int) Character.toLowerCase(initRankChar) - (int)('a');
		int finalFile = (int) Character.toLowerCase(finalFileChar) - (int)('a');
		int finalRank = (int) Character.toLowerCase(finalRankChar) - (int)('a');
		if (isWhite) {
			if (!firstMove && finalRank - initRank != 1) // if it is not the first move the pawn can only move up one space
			{
				return false;
			}
			if (firstMove && finalRank - initRank != 1 || finalRank - initRank != 2) {
				return false;
			}
			if (board[finalFile][finalRank] != null && board[finalFile][finalRank].isWhite()) {
				return false;
			}
			if (!board[finalFile][finalRank].isWhite() && Math.abs(finalFile - initFile) != 1) {
				return false;
			}
			if (board[finalFile][finalRank].isWhite()) {
				return false;
			}
			if (finalFile != initFile) {
				return false;
			}
		}
		else {
			if (!firstMove && finalRank - initRank != 1) // if it is not the first move the pawn can only move up one space
			{
				return false;
			}
			if (firstMove && finalRank - initRank != 1 || finalRank - initRank != 2) {
				return false;
			}
			if (board[finalFile][finalRank] != null && !board[finalFile][finalRank].isWhite()) {
				return false;
			}
			if (board[finalFile][finalRank].isWhite() && Math.abs(finalFile - initFile) != 1) {
				return false;
			}
			if (!board[finalFile][finalRank].isWhite()) {
				return false;
			}
			if (finalFile != initFile) {
				return false;
			}
		}
		return true;
	}

}
