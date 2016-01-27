package game;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.lang.Math;
public class Ruch  extends JFrame implements KeyListener{

	
	
	JPanel p=new JPanel();
	JTextArea dialog = new JTextArea(10,30);
	JTextArea input= new JTextArea(1,30);

	JScrollPane scroll=new JScrollPane(
			dialog,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
			);


	String[] [] chatBot={
			//prawo
			{"p", "prawo", "skrec w prawo", "poruszaj sie w prawo", "udaj sie w prawo", "w prawo"},
			{"poruszam sie w prawo","zmierzam w prawym kierunku","kieruje sie w prawo"},
			//lewo
			{"l", "lewo", "skrec w lewo","poruszaj sie w lewo", "udaj sie w lewo", "w lewo"},
			{"poruszam sie w lewo", "zmierzam w lewym kierunku", "kieruje sie w lewo"},
			//gora
			{"g", "gora", "g�ra", "kieruj sie w gore","kieruj sie w g�r�", "udaj sie w gore","udaj sie w g�r�", "poruszaj sie do gory", "poruszaj sie do g�ry","w g�r�"},
			{"poruszam sie do g�ry", "zmierzam do g�ry", "kieruje sie do g�ry"},
			//dol
			{"d", "dol", "d�", "kieruj sie w dol", "kieruj sie w d�","udaj sie w dol","udaj sie w d�", "poruszaj sie w dol","poruszaj sie w d�", "w d�"},
			{"poruszam sie do do�u", "zmierzam do do�u", "kieruje sie do do�u"},
			//przywitanie
			{"cze��", "hello", "hej", "dzie� dobry", "siema", "czesc","hi"},
			{"cze��","hello","dzie� dobry"},
			//pytania
			{"jak si� masz", "co tam", "co u Ciebie","jak sie masz"},
			{"dobrze", "ok"},
			//pomoc
			{"pomoc", "pomocy", "na czym polega gra", "help", "o co chodzi w grze", "jak mam grac"},
			{"gra  polega na poruszaniu si� po labiryncie \n za pomoc� polece� tekstowych okre�laj�cych ruch", "poruszaj postaci� za pomoca \n polece� tekstowych b�d� strza�ek"},
			//poczatek
			{"chc� na pocz�tek planszy", "chce na poczatek planszy", "wycofaj si� na pocz�tek", "wycofaj sie na poczatek", "cofnij sie na poczatek", "cofnij si� na pocz�tek planszy", "pocz�tek", "poczatek"},
			{"wycofuj� si� na pocz�tek planszy", "znajduj� si� na pocz�tku planszy"},
			//cofanie
			{"cofnij", "anuluj","cofnij ruch", "anuluj ruch", "wycofaj si�" },
			{"cofam Tw�j ostatni ruch", "wycofuj� si�"},
			//default
			{"nie moge wykonac ruchu", "nie moge sie tam poruszyc"},
			
	};
	
	public static void main(String[] args){
		new Ruch();
	}
	
	public Ruch(){
		super("Porozmawiajmy :)");
		setSize(370,220);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dialog.setEditable(false);
		input.addKeyListener(this);
		
		p.add(scroll);
		p.add(input);
		p.setBackground(new Color(10,20,60));
		add(p);
		setVisible(true);
	    
		}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
			//grab quote
			String quote=input.getText();
			
			input.setText("");
			addText("Ty:\t"+quote);
			
			String[] tab= quote.split(" ");
			quote.trim();
			while(
					quote.charAt(quote.length()-1)=='!' ||
					quote.charAt(quote.length()-1)=='.' ||
					quote.charAt(quote.length()-1)=='?' 
					){
				quote=quote.substring(0, quote.length()-1 );
				quote.trim();
			}
			quote.trim();
		/*	for(int i=0; i <tab.length;i++){
				System.out.println(tab[i]);
			}*/
			
