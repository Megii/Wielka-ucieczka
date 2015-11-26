package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Menu {
	
	public Rectangle playButton = new Rectangle(Gra.WIDTH /4 + 120, 150,100,50);
	public Rectangle quitButton = new Rectangle(Gra.WIDTH /4 + 120, 350,100,50);
	
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("courier new", Font.BOLD , 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Wielka ucieczka", Gra.WIDTH / 4, 100);
		
		Font fnt1 = new Font("arial",Font.BOLD, 30);
		g.setFont(fnt1);
		g.setColor(Color.white);
		g.drawString("Play", playButton.x + 20,playButton.y+30);
		g.drawString("Quit", quitButton.x + 20,quitButton.y+30);
		
	}

}
