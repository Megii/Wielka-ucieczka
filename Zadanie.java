import java.util.Timer;
import java.util.TimerTask;
public class Zadanie extends TimerTask 
{

  TimerExample te = new TimerExample();
  
 
  public void run()
		  {
			  
	  Plansza.applet.repaint();
		  }
		  
}
