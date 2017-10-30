package chess;

public class King extends Piece{

	public King(boolean isWhite) {
		super();
		if(isWhite){
			name = "wK";
		}else{
			name = "bK";
		}

		// TODO Auto-generated constructor stub
	}
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
		
		return false;
		//if(finalRank - initRank == )
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
