import javax.swing.JFrame;


public class Gra {
	
	public static Gra gra;
	JFrame frame;
	
	
	public static String tytul = "Wielka ucieczka";
	public static int szerokosc = 14*40;
	public static int wysokosc = 10*40;
	
	public Gra(){
		frame = new JFrame();
		frame.setTitle(tytul);
		frame.setSize(szerokosc, wysokosc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		gra = new Gra();
	}

}
