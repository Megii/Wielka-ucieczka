import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import java.util.Timer;
public class Plansza extends Applet  {

	int rozmiar1=14*40;
	int rozmiar2=10*40;
	static Applet applet;
	Zadanie zadanie = new Zadanie();
	Timer timer = new Timer();
	
	
	public void init()
	{
		
			applet.setSize(rozmiar1, rozmiar2);
			applet.setBackground(Color.WHITE);
			timer.scheduleAtFixedRate(zadanie, 20, 20);
			
			
	}
	 
	
	
}
