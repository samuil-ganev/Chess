import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import board.Board;
import board.Tile;

public class King extends Piece{
	
	boolean isMoved;
	
	public King (Tile tile, boolean color, Board board) {
		super(tile, color, board);
		
		isMoved = false;
		
		if (color) {
			File image = new File("src/resources/WK.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			File image = new File("src/resources/BK.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
		
	}
	
	public HashSet<Tile> allowedMoves() {
		
		HashSet<Tile> moves = new HashSet<Tile> ();
		Tile currTile = this.getTile(); 
		int currX = currTile.getX();
		int currY = currTile.getY();
		
		if (currX != 0 && (!board.getTile(currX - 1 , currY).isOccupied() || board.getTile(currX - 1, currY).getPiece().getColor() != this.color)) {
		
			try {
				
				for (int i=currX-1;i<currX+2;++i) {
					
					for (int j=currY-1;j<currY+2;++j) {
						
						if (!isTileUnderAttack(i, j, color))
							moves.add(new Tile(i, j));
						
					}
					
				}
			
			} catch (Exception e) {}
		
		}
		
		if (!isMoved) {
			
			if (color) {
				
				if (!Board.getTile(0, 0).getPiece().isMoved) {
					
					boolean possibleCastling = true;
					
					for (int i=1;i<4;++i) {
						
						if (Board.getTile(0, i) instanceof EmptyTile) {
							
							possibleCastling = false;
							break;
						
						}
					
					}
					
					if (possibleCastling)
						moves.add(new Tile(0, 1));
				
				}
				
				if (!Board.getTile(0, 7).getPiece().isMoved) {
					
					boolean possibleCastling = true;
					
					for (int i=5;i<7;++i) {
						
						if (Board.getTile(0, i) instanceof EmptyTile) {
							
							possibleCastling = false;
							break;
						
						}
					
					}
					
					if (possibleCastling)
						moves.add(new Tile(0, 6));
				
				}
				
			} else {
				
				if (!Board.getTile(7, 0).getPiece().isMoved) {
					
					boolean possibleCastling = true;
					
					for (int i=1;i<4;++i) {
						
						if (Board.getTile(7, i) instanceof EmptyTile) {
							
							possibleCastling = false;
							break;
						
						}
					
					}
					
					if (possibleCastling)
						moves.add(new Tile(7, 1));
				
				}
				
				if (!Board.getTile(7, 7).getPiece().isMoved) {
					
					boolean possibleCastling = true;
					
					for (int i=5;i<7;++i) {
						
						if (Board.getTile(7, i) instanceof EmptyTile) {
							
							possibleCastling = false;
							break;
						
						}
					
					}
					
					if (possibleCastling)
						moves.add(new Tile(7, 6));
				
				}
				
			}
			
		}
		
		return moves;
	
	}
	
}
