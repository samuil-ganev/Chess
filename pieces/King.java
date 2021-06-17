package pieces;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import board.Board;
import board.EmptyTile;
import board.Tile;

public class King extends Piece {
	
	boolean isMoved;
	
	public King (Tile tile, boolean color, Board board, String name) {
		super(tile, color, board, name);
		
		isMoved = false;
		
		if (color) {
			File image = new File("src/resources/images/WK.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			File image = new File("src/resources/images/BK.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean isCastelingPossible(boolean color, boolean type) {
		
		if (!type) {
			
			if (color) {
				
				if (!board.getPiece(0, 7).isMoved) {
					
					for (int i=1;i<4;++i) {
						
						if (board.getTile(i, 7).isOccupied())
							return false;
						
					}
					
					return true;
					
				}
				
			} else {
				
				if (!board.getPiece(0, 0).isMoved) {
					
					for (int i=1;i<4;++i) {
						
						if (board.getTile(i, 0).isOccupied())
							return false;
						
					}
					
					return true;
					
				}
				
			}
			
		} else {
			
			if (color) {
				
				if (!board.getPiece(7, 7).isMoved) {
					
					for (int i=1;i<3;++i) {
						
						if (board.getTile(7-i, 7).isOccupied())
							return false;
						
					}
					
					return true;
					
				}
				
			} else {
				
				if (!board.getPiece(7, 0).isMoved) {
					
					for (int i=1;i<3;++i) {
						
						if (board.getTile(7-i, 0).isOccupied())
							return false;
						
					}
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	public HashSet<Tile> allowedMoves() {
		
		HashSet<Tile> moves = new HashSet<Tile>();
		Tile currTile = this.getTile(); 
		int currX = currTile.getX();
		int currY = currTile.getY();
		
		for (int i=-1;i<2;++i) {
			
			for (int j=-1;j<2;++j) {
				
				try {
				
					if ((!board.getTile(currX + j, currY + i).isOccupied() || board.getTile(currX + j, currY + i).getPiece().getColor() != this.color))// && !board.isTileUnderAttack(currX + j, currY + i, this.color))
						moves.add(board.getTile(currX + j, currY + i));
					
				} catch (Exception e) {}
				
			}
			
		}
		
		if (!isMoved) {
			
			if (isCastelingPossible(this.color, false)) {
				
				if (this.color)
					moves.add(board.getTile(1, 7));
				else
					moves.add(board.getTile(1, 0));
				
			}
			
			if (isCastelingPossible(this.color, true)) {
				
				if (this.color)
					moves.add(board.getTile(6, 7));
				else
					moves.add(board.getTile(6, 0));
				
			}
			
		}
		
		return moves;
		
	}
	
}
