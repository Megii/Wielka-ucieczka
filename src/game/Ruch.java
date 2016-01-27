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
			{"g", "gora", "góra", "kieruj sie w gore","kieruj sie w górê", "udaj sie w gore","udaj sie w górê", "poruszaj sie do gory", "poruszaj sie do góry","w górê"},
			{"poruszam sie do góry", "zmierzam do góry", "kieruje sie do góry"},
			//dol
			{"d", "dol", "dó³", "kieruj sie w dol", "kieruj sie w dó³","udaj sie w dol","udaj sie w dó³", "poruszaj sie w dol","poruszaj sie w dó³", "w dó³"},
			{"poruszam sie do do³u", "zmierzam do do³u", "kieruje sie do do³u"},
			//przywitanie
			{"czeœæ", "hello", "hej", "dzieñ dobry", "siema", "czesc","hi"},
			{"czeœæ","hello","dzieñ dobry"},
			//pytania
			{"jak siê masz", "co tam", "co u Ciebie","jak sie masz"},
			{"dobrze", "ok"},
			//pomoc
			{"pomoc", "pomocy", "na czym polega gra", "help", "o co chodzi w grze", "jak mam grac"},
			{"gra  polega na poruszaniu siê po labiryncie \n za pomoc¹ poleceñ tekstowych okreœlaj¹cych ruch", "poruszaj postaci¹ za pomoca \n poleceñ tekstowych b¹dŸ strza³ek"},
			//poczatek
			{"chcê na pocz¹tek planszy", "chce na poczatek planszy", "wycofaj siê na pocz¹tek", "wycofaj sie na poczatek", "cofnij sie na poczatek", "cofnij siê na pocz¹tek planszy", "pocz¹tek", "poczatek"},
			{"wycofujê siê na pocz¹tek planszy", "znajdujê siê na pocz¹tku planszy"},
			//cofanie
			{"cofnij", "anuluj","cofnij ruch", "anuluj ruch", "wycofaj siê" },
			{"cofam Twój ostatni ruch", "wycofujê siê"},
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