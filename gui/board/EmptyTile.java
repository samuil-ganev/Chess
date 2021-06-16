package board;

import pieces.Piece;

public class EmptyTile extends Tile{
	
	
	public EmptyTile (int xCoordinate, int yCoordinate) {
		super(xCoordinate, yCoordinate);
	}
	
	@Override
	public boolean isOccupied () {
		return false;
	}
	
	@Override
	public void setPiece (Piece piece) {
	}
	
	@Override
	public Piece getPiece () {
		return null;
	}
}
