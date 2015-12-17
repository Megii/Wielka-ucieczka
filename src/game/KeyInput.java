package game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
public class KeyInput implements KeyListener{
		Gra gra;
		
		public KeyInput(Gra gra){
			this.gra = gra;
		}
		
	@Override
	public void keyPressed(KeyEvent e) {
		
		gra.keyPressed(e);
		
		/*switch(arg0.getKeyCode())
		{
		case 37:
			Gra.go('l');
			break;
		case 38:
			Gra.go('g');
			break;
		case 39:
			Gra.go('p');
			break;
		case 40:
			Gra.go('d');
			break;
		}*/
		
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
