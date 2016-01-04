package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Maze extends JPanel{
  int board[][] = new int[19][18];
  int wyjscia[][] = new int[19][18];
  int x = 0;
  int y = 0;
 
  
 
  boolean koniec= false;
 
  public void run()
		  {
	  
			  if (koniec()== true)
				  {
				  Gra.stan = 2;
				  }
			  
	  Gra.applet.repaint();
		  }
		  
	public boolean koniec()
		  {		
		  
			  for(int i=0; i<board.length; i++)
			  {
				  for(int j=0; j<board[0].length;j++)
				  {
					if ((wyjscia[i][j]==2)&&(board[i][j]!=3))  
					{
						return false;
					}
				  }
			  }
			  return true;
		  }
		  
	public void zrobPlansze()
		  {
			  
			  int board[][] = {
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
			  for(int i=0; i<board.length; i++)
			  {
				  for(int j=0; j<board[0].length;j++)
				  {
					  board[i][j] = board[i][j];
				  }
			  }
		  
		  
		  for(int i=0; i<board.length; i++)
		  {
			  for(int j=0; j<board[0].length;j++)
			  {
				  if(board[i][j]==2)
				  {
					  board[i][j] = 0;
					  wyjscia[i][j] = 2;
				  }
			  }
		  }
	  }
		  
		  public void ruszaj(char gdzie)
		  {
			  switch(gdzie)
			  {
			  case 'l':
				  if(board[x][y-1]==1)
					{
						board[x][y-1]=2;
						board[x][y-1]=1;
						y--;
					}	
				
				  break;
			  case 'p':
				  if(board[x][y+1]==1)
					{
						board[x][y+1]=2;
						board[x][y+1]=1;
						y++;
					}	
				  break;
			  case'g':
				  if(board[x+1][y]==1)
					{
						board[x+1][y]=2;
						board[x+1][y]=1;
						x++;
					}	
				  break;
			  case 'd':
				  if(board[x-1][y]==1)
					{
						board[x-1][y]=2;
						board[x-1][y]=1;
						x--;
					}	
				  break;
			  }

		  }
			
			
			
}





