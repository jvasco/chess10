package chess;

public abstract class Piece {

	boolean white;
	boolean firstMove;
	String name;
	
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
	public abstract String getName();
	public abstract boolean isValidMove(Piece[][] board, String move);
	
}
