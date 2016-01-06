package game;

import java.awt.Graphics;

public class Choice {

	public void render(Graphics g)
	{
		int sizeX=Gra.WIDTH/2;
		int sizeY=Gra.HEIGHT/2;
		g.drawImage(Gra.rycerz, 0*sizeX,0*sizeY,sizeX,sizeY,null);
		g.drawImage(Gra.ninja, 0*sizeX,1*sizeY,sizeX,sizeY,null);
		g.drawImage(Gra.policja, 1*sizeX,0*sizeY,sizeX,sizeY,null);
		g.drawImage(Gra.pirat, 1*sizeX,1*sizeY,sizeX,sizeY,null);
	}

}
