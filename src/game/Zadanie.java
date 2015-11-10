package game;
import java.util.Timer;
import java.util.TimerTask;
public class Zadanie extends TimerTask 
{

  Zegar te = new Zegar();
  
 
  public void run()
		  {
			  
	  Plansza.applet.repaint();
		  }
		  
}
