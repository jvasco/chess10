package chess;

public class King extends Piece{

	public King(boolean isWhite) {
		super(isWhite);
		if(isWhite){
			name = "wK";
		}else{
			name = "bK";
		}

		// TODO Auto-generated constructor stub
	}
	public boolean isValidMove(Piece[][] board, String move)
	{
		int initFile = 8 - Character.getNumericValue(move.charAt(1));
		int initRank = (int) Character.toLowerCase(move.charAt(0)) - (int) ('a');
		int finalFile = 8 - Character.getNumericValue(move.charAt(4));
		int finalRank = (int) Character.toLowerCase(move.charAt(3)) - (int) ('a');
		
		if(finalFile < 0 || finalFile > 7 || finalRank < 0 || finalFile > 7)
		{
			return false;
		}
		
		if(Math.abs(finalRank - initRank) == 0 && Math.abs(finalFile - initFile) == 1)
		{
			return true;
		}
		
		if(Math.abs(finalRank - initRank) == 1 && (Math.abs(finalFile - initFile) == 1 || Math.abs(finalFile - initFile) == 0) )
		{
			return true;
		}
		return false;
		//if(finalRank - initRank == )
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
