/*package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Maze extends JPanel {

	int[][] board={
			{2,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0},
			{0,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0},
			{0,1,1,1,1,1,1,1,0,0,0,0,1,0,0,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,1},
			{1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1},
			{1,0,1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1},
			{1,1,1,1,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1},
			{0,0,0,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1},
			{0,1,1,1,1,0,1,0,0,1,0,1,0,1,1,0,1,0,1},
			{0,1,1,1,1,0,1,0,0,1,0,1,0,0,0,0,1,0,1},
			{0,1,0,0,1,0,1,0,0,1,1,1,0,0,0,0,1,0,0},
			{1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,0},
			{1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
			{1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1},
			{1,1,1,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0,1},
			{0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,2}

	  };
	
	int columns = board[0].length;
	int rows = board.length;
	int size = 12;
	
	int height = -1;
	int width = -1;
	int left;
	int top;
	int totalHeight;
	int totalWidth;
	
	
	
	void rysuj(Graphics g)
	{
		 for(int i=0; i<rows; i++)
		  {
			  for(int j=0; j<columns;j++)
			  {
				  
				  switch(board[i][j])
				  {
				  	//Printing wall
				  	case 0:
				  		g.drawImage(Gra.wall,j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows,null);
				  		break;
				  	//Printing path
				  	case 1:
				  			g.drawImage(Gra.floor,j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows,null);
				  		break;
				  	//Printing start and end
				  	case 2:
				  		g.drawImage(Gra.hero,j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows,null);
				  		break;
				  
				  }
					 
			  }
		  }
	}
	
	
	
}*/
package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Maze extends JPanel {

	int[][] board={
			{2,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0},
			{0,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0},
			{0,1,1,1,1,1,1,1,0,0,0,0,1,0,0,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,1},
			{1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1},
			{1,0,1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1},
			{1,0,0,0,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1},
			{1,1,1,1,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1},
			{0,0,0,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1},
			{0,1,1,1,1,0,1,0,0,1,0,1,0,1,1,0,1,0,1},
			{0,1,1,1,1,0,1,0,0,1,0,1,0,0,0,0,1,0,1},
			{0,1,0,0,1,0,1,0,0,1,1,1,0,0,0,0,1,0,0},
			{1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,0},
			{1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
			{1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1},
			{1,1,1,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0,1},
			{0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,2}

	  };
	
	int columns = board[0].length;
	int rows = board.length;
	int size = 12;
	
	int height = -1;
	int width = -1;
	int left;
	int top;
	int totalHeight;
	int totalWidth;
		
	
	void render(Graphics g)
	{
		 for(int i=0; i<rows; i++)
		  {
			  for(int j=0; j<columns;j++)
			  {
				  
				  switch(board[i][j])
				  {
				  	//Printing wall
				  	case 0:
				  		g.drawImage(Gra.wall,j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows,null);
				  		break;
				  	//Printing path
				  	case 1:
				  	
				  		g.drawImage(Gra.floor,j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows,null);
				  		break;
				  	//Printing start and end
				  	case 2:
				  		g.setColor(Color.green);
				  		g.fillRect(j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows);
				  		break;
				  
				  }
					 
			  }
		  }
	}
	
	
	
}