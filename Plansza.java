import javax.swing.JFrame;

public class Plansza extends JFrame
{
		public Plansza()
		{
			setSize(300,200);
			setTitle("Wielka ucieczka");
		}
		
		public static void main(String[] args)
		{
			Plansza okienko = new Plansza();
			okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			okienko.setVisible(true);
		}
}
