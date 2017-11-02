package chess;

/**
 * @author Jordy Vasco
 * @author Nicholas Lelchitsky
 * 
 */

public class Bishop extends Piece {

	boolean isWhite;

	/**
	 * 
	 * names the piece depending on if it is white or not
	 * @param isWhite
	 */
	
	
	public Bishop(boolean isWhite) {

		super(isWhite);
		if (isWhite) {
			name = "wB";
		} else {
			name = "bB";
		}
		hasMoved = true;
	}

	/**
	 * 
	 * checks if the move input by user is valid for a bishop
	 * @param board, move
	 * @return true or false
	 */
	
	public boolean isValidMove(Piece[][] board, String move) {
		int initFile = 8 - Character.getNumericValue(move.charAt(1));
		int initRank = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
		int finalFile = 8 - Character.getNumericValue(move.charAt(4));
		int finalRank = (int) Character.toLowerCase(move.charAt(3)) - (int) ('a');

		if (finalFile < 0 || finalFile > 7 || finalRank < 0 || finalFile > 7) {
			return false;
		}

		if (Math.abs(finalFile - initFile) == Math.abs(finalRank - initRank)) {

			if (finalRank > initRank && finalFile > initFile) {
				for (int i = 1; i < finalRank - initRank; i++) {
					if (board[initFile + i][initRank + i] != null) {
						return false;
					}
				}
			}

			else if (finalRank > initRank && finalFile < initFile) {
				for (int i = 1; i < finalRank - initRank; i++) {
					if (board[initFile - i][initRank + i] != null) {
						return false;
					}
				}
			}

			else if (finalRank < initRank && finalFile > initFile) {
				for (int i = 1; i < finalFile - initFile; i++) {
					if (board[initFile + i][initRank - i] != null) {
						return false;
					}
				}
			} else if (finalRank < initRank && finalFile < initFile) {
				for (int i = 1; i < initRank - finalRank; i++) {
					if (board[initFile - i][initRank - i] != null) {
						return false;
					}
				}
			}
			if (board[finalFile][finalRank] == null || this.isWhite() != board[finalFile][finalRank].isWhite()) {
				return true;
			}
		}
		return false;
	}



}
