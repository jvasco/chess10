package chess;

public class Piece {

	boolean white;
	boolean firstMove;
	String name;
	
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
	
	public String getName(){
		return this.name;
	}
	 
}
