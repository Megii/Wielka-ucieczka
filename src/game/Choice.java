package game;

import java.awt.Graphics;

public class Choice {

	public void render(Graphics g)
	{
		int sizeX=Gra.WIDTH/2;
		int sizeY=Gra.HEIGHT/2;
		g.drawImage(Gra.postac1, 0*sizeX,0*sizeY,sizeX,sizeY,null);
		g.drawImage(Gra.krab, 0*sizeX,1*sizeY,sizeX,sizeY,null);
		g.drawImage(Gra.ludzik, 1*sizeX,0*sizeY,sizeX,sizeY,null);
	}

}
