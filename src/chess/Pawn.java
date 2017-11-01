package chess;

public class Pawn extends Piece {
	public Pawn(boolean isWhite) {
		super(isWhite);
		if (isWhite) {
			name = "wp";
		} else {
			name = "bp";
		}
		// TODO Auto-generated constructor stub
		hasMoved = true;
	}

	boolean white;
	String color;
	boolean firstMove = true;


	@Override
	public boolean isValidMove(Piece[][] board, String move) {

		//this makes them coordinate to coordinates on the array
		int initFile = 8 - Character.getNumericValue(move.charAt(1));
		int initRank = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
		int finalFile = 8 - Character.getNumericValue(move.charAt(4));
		int finalRank = (int) Character.toLowerCase(move.charAt(3)) - (int) ('a');

		/*
		 * String[] positions = move.split("\\s"); char initFileChar =
		 * positions[0].charAt(0); char initRankChar = positions[0].charAt(1);
		 * char finalFileChar = positions[1].charAt(0); char finalRankChar =
		 * positions[1].charAt(1); int initFile = (int)
		 * Character.toLowerCase(initFileChar) - (int)('a'); int initRank =
		 * (int) Character.toLowerCase(initRankChar) - (int)('a'); int finalFile
		 * = (int) Character.toLowerCase(finalFileChar) - (int)('a'); int
		 * finalRank = (int) Character.toLowerCase(finalRankChar) - (int)('a');
		 */

		if (finalFile < 0 || finalFile > 7 || finalRank < 0 || finalFile > 7) {
			return false;
		}
		
		
		if (isWhite()) {
			
			if(Chess.getEnp()==true && finalFile == Chess.fe - 1 && finalRank == Chess.re)
			{
				return true;
			}
			if (firstMove && finalFile - initFile == -2 && finalRank - initRank == 0
					&& board[finalFile][finalRank] == null
					&& board[initFile - 1][initRank] == null
					&& initFile == 6) {
				return true;
			}
			if (finalFile - initFile == -1 && finalRank - initRank == 0 
					&& board[finalFile][finalRank] == null
					) {
				return true;
			}

			if (finalFile - initFile == -1 && 
					Math.abs(finalRank - initRank) == 1 &&
					board[finalFile][finalRank] != null
					&& this.isWhite() != board[finalFile][finalRank].isWhite()) {
				return true;
				
			}
			

		} else {

			if(Chess.enp == true && finalFile == Chess.fe + 1 && finalRank == Chess.re)
			{
				return true;
			}
			if (firstMove && finalFile - initFile == 2 && finalRank - initRank == 0 
					&& board[finalFile][finalRank] == null
					&& initFile == 1) 
			{
				return true;
			}

			if (finalFile - initFile == 1 && finalRank - initRank == 0 && board[finalFile][finalRank] == null){
				return true;
			}
			if (finalFile - initFile == 1 && 
					Math.abs(finalRank - initRank) == 1
					&& board[finalFile][finalRank] != null && 
					this.isWhite() != board[finalFile][finalRank].isWhite()) {
				// killing a piece
				return true;
			}

			
		}

		return false;
	}


}
