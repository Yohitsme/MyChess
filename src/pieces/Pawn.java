package pieces;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Pawn extends Piece {

	// allows the pawn to jump two spots in the begining if possible
	public boolean begin;

	public Pawn(String colour) {

		begin = true;

		if (colour.equals("black")) {
			// load black pawn image
			try {
				image = ImageIO.read(new File("src/pieces/black_pawn.png"));
				col = 0;
			} catch (IOException e) {
			}

		} else {
			// load white pawn image
			try {
				image = ImageIO.read(new File("src/pieces/white_pawn.png"));
				col = 1;
			} catch (IOException e) {
			}
		}

	}

	public ArrayList<Point> getMoves(Piece[][] board, int i, int j) {

		// a list to store all the possible points that can be taken
		ArrayList<Point> pointList = new ArrayList<Point>();
		int x = j;
		int y = i;
		int colour = board[i][j].getCol();
		int oppCol;
		if (colour == 0) {
			oppCol = 1;
		} else {
			oppCol = 0;
		}

		// pawn movement depends on colour
		// pawns can only move upwards or diagonal if another piece there
		// black movement
		if (colour == 0) {
			if (y > 0) {
				// including the initial jump
				if (begin) {
					if (board[y - 2][x].getCol() == -1) {
						pointList.add(new Point(y - 2, x));
						begin = false;
					}
				}
				if (board[y - 1][x].getCol() == -1) {
					pointList.add(new Point(y - 1, x));
				}
				if (x > 0) {
					if (board[y - 1][x - 1].getCol() == oppCol) {
						pointList.add(new Point(y - 1, x - 1));
					}
				}
				if (x < 7) {
					if (board[y - 1][x + 1].getCol() == oppCol) {
						pointList.add(new Point(y - 1, x + 1));
					}
				}
			}
		}

		// white pawn movement
		if (colour == 1) {
			if (y < 7) {
				// including the initial jump
				if (begin) {
					if (board[y + 2][x].getCol() == -1) {
						pointList.add(new Point(y + 2, x));
						begin = false;
					}
				}
				if (board[y + 1][x].getCol() == -1) {
					pointList.add(new Point(y + 1, x));
				}
				if (x > 0) {
					if (board[y + 1][x - 1].getCol() == oppCol) {
						pointList.add(new Point(y + 1, x - 1));
					}
				}
				if (x < 7) {
					if (board[y + 1][x + 1].getCol() == oppCol) {
						pointList.add(new Point(y + 1, x + 1));
					}
				}
			}

		}

		return pointList;
	}
}
