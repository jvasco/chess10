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

}
