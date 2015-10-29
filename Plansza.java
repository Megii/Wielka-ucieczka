import java.util.Timer;
public class Plansza   {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int rozmiar1=14*40;
	int rozmiar2=10*40;
	
	Zadanie zadanie = new Zadanie();
	Timer timer = new Timer();
	

	static int stan = 1;

	public void init()
	{
		
		
			timer.scheduleAtFixedRate(zadanie, 20, 20);
			
			
	}
	
	
	
}
