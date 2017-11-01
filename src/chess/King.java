package chess;

public class King extends Piece{
	
	public King(boolean isWhite) {
		super(isWhite);
		if(isWhite){
			name = "wK";
		}else{
			name = "bK";
		}
		hasMoved = false;

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
		
		if(board[finalFile][finalRank+1]!=null && !board[initFile][initRank].hasMoved && !board[finalFile][finalRank+1].hasMoved && board[finalFile][finalRank+1].getName().charAt(1) == 'R'){
			if(board[initFile][initRank+1] == null && board[initFile][initRank+2] == null){
				this.hasMoved = true;
				return true;
			}
		}else if(board[finalFile][finalRank-2]!=null && !board[initFile][initRank].hasMoved && !board[finalFile][finalRank-2].hasMoved && board[finalFile][finalRank-2].getName().charAt(1) == 'R'){
			if(board[initFile][initRank-1] == null && board[initFile][initRank-2] == null  && board[initFile][initRank-3] == null){
				this.hasMoved = true;
				return true;
			}
		}
		
		if(Math.abs(finalRank - initRank) == 0 && Math.abs(finalFile - initFile) == 1)
		{
			this.hasMoved = true;
			return true;
		}
		
		if(Math.abs(finalRank - initRank) == 1 && (Math.abs(finalFile - initFile) == 1 || Math.abs(finalFile - initFile) == 0) )
		{
			this.hasMoved = true;
			return true;
		}
		
		return false;
		
		//if(finalRank - initRank == )
	}
	

}
