package game;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		
		/*public Rectangle playButton = new Rectangle(Gra.WIDTH/2+120, 150,100,50);
		public Rectangle quitButton = new Rectangle(Gra.WIDTH/2+120, 350,100,50);*/
		
		if(Gra.State == Gra.STATE.MENU)
		{
			
		
		//Play Button
		if(mx >= Gra.WIDTH /4 + 120 && mx <= Gra.WIDTH /2 + 220)
		{
			if(my >= 150 && my <= 200)
			{
				Gra.State = Gra.STATE.GAME;
				Ruch chat = new Ruch();
			}
				
		}
		
		//Quit Button
		if(mx >= Gra.WIDTH /4 + 120 && mx <= Gra.WIDTH /2 + 220)
		{
			if(my >= 350 && my <= 400)
			{
				System.exit(1);
			}
				
		}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
