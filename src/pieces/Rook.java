package pieces;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Rook extends Piece {

	public Rook(String colour) {

		if (colour.equals("black")) {
			// load black pawn image
			try {
				image = ImageIO.read(new File("src/pieces/black_rook.png"));
				col = 0;
			} catch (IOException e) {
			}

		} else {
			// load white pawn image
			try {
				image = ImageIO.read(new File("src/pieces/white_rook.png"));
				col = 1;
			} catch (IOException e) {

			}
		}
	}

	// I will use points as a relative model to positions on the board
	// the x value will represent the column and y value will represent the row
	public ArrayList<Point> getMoves(Piece[][] board, int i, int j) {

		// a list to store all the possible points that can be taken
		ArrayList<Point> pointList = new ArrayList<Point>();
		int x = j;
		int y = i;
		int colour = board[i][j].getCol();

		// rooks can move up/down/left/right all the way through unless blocked

		// left movement, so x must be greater than 0
		while (x > 0) {

			// the square to the left is empty
			if (board[i][x - 1].getCol() == -1) {
				pointList.add(new Point(i, x - 1));
			} else if (board[i][x - 1].getCol() == colour) {
				break;
			}
			// enemy piece
			else {
				pointList.add(new Point(i, x - 1));
				break;
			}
			x--;
		}
		x = j;
		y = i;

		// right movement, x must be less than 7
		while (x < 7) {

			// the square to the left is empty
			if (board[i][x + 1].getCol() == -1) {
				pointList.add(new Point(i, x + 1));
			} else if (board[i][x + 1].getCol() == colour) {
				break;
			}
			// enemy piece
			else {
				pointList.add(new Point(i, x + 1));
				break;
			}
			x++;
		}
		x = j;
		y = i;

		// downward movement, y must be less than 7
		while (y < 7) {

			// the square to the left is empty
			if (board[y + 1][j].getCol() == -1) {
				pointList.add(new Point(y + 1, j));
			} else if (board[y + 1][j].getCol() == colour) {
				break;
			}
			// enemy piece
			else {
				pointList.add(new Point(y + 1, j));
				break;
			}
			y++;
		}
		x = j;
		y = i;

		// upward movement, y must be greater than 0
		while (y > 0) {

			// the square to the left is empty
			if (board[y - 1][j].getCol() == -1) {
				pointList.add(new Point(y - 1, j));
			} else if (board[y - 1][j].getCol() == colour) {
				break;
			}
			// enemy piece
			else {
				pointList.add(new Point(y - 1, j));
				break;
			}
			y--;
		}

		return pointList;
	}

}
