package board;

import pieces.Piece;

public abstract class Tile {
	int xCoordinate;
	int yCoordinate;
	//public static final Tile[][] STANDARD_BOARD = new Tile [8][8];
	
	Tile (int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public abstract boolean isOccupied();
	
	public abstract Piece getPiece ();
	
	public abstract void setPiece(Piece piece);
	
	public int getX () {
		return xCoordinate;
	}
	
	public int getY () {
		return yCoordinate;
	}
}
