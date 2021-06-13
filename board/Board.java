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
				tiles[j][i] = new OccupiedTile (j, i);
			}
		}
		for(int i = 0; i < 8; ++i) {
			for(int j = 2; j < 6; ++j) {
				tiles[j][i] = new EmptyTile (j, i);
			}
		}
		for(int i = 0; i < 8; ++i) {
			for(int j = 6; j < 8; ++j) {
				tiles[j][i] = new OccupiedTile (j, i);
			}
		}
		Rook br1 = new Rook(tiles[0][0], false, this);
		Knight bk1 = new Knight(tiles[0][1], false, this);
		Bishop bb1 = new Bishop(tiles[0][2], false, this);
		Queen bq = new Queen(tiles[0][3], false, this);
		King bK = new King(tiles[0][4], false, this);
		Bishop bb2 = new Bishop(tiles[0][5], false, this);
		Knight bk2 = new Knight(tiles[0][6], false, this);
		Rook br2 = new Rook(tiles[0][7], false, this);
		
		tiles[0][0].setPiece(br1);
		tiles[0][1].setPiece(bk1);
		tiles[0][2].setPiece(bb1);
		tiles[0][3].setPiece(bq);
		tiles[0][4].setPiece(bK);
		tiles[0][5].setPiece(bb2);
		tiles[0][6].setPiece(bk2);
		tiles[0][7].setPiece(br2);
		
		for(int i = 0; i < 8; ++i) {
			Pawn pawn = new Pawn(tiles[1][i], false, this);
			tiles[1][i].setPiece(pawn);
		}
		
		Rook wr1 = new Rook(tiles[7][0], true, this);
		Knight wk1 = new Knight(tiles[7][1], true, this);
		Bishop wb1 = new Bishop(tiles[7][2], true, this);
		Queen wq = new Queen(tiles[7][3], true, this);
		King wK = new King(tiles[7][4], true, this);
		Bishop wb2 = new Bishop(tiles[7][5], true, this);
		Knight wk2 = new Knight(tiles[7][6], true, this);
		Rook wr2 = new Rook(tiles[7][7], true, this);
		
		tiles[7][0].setPiece(wr1);
		tiles[7][1].setPiece(wk1);
		tiles[7][2].setPiece(wb1);
		tiles[7][3].setPiece(wq);
		tiles[7][4].setPiece(wK);
		tiles[7][5].setPiece(wb2);
		tiles[7][6].setPiece(wk2);
		tiles[7][7].setPiece(wr2);
		
		for(int i = 0; i < 8; ++i) {
			Pawn pawn = new Pawn(tiles[6][i], true, this);
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
		for(int i = 0; i < 8; ++i) {
			for(int j = 0; j < 8; ++j) {
				if(tiles[i][j].isOccupied() && !color) {
					Piece currPiece = tiles[i][j].getPiece();
					if(currPiece.allowedMoves().contains(tiles[i][j])) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
