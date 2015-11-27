package game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Maze extends JPanel {

	int[][] board={
			{3,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0},
			{0,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0},
			{0,1,1,1,1,1,1,1,0,0,0,0,1,0,0,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,1},
			{1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1},
			{1,0,1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,1,0,1},
			{1,1,1,1,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1},
			{0,0,0,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1},
			{0,1,1,1,1,0,1,0,0,1,0,1,0,1,1,0,1,0,1},
			{0,1,1,1,1,0,1,0,0,1,0,1,0,0,0,0,1,0,1},
			{0,1,0,0,1,0,1,0,0,1,1,1,0,0,0,0,1,0,0},
			{1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,0},
			{1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
			{1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1},
			{1,1,1,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0,1},
			{0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,3}

	  };
	
	int rows = board[0].length;
	int columns = board.length;
	int size = 20;
	
	int height = 1;
	int width = 1;
	int left;
	int top;
	int totalHeight;
	int totalWidth;
		
	
	void render(Graphics g)
	{
		 for(int i=0; i<columns; i++)
		  {
			  for(int j=0; j<rows;j++)
			  {
				  
				  switch(board[i][j])
				  {
				  	case 1:
				  		g.setColor(Color.black);
				  		g.fillRect(i*Gra.WIDTH/columns,j*Gra.HEIGHT/rows, Gra.WIDTH/columns, Gra.HEIGHT/rows);
				  		break;
				  	case 0:
				  		g.setColor(Color.white);
				  		g.fillRect(i*Gra.WIDTH/columns,j*Gra.HEIGHT/rows, Gra.WIDTH/columns, Gra.HEIGHT/rows);
				  		break;
				  	case 3:
				  		g.setColor(Color.green);
				  		g.fillRect(i*Gra.WIDTH/columns,j*Gra.HEIGHT/rows, Gra.WIDTH/columns, Gra.HEIGHT/rows);
				  		break;
				  
				  }
					 
			  }
		  }
	}
	
	
	
}
