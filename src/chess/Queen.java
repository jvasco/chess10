package chess;

public class Queen extends Piece {

	public Queen(boolean isWhite) {
		super(isWhite);
	}
		boolean isValidMove(Piece[][] board, String move)
		{
			String[] positions = move.split(" ");
			char initFileChar = positions[0].charAt(0);
			char initRankChar = positions[0].charAt(1);
			char finalFileChar = positions[1].charAt(0);
			char finalRankChar = positions[1].charAt(1);
			int initFile = (int) Character.toLowerCase(initFileChar) - (int)('a');
			int initRank = (int) Character.toLowerCase(initRankChar) - (int)('a');
			int finalFile = (int) Character.toLowerCase(finalFileChar) - (int)('a');
			int finalRank = (int) Character.toLowerCase(finalRankChar) - (int)('a');
			if(Math.abs(finalFile - initFile) == Math.abs(finalRank - initRank)) //going in diagonal
			{
				if(finalRank > initRank && finalFile > initFile)
				{
					for(int i = 1; i < finalRank - initRank; i++)
					{
						if(board[initFile + i][initRank + i] != null)
						{
							return false;
						}
					}
				}
				
				else if(finalRank > initRank && finalFile < initFile)
				{
					for(int i = 1; i< finalRank - initRank; i++)
					{
						if(board[initFile - i][initRank + i] != null)
						{
							return false;
						}
					}
				}
				
				else if(finalRank < initRank && finalFile > initFile)
				{
					for(int i = 1; i<finalFile - initFile; i++)
					{
						if(board[initFile + i][initRank - i] != null)
						{
							return false;
						}
					}
				}
				else if(finalRank < initRank && finalFile < initFile)
				{
					for(int i = 1; i < initRank - finalRank; i++)
					{
						if(board[initFile - i][initRank - i] != null)
						{
							return false;
						}
					}
				}
			}
			
			else if (initFile == finalFile) { //going vertically
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
			else if (initRank == finalRank) { //going horizontally
				if (initRank < finalRank) {
					for (int i = initRank; i < finalRank; i++) {
						if (board[i][finalRank] != null) {
							// there's a piece in the way
							return false;
						}
					}
				}
			}
			else{
				return false;
			}
		return true;
			
	}

}
