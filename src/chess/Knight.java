package chess;

public class Knight extends Piece{

	public Knight(boolean isWhite) {
		super();
		if(isWhite){
			name = "wN";
		}else{
			name = "bN";
		}
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isValidMove(Piece[][] board, String move)
	{
		String[] positions = move.split("\\s");
		char initFileChar = positions[0].charAt(0);
		char initRankChar = positions[0].charAt(1);
		char finalFileChar = positions[1].charAt(0);
		char finalRankChar = positions[1].charAt(1);
		int initFile = (int) Character.toLowerCase(initFileChar) - (int)('a');
		int initRank = (int) Character.toLowerCase(initRankChar) - (int)('a');
		int finalFile = (int) Character.toLowerCase(finalFileChar) - (int)('a');
		int finalRank = (int) Character.toLowerCase(finalRankChar) - (int)('a');
		
		if(Math.abs(finalFile - initFile) == 1 && Math.abs(finalRank - initRank) == 2)
		{
			return true;
		}
		else if(Math.abs(finalFile - initFile) == 2 && Math.abs(finalRank - initRank) == 1)
		{
			return true;
		}
		if(this.isWhite() != board[finalFile][finalRank].isWhite())
		{
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
