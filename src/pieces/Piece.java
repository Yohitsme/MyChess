package pieces;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// super class
public class Piece {
		
	protected BufferedImage image;
	protected int col;
	
	public BufferedImage getImage(){
		return image;
	}
	
	public int getCol(){
		return col;
	}

	public ArrayList<Point> getMoves(Piece[][] board, int xBox, int yBox) {
		// a list to store all the possible points that can be taken
		// this will be overriden by each child class, so this will remain
		// empty for now
		ArrayList<Point> pointList = new ArrayList<Point>();
		return pointList;
	}
	
	
	

}
