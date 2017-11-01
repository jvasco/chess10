package chess;

/**
 * @authors Jordy Vasco and Nicholas Lelchitsky
 * 
 */

public abstract class Piece {

	boolean white;
	boolean firstMove;
	String name;
	boolean hasMoved;
	public Piece(boolean white)
	{
		this.white = white;
	}
	
	public boolean isFirstMove(){
		return this.firstMove;
	}
	
	public boolean isWhite()
	{
		return this.white;
	}
	public void setIsWhite(boolean white)
	{
		this.white = white;
	}
	public String getName() {
		return name;
	}
	
	public abstract  boolean isValidMove(Piece[][] board, String move);
	
}
