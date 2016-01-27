package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;

import javax.swing.JPanel;



public class Maze extends JPanel {

	
	int[][] board={
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,2,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0},
			{0,0,1,1,1,1,1,1,1,0,0,0,0,1,0,0,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0},
			{0,1,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,0},
			{0,1,0,1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,0},
			{0,1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			{0,1,0,0,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,0},
			{0,1,0,0,0,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0},
			{0,1,1,1,1,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0},
			{0,0,0,0,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0},
			{0,0,1,1,1,1,0,1,0,0,1,0,1,0,1,1,0,1,0,1,0},
			{0,0,1,1,1,1,0,1,0,0,1,0,1,0,0,0,0,1,0,1,0},
			{0,0,1,0,0,1,0,1,0,0,1,1,1,0,0,0,0,1,0,0,0},
			{0,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,0,0},
			{0,1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1,0},
			{0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0,1,0},
			{0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,3,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  };
	
	int[][] fog={
			{0,0,0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{0,2,1,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{0,0,0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}
	};
	
	int columns = board[0].length;
	int rows = board.length;
	int posX=1;
	int posY=1;
	int prevX=0;
	int prevY=0;
	
	
	
	void render(Graphics g)
	{
		 for(int i=0; i<rows; i++)
		  {
			  for(int j=0; j<columns;j++)
			  {
				  
				  switch(fog[i][j])
				  {
				  	//Printing wall
				  	case 0:
				  		g.drawImage(Gra.wall,j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows+1,null);
				  		break;
				  	//Printing path
				  	case 1:
				  		g.drawImage(Gra.floor,j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows+1,null);
				  		break;
				  	//Printing start and end
				  	case 2:
				  		g.drawImage(Gra.hero,j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows+1,null);
				  		break;
				  	case 3:
				  		g.drawImage(Gra.koniec,j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows+1,null);
				  		break;
				  	case 9:
				  		g.setColor(Color.BLACK);
				  		g.fillRect(j*Gra.WIDTH/columns,i*Gra.HEIGHT/rows, Gra.WIDTH/columns+1, Gra.HEIGHT/rows+1);
				  		break;
				  
				  }
					 
			  }
		  }
	}
	
	
	
}