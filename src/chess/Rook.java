package chess;

/**
 * @author Jordy Vasco
 * @author Nicholas Lelchitsky
 * 
 */

public class Rook extends Piece {

	boolean isWhite;

	/**
	 * 
	 * names the piece depending on if it is white or not
	 * @param isWhite
	 */
	
	
	public Rook(boolean isWhite) {
		super(isWhite);
		if(isWhite){
			name = "wR";
		}else{
			name = "bR";
		}
		hasMoved = false;
	}

	/**
	 * 
	 * checks if the move input by user is valid for a rook
	 * @param board, move
	 * @return true or false
	 */
	
	public boolean isValidMove(Piece[][] board, String move) {
		
		int initFile = 8 - Character.getNumericValue(move.charAt(1));
		int initRank = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
		int finalFile = 8 - Character.getNumericValue(move.charAt(4));
		int finalRank = (int) Character.toLowerCase(move.charAt(3)) - (int) ('a');
		
		if(finalFile < 0 || finalFile > 7 || finalRank < 0 || finalFile > 7)
		{
			return false;
		}

		if (initFile == finalFile) {
			if (initRank < finalRank) {
				for (int i = initRank + 1; i < finalRank; i++) {
					if (board[initFile][i] != null) {
						return false;
					}
				}
			} else {
				for (int i = initRank - 1; i > finalRank; i--) {
					if (board[initFile][i] != null) {
						return false;
					}
				}
			}

		} 
		else if (initRank == finalRank) {
			//vertically
			if (initFile < finalFile) {
				for (int i = initFile + 1; i < finalFile; i++) {
					if (board[i][finalRank] != null) {
						return false;
					}
				}
			}
			else
			{
				for (int i = initFile - 1; i > finalFile; i--)
				{
					if(board[i][finalRank] != null) {
						return false;
					}
				}
			}
		}
		else
		{
			
			return false;
		}
		if (board[finalFile][finalRank] == null || board[finalFile][finalRank].isWhite() != this.isWhite()) {
			this.hasMoved = true;
			return true;
		}
		return false;
	}


}
