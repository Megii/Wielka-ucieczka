package game;

import java.awt.Graphics;

public class Choice {

	public void render(Graphics g)
	{
		int sizeX=Gra.WIDTH/2;
		int sizeY=Gra.HEIGHT/2;
		g.drawImage(Gra.batman, 0*sizeX,0*sizeY,sizeX,sizeY,null);
		g.drawImage(Gra.superman, 0*sizeX,1*sizeY,sizeX,sizeY,null);
		g.drawImage(Gra.woman, 1*sizeX,0*sizeY,sizeX,sizeY,null);
		g.drawImage(Gra.clown, 1*sizeX,1*sizeY,sizeX,sizeY,null);
	}

}
