package game;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;



public class Labirynt extends JPanel {

	int[][] maze;
	
	int rows = 31;
	int columns = 41;
	int size = 12;
	
	int height = -1;
	int width = -1;
	int left;
	int top;
	int totalHeight;
	int totalWidth;
	
	public Labirynt(){
		setBackground(Color.black);
		setPreferredSize(new Dimension(size*columns,size*rows));
		
	}
	
	void sprawdzRozmiar() {
		if (getWidth() != width || getHeight()!= height){
			width = getWidth();
			height = getHeight();
			int w = width / columns;
			int h = height / rows;
			left = (width - w*columns) / 2;
			top = (height - h*rows) /2;
			totalWidth = w*columns;
			totalWidth = h*rows;
		}
	}
	
	
	
	
}
