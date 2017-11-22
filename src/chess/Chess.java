package chess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import pieces.Bishop;
import pieces.Empty;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Chess extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean playing;
	private Piece[][] board; // the board will be mapped by a 2d array
	private int length, width;
	private final int WHITE = 1, BLACK = 0; // used to differentiate between the
											// pieces
	private Color colour1, colour2;
	private Boolean highlight; // whether a piece is highlighted or not
	private int xBox, yBox, newxBox, newyBox; // locates one specific box

	public Chess() {

		colour2 = new Color(139, 69, 19);
		colour1 = new Color(250, 235, 215);
		length = 600;
		width = 600;
		setSize(length, width);
		addMouseListener(this);
		setUp();
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public void setUp() {

		board = new Piece[8][8]; // 8 by 8 2d array of pieces

		// set up the board with the pieces
		highlight = false;

		// all the pawns
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn("white");
			board[6][i] = new Pawn("black");
		}

		// board[0][0] = new Empty();
		// rooks
		board[0][0] = new Rook("white");
		board[0][7] = new Rook("white");
		board[7][0] = new Rook("black");
		board[7][7] = new Rook("black");
		// knights
		board[0][1] = new Knight("white");
		board[0][6] = new Knight("white");
		board[7][1] = new Knight("black");
		board[7][6] = new Knight("black");
		// bishops
		board[0][2] = new Bishop("white");
		board[0][5] = new Bishop("white");
		board[7][2] = new Bishop("black");
		board[7][5] = new Bishop("black");
		// King
		board[0][3] = new King("white");
		board[7][4] = new King("black");
		// Queen
		board[0][4] = new Queen("white");
		board[7][3] = new Queen("black");

		// masking every other piece of the board as an empty piece
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == null) {
					board[i][j] = new Empty();
				}
			}
		}
	}

	// moves a piece from one position to another, does not check for legality
	// of moves
	public void move(int fromX, int fromY, int toX, int toY) {

		board[toX][toY] = board[fromX][fromY];
		board[fromX][fromY] = new Empty();
		highlight = false;
		repaint();

	}


	// method currently in the works
	public void checkMove() {

		// this is the current highlighted move being checked for possible moves
		ArrayList<Point> legalList = board[xBox][yBox].getMoves(board, xBox,
				yBox);

		// check if the new move is within the legal move lists
		// checking if the list is not empty

		if (!legalList.isEmpty()) {
			// iterating through the legal list of moves

			for (Point points : legalList) {
				int pointX = (int) points.getX();
				int pointY = (int) points.getY();

				if (pointX == newxBox && pointY == newyBox) {

					// the move is legal, perform it
					move(xBox, yBox, newxBox, newyBox);

				} else {
					// the move is illegal
					highlight = false;
					repaint();
				}
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// painting the board
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == j % 2) {
					g.setColor(colour1);
					g.fillRect(length / 6 + (j * ((length * 2) / 24)), width
							/ 6 + (i * (width * 2) / 24), (length * 2) / 24,
							(width * 2) / 24);
				} else {
					g.setColor(colour2);
					g.fillRect(length / 6 + (j * ((length * 2) / 24)), width
							/ 6 + (i * (width * 2) / 24), (length * 2) / 24,
							(width * 2) / 24);
				}

				if (board[i][j].getCol() != -1) {
					g.drawImage(board[i][j].getImage(),
							(j * ((length * 2) / 24)) + 94, (width / 6 + (i
									* (width * 2) / 24)) - 5, null);
				}

				Graphics2D g2 = (Graphics2D) g;

				if ((i == xBox) && (j == yBox) && (highlight)) {
					// highlights a box
					g.setColor(Color.green);
					g2.setStroke(new BasicStroke(4));
					g2.drawRect(length / 6 + (j * ((length * 2) / 24)), width
							/ 6 + (i * (width * 2) / 24), (length * 2) / 24,
							(width * 2) / 24);
				}
				g2.setStroke(new BasicStroke(2));
			}
		}

		// border around the board
		g.setColor(Color.black);
		g.drawRect(length / 6, width / 6, length * 2 / 3, width * 2 / 3);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xCord = e.getX();
		int yCord = e.getY();

		// right clicking unhighlights a square
		if (e.getButton() == 3) {
			highlight = false;
			repaint();
			return;
		}

		// first time clicked when no other boxes are clicked
		if (!highlight) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					// checks if mouse clicked within chess board
					if ((xCord >= (length / 6) + 2)
							&& (xCord <= (length - 100) + 2)
							&& (yCord < width - 100) && (yCord >= 102)) {
						// checks every 50 by 50 box
						if ((xCord >= (100 + ((j) * 50)))
								&& (xCord < (100 + ((j + 1) * 50)))) {
							if ((yCord >= (100 + ((i) * 50)))
									&& (yCord < (100 + ((i + 1) * 50)))) {
								if ((board[i][j].getCol() != -1)) {
									xBox = i;
									yBox = j;
									highlight = true;
									repaint();

								}
							}
						}
					}
				}
			}
		}

		// second time clicked when making a move with a highlighted piece
		else if (highlight) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					// checks if mouse clicked within chess board
					if ((xCord >= (length / 6) + 2)
							&& (xCord <= (length - 100) + 2)
							&& (yCord < width - 100) && (yCord >= 102)) {
						// checks every 50 by 50 box
						if ((xCord >= (100 + ((j) * 50)))
								&& (xCord < (100 + ((j + 1) * 50)))) {
							if ((yCord >= (100 + ((i) * 50)))
									&& (yCord < (100 + ((i + 1) * 50)))) {
								newxBox = i;
								newyBox = j;
								checkMove();
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
