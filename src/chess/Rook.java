package chess;

public class Rook extends Piece {

	boolean isWhite;

	public Rook(boolean isWhite) {
		super(isWhite);
		if(isWhite){
			name = "wR";
		}else{
			name = "bR";
		}
		hasMoved = false;
	}

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
			//horizontally
			if (initRank < finalRank) {
				for (int i = initRank; i < finalRank; i++) {
					if (board[initFile][i] != null) {
						return false;
					}
				}
			} else {
				for (int i = initRank; i > finalRank; i--) {
					if (board[initFile][i] != null) {
						return false;
					}
				}
			}

		} 
		else if (initRank == finalRank) {
			//vertically
			if (initFile < finalFile) {
				for (int i = initFile; i < finalFile; i++) {
					if (board[i][finalRank] != null) {
						// there's a piece in the way
						return false;
					}
				}
			}
			else
			{
				for (int i = initFile; i > finalFile; i--)
				{
					if(board[i][finalFile] != null) {
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
			//same color so can't eat the other piece
			this.hasMoved = true;
			return true;
		}
		return false;
	}


}
