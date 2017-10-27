package chess;

public class Rook extends Piece {

	boolean isWhite;

	public Rook(boolean isWhite) {
		super(isWhite);
	}

	boolean isValidMove(Piece[][] board, String move) {
		String[] positions = move.split(" ");
		char initFileChar = positions[0].charAt(0);
		char initRankChar = positions[0].charAt(1);
		char finalFileChar = positions[1].charAt(0);
		char finalRankChar = positions[1].charAt(1);
		int initFile = (int) Character.toLowerCase(initFileChar) - (int) ('a');
		int initRank = (int) Character.toLowerCase(initRankChar) - (int) ('a');
		int finalFile = (int) Character.toLowerCase(finalFileChar) - (int) ('a');
		int finalRank = (int) Character.toLowerCase(finalRankChar) - (int) ('a');

		if (initFile == finalFile) {
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
			if (initRank < finalRank) {
				for (int i = initRank; i < finalRank; i++) {
					if (board[i][finalRank] != null) {
						// there's a piece in the way
						return false;
					}
				}
			}
		}
		else
		{
			return false;
		}
		if (board[finalFile][finalRank].isWhite() == this.isWhite) {
			//same color so can't eat the other piece
			return false;
		}
		return true;
	}

}
