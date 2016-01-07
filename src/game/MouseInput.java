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
				Gra.State = Gra.STATE.CHOICE;
				
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
		else if(Gra.State == Gra.STATE.CHOICE)
		{
			//batman
			if(mx >= 0 && mx <= Gra.WIDTH /2)
				if(my >= 0 && my <= Gra.HEIGHT /2)
					Gra.hero = Gra.batman;
			//woman
			if(mx >= Gra.WIDTH /2 && mx <= Gra.WIDTH)
				if(my >= 0 && my <= Gra.HEIGHT /2)
					Gra.hero = Gra.woman;
			//superman
			if(mx >= 0 && mx <= Gra.WIDTH /2)
				if(my >= Gra.HEIGHT /2 && my <= Gra.HEIGHT )
					Gra.hero = Gra.superman;
			//clown
			if(mx >= Gra.WIDTH /2 && mx <= Gra.WIDTH)
				if(my >= Gra.HEIGHT /2 && my <= Gra.HEIGHT )
					Gra.hero = Gra.clown;
			
			Ruch chat = new Ruch();
			Gra.State = Gra.STATE.GAME;
			Gra.zegar = new Zegar();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
