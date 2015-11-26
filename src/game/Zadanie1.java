package game;
import java.util.TimerTask;
public class Zadanie1 extends TimerTask 
{
  int plansza[][] = new int[10][14];
  int wyjscia[][] = new int[10][14];
  int poz1 = 4;
  int poz2 = 7;
  boolean koniec= false;
  public void run()
		  {
	  
			  if (koniec()== true)
				  {
				  Program.stan = 2;
				  }
	  Program.applet.repaint();
		  }
		  
	public boolean koniec()
		  {
			  for(int i=0; i<plansza.length; i++)
			  {
				  for(int j=0; j<plansza[0].length;j++)
				  {
					if ((wyjscia[i][j]==2)&&(plansza[i][j]!=3))  
					{
						return false;
					}
				  }
			  }
			  return true;
		  }
		  public void zrobPlansze()
		  {
			  int plansza2[][] = {
					{1,1,1,1,1,1,1,1,1,1,1,1,0,0},
					{1,2,2,0,0,1,0,0,0,0,0,1,1,1},
					{1,2,2,0,0,1,0,3,0,0,3,0,0,1},
					{1,2,2,0,0,1,3,1,1,1,1,0,0,1},
					{1,2,2,0,0,3,0,4,0,1,1,0,0,1},
					{1,2,2,0,0,1,0,0,0,0,3,0,1,1},
					{1,1,1,1,1,1,0,1,1,3,0,0,0,1},
					{0,0,1,0,3,0,0,3,0,3,0,3,0,1},
					{0,0,1,0,0,0,0,1,0,0,0,0,0,1},
					{0,0,1,1,1,1,1,1,1,1,1,1,1,1}
			  };
			  for(int i=0; i<plansza.length; i++)
			  {
				  for(int j=0; j<plansza[0].length;j++)
				  {
					  plansza[i][j] = plansza2[i][j];
				  }
			  }
		  
		  
		  for(int i=0; i<plansza.length; i++)
		  {
			  for(int j=0; j<plansza[0].length;j++)
			  {
				  if(plansza[i][j]==2)
				  {
					  plansza[i][j] = 0;
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
				  if (plansza[poz1][poz2-1]==0)
				  {
					  plansza[poz1][poz2-1]=4;
					  plansza[poz1][poz2]=0;
					  poz2--;
				  }
				  else if ((plansza[poz1][poz2-1]==3)&&(plansza[poz1][poz2-2]==0))
				  {
					  plansza[poz1][poz2-2]=3;
					  plansza[poz1][poz2-1]=4;
					  plansza[poz1][poz2]=0;
					  poz2--;
				  }
				  break;
			  case 'p':
				  if (plansza[poz1][poz2+1]==0)
				  {
					  plansza[poz1][poz2+1]=4;
					  plansza[poz1][poz2]=0;
					  poz2++;
				  }
				  else if ((plansza[poz1][poz2+1]==3)&&(plansza[poz1][poz2+2]==0))
				  {
					  plansza[poz1][poz2+2]=3;
					  plansza[poz1][poz2+1]=4;
					  plansza[poz1][poz2]=0;
					  poz2++;
				  }
				  break;
			  case'g':
				  if (plansza[poz1-1][poz2]==0)
				  {
					  plansza[poz1-1][poz2]=4;
					  plansza[poz1][poz2]=0;
					  poz1--;
				  }
				  else if ((plansza[poz1-1][poz2]==3)&&(plansza[poz1-2][poz2]==0))
				  {
					  plansza[poz1-2][poz2]=3;
					  plansza[poz1-1][poz2]=4;
					  plansza[poz1][poz2]=0;
					  poz1--;
				  }
				  break;
			  case 'd':
				  if (plansza[poz1+1][poz2]==0)
				  {
					  plansza[poz1+1][poz2]=4;
					  plansza[poz1][poz2]=0;
					  poz1++;
				  }
				  else if ((plansza[poz1+1][poz2]==3)&&(plansza[poz1+2][poz2]==0))
				  {
					  plansza[poz1+2][poz2]=3;
					  plansza[poz1+1][poz2]=4;
					  plansza[poz1][poz2]=0;
					  poz1++;
				  }
				  break;
			  }
		  }
}
