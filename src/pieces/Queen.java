package pieces;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Queen extends Piece {
		
	public Queen(String colour){
		
		if (colour.equals("black")){
			// load black pawn image
			try {
				image = ImageIO.read(new File("src/pieces/black_queen.png"))	;	
				col = 0;
			} catch(IOException e){
			}
			
		} else {
			// load white pawn image
			try {
				image = ImageIO.read(new File("src/pieces/white_queen.png"))	;
				col = 1;
			} catch(IOException e){
				
			}	
		}
		
	}
	
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
		
		x = j; y = i;
		
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
