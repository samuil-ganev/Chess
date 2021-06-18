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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JPanel;

import board.Board;
import board.EmptyTile;
import board.OccupiedTile;
import board.Tile;
import pieces.Piece;

public class BoardPanel extends JPanel{
	
	boolean whiteOnTurn = true;
	String MOVE_PATH = "src/resources/sfx/move_sound.wav";
	String CAPTURE_PATH = "src/resources/sfx/capture_sound.wav";
	int margin = 10;
	double imageRatio = 0.9;
	int squareSide = (this.getWidth() - 2 * margin) / 8;
	Piece selectedPiece = null;
	boolean isSelected = false;
	int selectedImageX;
	int selectedImageY;
	Board board;
	Color dark = new Color (224, 123, 57);
	Color light = new Color (235, 139, 66);
	
	public BoardPanel () {
		
		board = new Board ();
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				x = getSquareIndex(x);
				y = getSquareIndex(y);
				
				Tile currTile;
				
				try {
					currTile = board.getTile(x, y);
				} catch (Exception e2) { return; }
				
				boolean isOccupied = currTile.isOccupied();
				if (isSelected) {
					if (selectedPiece.allowedMoves().contains(currTile)) {
						Tile newTile = new OccupiedTile(x, y);
						
						if (whiteOnTurn != selectedPiece.getColor()) {
							return;
						}
							
						if (selectedPiece.name == "b_king" || selectedPiece.name == "w_king" && !selectedPiece.isMoved) {
							
							if (selectedPiece.getColor()) {
								
								if (x == 1) {
									
									Tile newTile2 = new OccupiedTile(2, 7);
									Piece rook = board.getPiece(0, 7);
									newTile2.setPiece(rook);
									board.setTile(0, 7, new EmptyTile(0, 7));
									rook.setTile(newTile2);
									board.setTile(2, 7, newTile2);
									
								} else if (x == 6) {
									
									Tile newTile2 = new OccupiedTile(5, 7);
									Piece rook = board.getPiece(7, 7);
									newTile2.setPiece(rook);
									board.setTile(7, 7, new EmptyTile(7, 7));
									rook.setTile(newTile2);
									board.setTile(5, 7, newTile2);
									
								}
								
							} else {
								
								if (x == 1) {
									
									Tile newTile2 = new OccupiedTile(2, 0);
									Piece rook = board.getPiece(0, 0);
									newTile2.setPiece(rook);
									board.setTile(0, 7, new EmptyTile(0, 0));
									rook.setTile(newTile2);
									board.setTile(2, 0, newTile2);
									
								} else if (x == 6) {
									
									Tile newTile2 = new OccupiedTile(5, 0);
									Piece rook = board.getPiece(7, 0);
									newTile2.setPiece(rook);
									board.setTile(7, 0, new EmptyTile(7, 0));
									rook.setTile(newTile2);
									board.setTile(5, 0, newTile2);
									
								}
								
							}
							
						}
						
						newTile.setPiece(selectedPiece);
						Tile oldTile = selectedPiece.getTile();
						board.setTile(oldTile.getX(), oldTile.getY(), new EmptyTile(oldTile.getX(), oldTile.getY()));
						selectedPiece.setTile(newTile);
						board.setTile(x, y, newTile);
						
						// Pawn to Queen
						
						for (int i=0;i<8;++i) {
							
							// White pieces
							
							if (board.isOccupied(i, 0)) {
								
								Piece piece = board.getPiece(i, 0);
								
								if (piece.getColor() && piece instanceof Pawn) {
									
									Tile newTile2 = new OccupiedTile(i, 0);
									Piece pawn = new Queen(newTile2, true, board, "w_queen");
									newTile2.setPiece(pawn);
									pawn.setTile(newTile2);
									board.setTile(i, 0, newTile2);
									
								}
								
							}
							
						}
						
						for (int i=0;i<8;++i) {
							
							// Black pieces
							
							if (board.isOccupied(i, 7)) {
								
								Piece piece = board.getPiece(i, 7);
								
								if (!piece.getColor() && piece instanceof Pawn) {
									
									Tile newTile2 = new OccupiedTile(i, 7);
									Piece pawn = new Queen(newTile2, false, board, "b_queen");
									newTile2.setPiece(pawn);
									pawn.setTile(newTile2);
									board.setTile(i, 7, newTile2);
									
								}
								
							}
							
						}
						
						if (!board.getPiece(x, y).isMoved) {
							board.getPiece(x, y).isMoved = true;
						}
						
						whiteOnTurn = !whiteOnTurn;
						if (isOccupied) {
							try {
								File file = new File(CAPTURE_PATH);
								AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
								Clip clip = AudioSystem.getClip();
								clip.open(audioStream);
								clip.start();
							} catch (Exception er) {
								er.printStackTrace();
							}
						} else {
							try {
								File file = new File(MOVE_PATH);
								AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
								Clip clip = AudioSystem.getClip();
								clip.open(audioStream);
								clip.start();
							} catch (Exception er) {
								er.printStackTrace();
							}
						}
					}
					isSelected = !isSelected;
					
				}
				repaint();
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
				
				try {
				
					Tile currTile = board.getTile(x, y);
					
					if (!isSelected && currTile.isOccupied()) {
						
						selectedPiece = currTile.getPiece();
						
						if (selectedPiece.getColor() == whiteOnTurn) {
							isSelected = !isSelected;
							selectedImageX = e.getX()- squareSide/4 - margin;
							selectedImageY = e.getY()- squareSide/4 - margin;
						
						}
					
					}
					
				repaint();
			
				} catch (Exception e1) {}
				
			}
			
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if (isSelected ) {
					selectedImageX = e.getX() - squareSide/4 - margin;
					selectedImageY = e.getY() - squareSide/4 - margin;
					repaint();

				}
								
			}
			
		});
		
	}
	
	private void drawPieces (Graphics g) {
		if (isSelected) {
			for (Tile tile : selectedPiece.allowedMoves()) {
				int x = tile.getX();
				int y = tile.getY();
				g.setColor(new Color(0, 0, 0, 75));
				g.fillOval(x * squareSide + margin + (int)(0.3 * squareSide), y * squareSide + margin + (int)(0.3 * squareSide), (int)(0.4 * squareSide),(int)(0.4 * squareSide));
			}
			Image selectedImg = selectedPiece.getImage();
			Image newSelectedImg = selectedImg.getScaledInstance((int) (imageRatio * squareSide), (int) (imageRatio * squareSide), Image.SCALE_DEFAULT);
			g.drawImage(newSelectedImg, selectedImageX, selectedImageY, this);
			
		}
		
		
		for (int i = 0; i < 8; ++i ) {
		
			for (int j = 0; j < 8; ++j) {
			
				if (board.getTile(i, j).isOccupied()) {
					if (isSelected && board.getPiece(i, j)  == selectedPiece) {
						continue;
					}
					if (!isSelected && board.getPiece(i, j)  == selectedPiece) {
						Image img1 = board.getPiece(i, j).getImage();
						Image newImg1 = img1.getScaledInstance((int) (imageRatio * squareSide), (int) (imageRatio * squareSide), Image.SCALE_DEFAULT);
						g.drawImage(newImg1, margin + i * squareSide, margin + j * squareSide, this);
						
					}
					
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
	
	public boolean isWhiteOnTurn () {
		return whiteOnTurn;
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
