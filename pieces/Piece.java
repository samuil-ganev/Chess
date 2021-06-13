package pieces;

import java.awt.Image;
import java.util.HashSet;

import board.Board;
import board.Tile;

public abstract class Piece {
	Tile tile;
	boolean color;
	Board board;
	Image img;

	public Piece(Tile tile, boolean color, Board board) {
		this.tile = tile;
		this.color = color;
		this.board = board;
	}
	
	public boolean getColor() {
		return color;
	}

	public Tile getTile() {
		return tile;
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public Image getImage () {
		return img;
	}
	
	public abstract HashSet<Tile> allowedMoves();
	
	

}
