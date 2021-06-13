package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import board.Board;
import board.EmptyTile;
import board.OccupiedTile;
import board.Tile;
import pieces.Piece;

public class BoardPanel extends JPanel{
	
	int margin = 10;
	double imageRatio = 0.9;
	int squareSide = (this.getWidth() - 2 * margin) / 8;
	Piece selectedPiece = null;
	boolean isSelected = false;
//	int imgX;
//	int imgY;
//	int prevX;
//	int prevY;
//	Point pieceCorner;
//	Point prevPt;
	Board board;
	Color dark = new Color (224, 123, 57);
	Color light = new Color (235, 139, 66);
	
	public BoardPanel () {
		board = new Board ();
		
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
//				currentPiece.setTile(board.getTile(getSquareIndex(e.getX()), getSquareIndex(e.getY())));
//				repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//				int x = e.getX();
//				int y = e.getY();
//				x = getSquareIndex(x);
//				y = getSquareIndex(y);
//				if (board.isOccupied(x, y)) {
//					currentPiece = board.getPiece(x, y);
//				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int y = e.getX();
				int x = e.getY();
				x = getSquareIndex(x);
				y = getSquareIndex(y);
				System.out.println(x + " " + y);
				Tile currTile = board.getTile(x, y);
				if (!isSelected && currTile.isOccupied()) {
					selectedPiece = currTile.getPiece();
					isSelected = !isSelected;
				} else if (isSelected) {
					if (selectedPiece.allowedMoves().contains(currTile)) {
						Tile newTile = new OccupiedTile(x, y);
						newTile.setPiece(selectedPiece);
						Tile oldTile = selectedPiece.getTile();
						board.setTile(oldTile.getX(), oldTile.getY(), new EmptyTile(oldTile.getX(), oldTile.getY()));
						selectedPiece.setTile(newTile);
						board.setTile(x, y, newTile);
					}
					isSelected = !isSelected;
				}
				
				repaint();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
//				if (currentPiece != null) {
//					currentPiece.setTile(board.getTile(getSquareIndex(e.getX()), getSquareIndex(e.getY())));
//					repaint();
//				}
			}
		});
//		ClickListener clickListener = new ClickListener();
//		DragListener dragListener = new DragListener();
//		this.addMouseListener(clickListener);
//		this.addMouseMotionListener(dragListener);
		
	}
	
	private void drawPieces (Graphics g) {
		for (int i = 0; i < 8; ++i ) {
			for (int j = 0; j < 8; ++j) {
				if (board.getTile(i, j).isOccupied()) {
					Image img = board.getPiece(i, j).getImage();
					Image newImg = img.getScaledInstance((int) (imageRatio * squareSide), (int) (imageRatio * squareSide), Image.SCALE_DEFAULT);
					g.drawImage(newImg, margin + j * squareSide, margin + i * squareSide, this);
				}
			}
		}
	}
	
	private int getSquareIndex (int x) {
		return (x - margin)/squareSide;
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		if (this.getHeight() > this. getWidth()) {
			squareSide = (this.getWidth() - 2 * margin) / 8;
		} else {
			squareSide = (this.getHeight() - 2 * margin) / 8;
		}
		super.paintComponent(g); 
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				if (i % 2 == j % 2) {
					g.setColor(light);
					g.fillRect(margin + i * squareSide, margin + j * squareSide, squareSide, squareSide);
				} else {
					g.setColor(dark);
					g.fillRect(margin + i * squareSide, margin + j * squareSide, squareSide, squareSide);
				}
			}
		}
//		int sqX = (imgX - margin)/squareSide;
//		int sqY = (imgY - margin)/squareSide;
//		int newSqX = (prevX - margin)/squareSide;
//		int newSqY = (prevY - margin)/squareSide;
//		if(board.isOccupied(sqX, sqY)) {
//			Piece pc = board.getPiece(sqX, sqY);
//			if(pc.allowedMoves().contains(board.getTile(newSqX, newSqY))) {
//				OccupiedTile destinationTile = new OccupiedTile(newSqX, newSqY);
//				destinationTile.setPiece(pc);
//				pc.setTile(board.getTile(newSqX, newSqY));
//				board.setTile(newSqX, newSqY, destinationTile);
//			}
//		}
		
//		for (int i = 0; i < 8; ++i) {
//			for (int j = 0; j < 8; ++j) {
//				if(pieceCorner)
//			}
//		}
		
		drawPieces(g);
		
		
	}
//	private class ClickListener extends MouseAdapter{
//		
//		public void mousePressed(MouseEvent e) {
////			imgX = e.getX();
////			imgY = e.getY();
////			prevPt = e.getPoint();
//		}
//	}

//	private class DragListener extends MouseMotionAdapter {
//		
//		public void mouseDragged (MouseEvent e) {
//			int currX = e.getX();
//			int currY = e.getY();
//			prevX = currX;
//			prevY = currY;
//			Point currentPt = e.getPoint();
//			   
//			   pieceCorner.translate(
//			     
//			     (int)(currentPt.getX() - prevPt.getX()),
//			     (int)(currentPt.getY() - prevPt.getY())
//			   );
//			   prevPt = currentPt;
//			   repaint();
//		}
//		
//	}
}