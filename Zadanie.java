import java.util.Timer;
import java.util.TimerTask;
public class Zadanie extends TimerTask 
{
  int plansza[][] = new int[10][14];
  int wyjscia[][] = new int[10][14];
  int poz1 = 4;
  int poz2 = 7;
  TimerExample te = new TimerExample();
  
 
  boolean koniec= false;
 
  public void run()
		  {
	  
			  if (koniec()== true)
				  {
				  Plansza.stan = 2;
				  }
			  if (te.timeRemaining ==0){
				  Plansza.stan =3;
			  }
			  
	  Plansza.applet.repaint();
		  }
		  
}
