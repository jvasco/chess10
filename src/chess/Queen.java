package chess;

public class Queen extends Piece {

	public Queen(boolean isWhite) {
		super(isWhite);
		if (isWhite) {
			name = "wQ";
		} else {
			name = "bQ";
		}

	}

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
			
			// horizontally
			if (initRank < finalRank) {
				for (int i = initRank; i < finalRank; i++) {
					
					if (board[initFile][i] != null) {
						
						return false;
					}
				}
			} else {
				for (int i = initRank; i > finalRank; i--) {
					System.out.println("Well i did");
					if (board[initFile][i] != null) {
						return false;
					}
				}
			}

		} else if (initRank == finalRank) {
			
			// vertically
			if (initFile < finalFile) {
				
				for (int i = initFile; i < finalFile; i++) {
					System.out.println("Well i did");
					if (board[i][finalRank] != null) {
						// there's a piece in the way
						return false;
					}
				}
			} else {
				
				for (int i = initFile; i > finalFile; i--) {
					
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
