package game;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;



public class Labirynt extends JPanel {

	int[][] maze;
	
	int wiersze = 31;
	int kolumny = 41;
	int rozmiar = 12;
	
	int wysokosc = -1;
	int szerokosc = -1;
	int left;
	int top;
	int calaWysokosc;
	int calaSzerokosc;
	
	public Labirynt(){
		setBackground(Color.black);
		setPreferredSize(new Dimension(rozmiar*kolumny,rozmiar*wiersze));
		
	}
	
	void sprawdzRozmiar() {
		if (wezSzeorkosc() != szerokosc || getWysokosc != wysokosc){
			szerokosc = wezSzerokosc();
			wysokosc = wezWysokosc();
			int s = szerokosc / kolumny;
			int w = wysokosc / wiersze;
			left = (szerokosc - s*kolumny) / 2;
			top = (wysokosc - w*wiersze) /2;
			calaSzerokosc = s*kolumny;
			calaWysokosc = w*wiersze;
		}
	}
	
	
	
	
}
