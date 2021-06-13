package board;

import pieces.Piece;

public class OccupiedTile extends Tile {

	Piece pieceOnTile;
	
	public OccupiedTile (int xCoordinate, int yCoordinate) {
		super(xCoordinate, yCoordinate);
	}
	
	@Override
	public boolean isOccupied () {
		return true;
	}
	
	@Override
	public Piece getPiece () {
		return pieceOnTile;
	}
	
	public void setPiece (Piece piece) {
		pieceOnTile = piece;
	}
}
