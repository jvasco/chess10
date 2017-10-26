package chess;

public class Piece {

	boolean white;
	boolean firstMove;
	
	public Piece(boolean isWhite)
	{
		white = isWhite;
	}
	public boolean isFirstMove(){
		return this.firstMove;
	}
	public boolean isWhite()
	{
		return this.white;
	}
	 
}
