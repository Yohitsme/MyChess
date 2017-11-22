package pieces;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Bishop extends Piece {

	public Bishop(String colour) {

		if (colour.equals("black")) {
			// load black pawn image
			try {
				image = ImageIO.read(new File("src/pieces/black_bishop.png"));
				col = 0;
			} catch (IOException e) {
			}

		} else {
			// load white pawn image
			try {
				image = ImageIO.read(new File("src/pieces/white_bishop.png"));
				col = 1;
			} catch (IOException e) {

			}
		}

	}

	public ArrayList<Point> getMoves(Piece[][] board, int i, int j) {

		ArrayList<Point> pointList = new ArrayList<Point>();
		int x = j;
		int y = i;
		int colour = board[i][j].getCol();

		// 4 directions that a bishop can move
		
		// bottom right diagonal
		while (x < 7 && y < 7 ) {
			// empty piece
			if (board[y+1][x+1].getCol() == -1) {
				pointList.add(new Point(y+1, x+1));
			}
			else if (board[y+1][x+1].getCol() == colour) {
				break;
			}
			else {
				pointList.add(new Point(y+1, x+1));
				break;
			}
			x++; y++;
		}
		x = j; y = i;
		
		// bottom left diagonal
		while (x > 0 && y < 7 ) {
			// empty piece
			if (board[y+1][x-1].getCol() == -1) {
				pointList.add(new Point(y+1, x-1));
			}
			else if (board[y+1][x-1].getCol() == colour) {
				break;
			}
			else {
				pointList.add(new Point(y+1, x-1));
				break;
			}
			x--; y++;
		}
		x = j; y = i;
		
		// top right diagonal
		while (x < 7 && y > 0 ) {
			// empty piece
			if (board[y-1][x+1].getCol() == -1) {
				pointList.add(new Point(y-1, x+1));
			}
			else if (board[y-1][x+1].getCol() == colour) {
				break;
			}
			else {
				pointList.add(new Point(y-1, x+1));
				break;
			}
			x++; y--;
		}
		x = j; y = i;
		
		// bottom left diagonal
		while (x > 0 && y > 0 ) {
			// empty piece
			if (board[y-1][x-1].getCol() == -1) {
				pointList.add(new Point(y-1, x-1));
			}
			else if (board[y-1][x-1].getCol() == colour) {
				break;
			}
			else {
				pointList.add(new Point(y-1, x-1));
				break;
			}
			x--; y--;
		}
		x = j; y = i;

		return pointList;

	}
}
