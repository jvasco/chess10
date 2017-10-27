package chess;

public class Bishop extends Piece{

	boolean isWhite;
	public Bishop(boolean isWhite) {
		super(isWhite);
		// TODO Auto-generated constructor stub
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
		if(Math.abs(finalFile - initFile) != Math.abs(finalRank - initRank))
		{
			return false;
		}
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

		return true;
	}

}
