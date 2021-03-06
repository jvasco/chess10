package chess;

/**
 * @author Jordy Vasco
 * @author Nicholas Lelchitsky
 * 
 */

public class Queen extends Piece {

	/**
	 * 
	 * names the piece depending on if it is white or not
	 * @param isWhite
	 */
	
	
	public Queen(boolean isWhite) {
		super(isWhite);
		if (isWhite) {
			name = "wQ";
		} else {
			name = "bQ";
		}
		hasMoved = true;
	}
	
	/**
	 * 
	 * checks if the move input by user is valid for a queen
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

		else if (initFile == finalFile) {

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

		} else if (initRank == finalRank) {
			if (initFile < finalFile) {

				for (int i = initFile + 1; i < finalFile; i++) {
					if (board[i][finalRank] != null) {
						// there's a piece in the way
						return false;
					}
				}
			} else 
			{
				for (int i = initFile - 1; i > finalFile; i--) {
					if (board[i][finalRank] != null) {
						return false;
					}
				}
			}
		} else {
			return false;
		}
		if (board[finalFile][finalRank] == null || board[finalFile][finalRank].isWhite() != this.isWhite()) {
			return true;
		}
		return false;
	}

}
