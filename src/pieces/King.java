package pieces;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class King extends Piece {
			
	public King(String colour){
			
		if (colour.equals("black")){
			// load black pawn image
			try {
				image = ImageIO.read(new File("src/pieces/black_king.png"))	;
				col = 0;
			} catch(IOException e){
			}
				
		} else {
			// load white pawn image
			try {
				image = ImageIO.read(new File("src/pieces/white_king.png"))	;	
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
		
		// need to check if the squares all around him are accessible
		if (x > 0) {
			if (board[y][x - 1].getCol() != colour) {
				pointList.add(new Point(y, x - 1));
			}
		}
		if (x < 7) {
			if (board[y][x + 1].getCol() != colour) {
				pointList.add(new Point(y, x + 1));
			}
		}
		if (y > 0) {
			if (board[y-1][x].getCol() != colour) {
			pointList.add(new Point(y - 1, x));
			}
		}
		if (y < 7) {
			if (board[y +1][x].getCol() != colour) {
				pointList.add(new Point(y + 1, x));
			}
		}
		if (x > 0 && y > 0) {
			if (board[y -1][x - 1].getCol() != colour) {
			pointList.add(new Point(y - 1, x - 1));
			}
		}
		if (x < 7 && y < 7) {
			if (board[y + 1][x + 1].getCol() != colour) {
				pointList.add(new Point(y + 1, x + 1));
			}
		}
		if (x > 0 && y < 7) {
			if (board[y+1][x-1].getCol() != colour) {
				pointList.add(new Point(y + 1, x - 1));
			}
		}
		if (x < 7 && y > 0) {
			if (board[y-1][x+1].getCol() != colour) {
				pointList.add(new Point(y - 1, x + 1));
			}
		}
		return pointList;
	}

}