			byte response=0;
			//check for matches
			int j=0; 
			int numb=1;
			while (response==0){
				
				for(int i=0; i <tab.length;i++){
					for(int z=0; z <tab.length;z++){
						if(tab[z].equals("2")){numb =2;break;}
						if(tab[z].equals("3")){numb =3;break;}
						if(tab[z].equals("4")){numb =4;break;}
						if(tab[z].equals("5")){numb =5;break;}
						if(tab[z].equals("6")){numb =6;break;}
						if(tab[z].equals("7")){numb =7;break;}
						if(tab[z].equals("8")){numb =8;break;}
						if(tab[z].equals("9")){numb =9;break;}
						
					}
					
					if(tab[i].equals("prawo")){quote="prawo";break;}
					if(tab[i].equals("lewo")) {quote="lewo";break;}
					if(tab[i].equals("gora")){quote="gora";break;}
					if(tab[i].equals("dol")) {quote="dol";break;}
				}
				if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==0)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					addText("\n");
					for(int move=0;move<numb;move++){
					if(Gra.maze.board[Gra.maze.posX][Gra.maze.posY+1]==1)
					{
						Gra.maze.fog[Gra.maze.posX][Gra.maze.posY+1]=2;
						Gra.maze.fog[Gra.maze.posX][Gra.maze.posY]=1;
						Gra.maze.posY++;
						Gra.uncover(Gra.maze.posX,Gra.maze.posY);
					}
					}
					
				}
				
				else if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==1)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					addText("\n");
					Gra.maze.prevX= Gra.maze.posX;
					Gra.maze.prevY= Gra.maze.posY;
					for(int move=0;move<numb;move++){
					if(Gra.maze.board[Gra.maze.posX][Gra.maze.posY-1]==1)
					{
						Gra.maze.fog[Gra.maze.posX][Gra.maze.posY-1]=2;
						Gra.maze.fog[Gra.maze.posX][Gra.maze.posY]=1;
						Gra.maze.posY--;
						Gra.uncover(Gra.maze.posX,Gra.maze.posY);
					}	
					}
				}
				
				else if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==2)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					addText("\n");
					Gra.maze.prevX= Gra.maze.posX;
					Gra.maze.prevY= Gra.maze.posY;
					for(int move=0;move<numb;move++){
					if(Gra.maze.board[Gra.maze.posX-1][Gra.maze.posY]==1)
					{
						Gra.maze.fog[Gra.maze.posX-1][Gra.maze.posY]=2;
						Gra.maze.fog[Gra.maze.posX][Gra.maze.posY]=1;
						Gra.maze.posX--;
						Gra.uncover(Gra.maze.posX,Gra.maze.posY);
					}	
					}
				}
				
				else if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==3)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					addText("\n");
					Gra.maze.prevX= Gra.maze.posX;
					Gra.maze.prevY= Gra.maze.posY;
					for(int move=0;move<numb;move++){
					if(Gra.maze.board[Gra.maze.posX+1][Gra.maze.posY]==1)
					{
						Gra.maze.fog[Gra.maze.posX+1][Gra.maze.posY]=2;
						Gra.maze.fog[Gra.maze.posX][Gra.maze.posY]=1;
						Gra.maze.posX++;
						Gra.uncover(Gra.maze.posX,Gra.maze.posY);
					}	
					}
				}
		
				else if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==4)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					
				}
				
				else if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==5)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					
				}
			
				else if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==6)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					
				}
				else if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==7)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					addText("\n");
					Gra.maze.fog[Gra.maze.posX][Gra.maze.posY]=1;
					Gra.maze.posX=1;
					Gra.maze.posY=1;
						Gra.maze.fog[Gra.maze.posX][Gra.maze.posY]=2;
					
				}
				
				else if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==8)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					addText("\n");
					Gra.maze.fog[Gra.maze.posX][Gra.maze.posY]=1;
					Gra.maze.fog[Gra.maze.prevX][Gra.maze.prevY]=2;
					
				}
				
				else if(inArray(quote.toLowerCase(),chatBot[j*2]) & j==9)
				{
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n"+Gra.botname+":\t"+chatBot[(j*2)+1][r]);
					
				}
				 j++;
				
if(j*2==chatBot.length-1 && response==0){
	response=1;
}
				
			//default
			if (response==1){
				int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\n"+Gra.botname+":\t"+chatBot[chatBot.length-1][r]);	
				
			}
			
			
				}		
			addText("\n");
		}
		}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText() +str);
	}
	
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for (int i=0; i<str.length;i++){
			if (str[i].equals(in)){
				match=true;
			}
			
		}
		return match;
	}
	}