package game;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
public class Program extends Applet implements KeyListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int rozmiar1=14*40;
	int rozmiar2=10*40;
	static Applet applet;
	Zadanie1 zadanie1 = new Zadanie1();
	Timer timer = new Timer();
	
	Image bufor;
	Graphics bg;
	static int stan = 1;
	
	
	Image sciana;
	
	
	
	
	
	public void init()
	{
			applet = this;
			applet.addKeyListener(this);
			applet.setSize(rozmiar1, rozmiar2);
			applet.setBackground(Color.WHITE);
			bufor = createImage(rozmiar1, rozmiar2);
			bg = bufor.getGraphics();
			timer.scheduleAtFixedRate(zadanie1, 20, 20);
		
			sciana = getImage(getDocumentBase(),"/sciana.gif");
			
			zadanie1.zrobPlansze();
	}
	public void update(Graphics g)
	{
		bg.clearRect(0, 0, rozmiar1, rozmiar2);
		paint(bg);
		g.drawImage(bufor, 0, 0, applet);
		
	}
	public void paint(Graphics g)
	{
		switch (stan)
		{
		case 1:
			
		rysujPlansze(g);
		break;
		
		}
	}
	
	
	public void rysujPlansze(Graphics g)
	{
		
		for(int i=0; i<zadanie1.plansza.length;i++)
		{
				for(int j=0; j<zadanie1.plansza[0].length;j++)
				{
					switch(zadanie1.plansza[i][j])
					{
					case 1:
						g.drawImage(sciana,40*j,40*i,this);
						break;
				
						
					
					}
				}
		}	
	}
		
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode())
		{
		case 37:
			zadanie1.ruszaj('l');
			break;
		case 38:
			zadanie1.ruszaj('g');
			break;
		case 39:
			zadanie1.ruszaj('p');
			break;
		case 40:
			zadanie1.ruszaj('d');
			break;
		
	}
	
	
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
