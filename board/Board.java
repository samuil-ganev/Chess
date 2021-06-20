package board;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Board {
	Tile [][] tiles = new Tile[8][8];
	
	public Board () {
		for(int i = 0; i < 8; ++i) {
			for(int j = 0; j < 2; ++j) {
				tiles[j][i] = new OccupiedTile (i, j);
			}
		}
		for(int i = 0; i < 8; ++i) {
			for(int j = 2; j < 6; ++j) {
				tiles[j][i] = new EmptyTile (i, j);
			}
		}
		for(int i = 0; i < 8; ++i) {
			for(int j = 6; j < 8; ++j) {
				tiles[j][i] = new OccupiedTile (i, j);
			}
		}
		Rook br1 = new Rook(tiles[0][0], false, this, "b_rook");
		Knight bk1 = new Knight(tiles[0][1], false, this, "b_knight");
		Bishop bb1 = new Bishop(tiles[0][2], false, this, "b_bishop");
		Queen bq = new Queen(tiles[0][3], false, this, "b_queen");
		King bK = new King(tiles[0][4], false, this, "b_king");
		Bishop bb2 = new Bishop(tiles[0][5], false, this, "b_bishop");
		Knight bk2 = new Knight(tiles[0][6], false, this, "b_knight");
		Rook br2 = new Rook(tiles[0][7], false, this, "b_rook");
		
		tiles[0][0].setPiece(br1);
		tiles[0][1].setPiece(bk1);
		tiles[0][2].setPiece(bb1);
		tiles[0][3].setPiece(bq);
		tiles[0][4].setPiece(bK);
		tiles[0][5].setPiece(bb2);
		tiles[0][6].setPiece(bk2);
		tiles[0][7].setPiece(br2);
		
		for(int i = 0; i < 8; ++i) {
			Pawn pawn = new Pawn(tiles[1][i], false, this, "b_pawn");
			tiles[1][i].setPiece(pawn);
		}
		
		Rook wr1 = new Rook(tiles[7][0], true, this, "w_rook");
		Knight wk1 = new Knight(tiles[7][1], true, this, "w_knight");
		Bishop wb1 = new Bishop(tiles[7][2], true, this, "w_bishop");
		Queen wq = new Queen(tiles[7][3], true, this, "w_queen");
		King wK = new King(tiles[7][4], true, this, "w_king");
		Bishop wb2 = new Bishop(tiles[7][5], true, this, "w_bishop");
		Knight wk2 = new Knight(tiles[7][6], true, this, "w_knight");
		Rook wr2 = new Rook(tiles[7][7], true, this, "w_rook");
		
		tiles[7][0].setPiece(wr1);
		tiles[7][1].setPiece(wk1);
		tiles[7][2].setPiece(wb1);
		tiles[7][3].setPiece(wq);
		tiles[7][4].setPiece(wK);
		tiles[7][5].setPiece(wb2);
		tiles[7][6].setPiece(wk2);
		tiles[7][7].setPiece(wr2);
		
		for(int i = 0; i < 8; ++i) {
			Pawn pawn = new Pawn(tiles[6][i], true, this, "w_pawn");
			tiles[6][i].setPiece(pawn);
		}
		
	}

	public Tile getTile (int x, int y) {
		return tiles[y][x];
	}
	
	public void setTile (int x, int y, Tile tile) {
		tiles[y][x] = tile;
	}
	
	public Piece getPiece (int x, int y) {
		return tiles[y][x].getPiece();
	}
	
	public boolean isOccupied (int x, int y) {
		return tiles[y][x].isOccupied();
	}
	
	public boolean isTileUnderAttack (int x, int y, boolean color) {
		
		int a = x, b = y;
			
		while (true) {
			
			--a; --b;
				
			try {
					
				Tile currTile = tiles[b][a];
					
				if (currTile.isOccupied()) {
						
					if (currTile.getPiece().getColor() == color) {
						break;
					} else {
						
						if (currTile.getPiece() instanceof Bishop || currTile.getPiece() instanceof Queen)
							if (currTile.getPiece().allowedMoves().contains(tiles[y][x]))
								return true;
						else
							break;
						
					}
					
						
				}
				
			} catch (Exception e) { break; }
			
		}
		
		a = x; b = y;
		
		while (true) {
			
			++a; --b;
			
			try {
					
				Tile currTile = tiles[b][a];
					
				if (currTile.isOccupied()) {
						
					if (currTile.getPiece().getColor() == color) {
						break;
					} else {
						
						if (currTile.getPiece() instanceof Bishop || currTile.getPiece() instanceof Queen)
							if (currTile.getPiece().allowedMoves().contains(tiles[y][x]))
								return true;
						else
							break;
						
					}
					
						
				}
				
			} catch (Exception e) { break; }
			
		}
		
		a = x; b = y;
		
		while (true) {
			
			--a; ++b;
			
			try {
					
				Tile currTile = tiles[b][a];
					
				if (currTile.isOccupied()) {
						
					if (currTile.getPiece().getColor() == color) {
						break;
					} else {
						
						if (currTile.getPiece() instanceof Bishop || currTile.getPiece() instanceof Queen)
							if (currTile.getPiece().allowedMoves().contains(tiles[y][x]))
								return true;
						else
							break;
						
					}
					
						
				}
				
			} catch (Exception e) { break; }
			
		}
		
		a = x; b = y;
		
		while (true) {
			
			++a; ++b;
			
			try {
					
				Tile currTile = tiles[b][a];
					
				if (currTile.isOccupied()) {
						
					if (currTile.getPiece().getColor() == color) {
						break;
					} else {
						
						if (currTile.getPiece() instanceof Bishop || currTile.getPiece() instanceof Queen)
							if (currTile.getPiece().allowedMoves().contains(tiles[y][x]))
								return true;
						else
							break;
						
					}
					
						
				}
				
			} catch (Exception e) { break; }
			
		}
		
		a = x; b = y;
		
		while (true) {
			
			++a;
			
			try {
				
				Tile currTile = tiles[b][a];
					
				if (currTile.isOccupied()) {
						
					if (currTile.getPiece().getColor() == color) {
						break;
					} else {
						
						if (currTile.getPiece() instanceof Rook || currTile.getPiece() instanceof Queen)
							if (currTile.getPiece().allowedMoves().contains(tiles[y][x]))
								return true;
						else
							break;
						
					}
					
						
				}
				
			} catch (Exception e) { break; }
			
		}
		
		a = x; b = y;
		
		while (true) {
			
			--a;
			
			try {
				
				Tile currTile = tiles[b][a];
					
				if (currTile.isOccupied()) {
						
					if (currTile.getPiece().getColor() == color) {
						break;
					} else {
						
						if (currTile.getPiece() instanceof Rook || currTile.getPiece() instanceof Queen)
							if (currTile.getPiece().allowedMoves().contains(tiles[y][x]))
								return true;
						else
							break;
						
					}
					
						
				}
				
			} catch (Exception e) { break; }
			
		}
		
		a = x; b = y;
		
		while (true) {
			
			++b;
			
			try {
				
				Tile currTile = tiles[b][a];
					
				if (currTile.isOccupied()) {
						
					if (currTile.getPiece().getColor() == color) {
						break;
					} else {
						
						if (currTile.getPiece() instanceof Rook || currTile.getPiece() instanceof Queen)
							if (currTile.getPiece().allowedMoves().contains(tiles[y][x]))
								return true;
						else
							break;
						
					}
					
						
				}
				
			} catch (Exception e) { break; }
			
		}
		
		a = x; b = y;
		
		while (true) {
			
			--b;
			
			try {
				
				Tile currTile = tiles[b][a];
					
				if (currTile.isOccupied()) {
						
					if (currTile.getPiece().getColor() == color) {
						break;
					} else {
						
						if (currTile.getPiece() instanceof Rook || currTile.getPiece() instanceof Queen)
							if (currTile.getPiece().allowedMoves().contains(tiles[y][x]))
								return true;
						else
							break;
						
					}
					
						
				}
				
			} catch (Exception e) { break; }
			
		}
		
		try { if (tiles[x - 1][y + 2].getPiece().getColor() != color && tiles[x - 1][y + 2].getPiece() instanceof Knight) return true; } catch (Exception e) {}
		try { if (tiles[x + 1][y + 2].getPiece().getColor() != color && tiles[x + 1][y + 2].getPiece() instanceof Knight) return true; } catch (Exception e) {}
		try { if (tiles[x - 1][y - 2].getPiece().getColor() != color && tiles[x - 1][y - 2].getPiece() instanceof Knight) return true; } catch (Exception e) {}
		try { if (tiles[x + 1][y - 2].getPiece().getColor() != color && tiles[x + 1][y - 2].getPiece() instanceof Knight) return true; } catch (Exception e) {}
		try { if (tiles[x - 2][y + 1].getPiece().getColor() != color && tiles[x - 2][y + 1].getPiece() instanceof Knight) return true; } catch (Exception e) {}
		try { if (tiles[x + 2][y + 1].getPiece().getColor() != color && tiles[x + 2][y + 1].getPiece() instanceof Knight) return true; } catch (Exception e) {}
		try { if (tiles[x - 2][y - 1].getPiece().getColor() != color && tiles[x - 2][y - 1].getPiece() instanceof Knight) return true; } catch (Exception e) {}
		try { if (tiles[x + 2][y - 1].getPiece().getColor() != color && tiles[x + 2][y - 1].getPiece() instanceof Knight) return true; } catch (Exception e) {}
		
		return false;
			
	}
	
}
