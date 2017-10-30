package chess;

public class Knight extends Piece{

	public Knight(boolean isWhite) {
		super(isWhite);
		if(isWhite){
			name = "wN";
		}else{
			name = "bN";
		}
		// TODO Auto-generated constructor stub
	}

}
