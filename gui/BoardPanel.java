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
	
	boolean whiteOnTurn = true;
	
	int margin = 10;
	double imageRatio = 0.9;
	int squareSide = (this.getWidth() - 2 * margin) / 8;
	Piece selectedPiece = null;
	boolean isSelected = false;
	Board board;
	Color dark = new Color (224, 123, 57);
	Color light = new Color (235, 139, 66);
	
	public BoardPanel () {
		
		board = new Board ();
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				x = getSquareIndex(x);
				y = getSquareIndex(y);
				System.out.println(x + " " + y);
				
				Tile currTile = board.getTile(x, y);
				if (!isSelected && currTile.isOccupied()) {
					selectedPiece = currTile.getPiece();
					isSelected = !isSelected;
					System.out.println(selectedPiece.allowedMoves().toString());
				} else if (isSelected) {
					System.out.println(selectedPiece.allowedMoves().toString());
					if (selectedPiece.allowedMoves().contains(currTile)) {
						Tile newTile = new OccupiedTile(x, y);
						
						if (whiteOnTurn != selectedPiece.getColor())
							return;
						
						newTile.setPiece(selectedPiece);
						Tile oldTile = selectedPiece.getTile();
						board.setTile(oldTile.getX(), oldTile.getY(), new EmptyTile(oldTile.getX(), oldTile.getY()));
						selectedPiece.setTile(newTile);
						board.setTile(x, y, newTile);
						
						whiteOnTurn = !whiteOnTurn;
						
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
				
				
			}
			
		});
		
	}
	
	private void drawPieces (Graphics g) {
		
		for (int i = 0; i < 8; ++i ) {
		
			for (int j = 0; j < 8; ++j) {
			
				if (board.getTile(i, j).isOccupied()) {
					
					//System.out.println(board.getPiece(i, j).name + " " + i + " " + j);
				
					Image img = board.getPiece(i, j).getImage();
					Image newImg = img.getScaledInstance((int) (imageRatio * squareSide), (int) (imageRatio * squareSide), Image.SCALE_DEFAULT);
					g.drawImage(newImg, margin + i * squareSide, margin + j * squareSide, this);
				
				}
			
			}
		
		}
	
	}
	
	private int getSquareIndex (int dimension) {
		return (dimension - margin)/squareSide;
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		
		if (this.getHeight() > this. getWidth())
			squareSide = (this.getWidth() - 2 * margin) / 8;
		else
			squareSide = (this.getHeight() - 2 * margin) / 8;
		
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
		
		drawPieces(g);
		
		
	}
}