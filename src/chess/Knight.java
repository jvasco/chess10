package chess;

public class Knight extends Piece {

	public Knight(boolean isWhite) {
		super(isWhite);
		if (isWhite) {
			name = "wN";
		} else {
			name = "bN";
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Piece[][] board, String move) {
		int initFile = 8 - Character.getNumericValue(move.charAt(1));
		int initRank = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
		int finalFile = 8 - Character.getNumericValue(move.charAt(4));
		int finalRank = (int) Character.toLowerCase(move.charAt(3)) - (int) ('a');

		if (finalFile < 0 || finalFile > 7 || finalRank < 0 || finalFile > 7) {
			return false;
		}

		if (Math.abs(finalFile - initFile) == 1 && Math.abs(finalRank - initRank) == 2) {
			if (board[finalFile][finalRank] == null) 
			{
				return true;
			} 
			else if (board[finalFile][finalRank].isWhite() != this.isWhite()) 
			{
				return true;
			}
		} 
		
		else if (Math.abs(finalFile - initFile) == 2 && Math.abs(finalRank - initRank) == 1) {
			if (board[finalFile][finalRank] == null) 
			{
				return true;
			} 
			else if (board[finalFile][finalRank].isWhite() != this.isWhite()) 
			{
				return true;
			}
		}


		return false;

	}


}
