package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.lang.Math;
public class ChatBot  extends JFrame implements KeyListener{

	JPanel p=new JPanel();
	JTextArea dialog = new JTextArea(10,30);
	JTextArea input= new JTextArea(1,30);
	JScrollPane scroll=new JScrollPane(
			dialog,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
			);



	
	String[] [] chatBot={
			//standard greetings
			{"czeœæ", "hello", "hej", "dzieñ dobry", "siema", "czesc","hi"},
			{"czeœæ","hello","dzieñ dobry"},
			//question greetings
			{"jak siê masz", "co tam", "co u Ciebie","jak sie masz"},
			{"dobrze", "ok"},
			//yes
			{"tak"},
			{"nie"},
			//default
			{"zacznij graæ", "przestañ pisaæ",
				"(Horacy jest niedostêpny)"}
	};
	
	public static void main(String[] args){
		new ChatBot();
	}
	
	public ChatBot(){
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
			quote.trim();
			while(
					quote.charAt(quote.length()-1)=='!' ||
					quote.charAt(quote.length()-1)=='.' ||
					quote.charAt(quote.length()-1)=='?' 
					){
				quote=quote.substring(0, quote.length()-1 );
			}
			quote.trim();
			byte response=0;
			//check for matches
			int j=0; 
			while (response==0){
				if(inArray(quote.toLowerCase(),chatBot[j*2])){
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
				addText("\nHoracy:\t"+chatBot[(j*2)+1][r]);
				}
j++;
if(j*2==chatBot.length-1 && response==0){
	response=1;
}
			}
			//default
			if (response==1){
				int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\nHoracy\t"+chatBot[chatBot.length-1][r]);	
				
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