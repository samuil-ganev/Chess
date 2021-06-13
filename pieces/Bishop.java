package pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import board.Board;
import board.Tile;

public class Bishop extends Piece{
	Image img;

	public Bishop (Tile tile, boolean color, Board board) {
		super(tile, color, board);
		if (color) {
			File image = new File("src/resources/WB.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			File image = new File("src/resources/BB.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Image getImage () {
		return img;
	}
	
	public HashSet<Tile> allowedMoves () {

		HashSet<Tile> moves = new HashSet<Tile> ();
		Tile pieceTile = this.getTile();
		int thisX = pieceTile.getX();
		int thisY = pieceTile.getY();
		if (thisX != 0 && thisY != 0) {//move up left
			int xCount = thisX - 1;
			int yCount = thisY - 1;
			while(xCount != 0 && yCount != 0) {
				Tile currTile = board.getTile(xCount, yCount);
				if (!currTile.isOccupied() || (currTile.isOccupied() && currTile.getPiece().getColor() != this.color)) {
					moves.add(currTile);
					--xCount;
					--yCount;
				}else {
					break;
				}
			}
		}
		if (thisX != 0 && thisY != 7) { //move down left
			int xCount = thisX - 1;
			int yCount = thisY + 1;
			while(xCount != 0 && yCount != 7) {
				Tile currTile = board.getTile(xCount, yCount);
				if (!currTile.isOccupied() || (currTile.isOccupied() && currTile.getPiece().getColor() != this.color)) {
					moves.add(currTile);
					--xCount;
					++yCount;
				}else {
					break;
				}
			}
		}
		if (thisX != 7 && thisY != 7) {//move down right
			int xCount = thisX + 1;
			int yCount = thisY + 1;
			while(xCount != 7 && yCount != 7) {
				Tile currTile = board.getTile(xCount, yCount);
				if (!currTile.isOccupied() || (currTile.isOccupied() && currTile.getPiece().getColor() != this.color)) {
					moves.add(currTile);
					++xCount;
					++yCount;
				}else {
					break;
				}
			}
		}
		if (thisX != 7 && thisY != 0) {//move up right
			int xCount = thisX + 1;
			int yCount = thisY - 1;
			while(xCount != 7 && yCount != 0) {
				Tile currTile = board.getTile(xCount, yCount);
				if (!currTile.isOccupied() || (currTile.isOccupied() && currTile.getPiece().getColor() != this.color)) {
					moves.add(currTile);
					++xCount;
					--yCount;
				}else {
					break;
				}
			}
		}
		return moves;
	}
	
	
}
