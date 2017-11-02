package chess;

/**
 * @author Jordy Vasco
 * @author Nicholas Lelchitsky
 * 
 */

public abstract class Piece {

	boolean white;
	String name;
	boolean hasMoved;

	/**
	 * sets the piece to be white or black
	 * 
	 * @param white
	 */

	public Piece(boolean white) {
		this.white = white;
	}

	/**
	 * 
	 * Returns whether or not a piece is white
	 *
	 */

	public boolean isWhite() {
		return this.white;
	}

	public void setIsWhite(boolean white) {
		this.white = white;
	}

	/**
	 * gives the abbreviated name ofa piece
	 * 
	 * @return name of the piece
	 */

	public String getName() {
		return name;
	}

	public abstract boolean isValidMove(Piece[][] board, String move);

}
