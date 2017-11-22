package pieces;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Knight extends Piece {
		
	public Knight(String colour){
		
		if (colour.equals("black")){
			// load black pawn image
			try {
				image = ImageIO.read(new File("src/pieces/black_knight.png"))	;
				col = 0;
			} catch(IOException e){
			}
			
		} else {
			// load white pawn image
			try {
				image = ImageIO.read(new File("src/pieces/white_knight.png"))	;	
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
		
		// l - shape movements, only max 8 possible moves at any point
		
		if (x + 2 <= 7 && y + 1 <= 7) {
			if (board[y+1][x+2].getCol() != colour) {
				pointList.add(new Point(y+1, x+2));
			}
		}
		if (x + 2 <= 7 && y - 1 >= 0) {
			if (board[y-1][x+2].getCol() != colour) {
				pointList.add(new Point(y-1, x+2));
			}
		}
		if (x - 2 >= 0 && y + 1 <= 7) {
			if (board[y+1][x-2].getCol() != colour) {
				pointList.add(new Point(y+1, x-2));
			}
		}
		if (x - 2 >= 0 && y - 1 >= 0) {
			if (board[y-1][x-2].getCol() != colour) {
				pointList.add(new Point(y-1, x-2));
			}
		}
		
		if (y + 2 <= 7 && x + 1 <= 7) {
			if (board[y+2][x+1].getCol() != colour) {
				pointList.add(new Point(y+2, x+1));
			}
		}
		if (y + 2 <= 7 && x - 1 >= 0) {
			if (board[y+2][x-1].getCol() != colour) {
				pointList.add(new Point(y+2, x-1));
			}
		}
		if (y - 2 >= 0 && x + 1 <= 7) {
			if (board[y-2][x+1].getCol() != colour) {
				pointList.add(new Point(y-2, x+1));
			}
		}
		if (y - 2 >= 0 && x - 1 >= 0) {
			if (board[y-2][x-1].getCol() != colour) {
				pointList.add(new Point(y-2, x-1));
			}
		}
	
		return pointList;
		
	}
	

}
