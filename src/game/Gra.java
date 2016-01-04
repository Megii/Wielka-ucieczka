package game;


import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class Gra extends Applet implements Runnable {
	public static enum STATE
	{
		MENU,
		GAME
	}
	int x=0;
	int y=0;
	public static STATE State = STATE.MENU;
	public static String TITLE = "Wielka ucieczka";
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	
	private boolean running = false;
	private Thread thread;
	

	static int stan = 1;
	static Applet applet;
	Maze maze = new Maze();
	
	Image bufor;
	Graphics bg;
	
	Image background;
	Image wall;
	Image floor;
	
	private Menu menu;

	
	@Override
	public void start()
	{
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop(){
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.start();
		System.exit(1);
		
	}
	
	/*private void render()
	{
		
		
		
		
		
	 if(State == STATE.GAME)
	 {
		maze.render(g);
	 }
	 else if(State == STATE.MENU)
	 {
		 menu.render(g);
	 }
	 g.dispose();
	 bs.show();
	 
	}*/
	
	public void init()
	{
		applet = this;
		applet.setSize(800, 600);
		bufor = createImage(800, 600);
		bg = bufor.getGraphics();
		
		background = getImage(getDocumentBase(),"picture/background.png");
		wall = getImage(getDocumentBase(),"picture/wall.png");
		floor = getImage(getDocumentBase(),"picture/floor.png");
		menu = new Menu();
		maze = new Maze();
		
		
		
		this.addMouseListener(new MouseInput());
		this.addKeyListener(new KeyInput(this));
	}
	public void update(Graphics g)
	{
		bg.clearRect(0, 0, 800, 600);
		paint(bg);
		g.drawImage(bufor, 0, 0, applet);
		
	}
	public void paint(Graphics g)
	{
		switch (stan)
		{
		case 1:
			
		rysujPlansze(g);
		break;
		
		
		}
	}
	
	public void rysujPlansze(Graphics g)
	{
		
		for(int i=0; i<maze.board.length;i++)
		{
				for(int j=0; j<maze.board[0].length;j++)
				{
					/*if(maze.wyjscia[i][j]==2)
					{
						g.drawImage(sianko,40*j,40*i,this);
					}*/
					switch(maze.board[i][j])
					{
					case 1:
						g.drawImage(wall,40*j,40*i,this);
						break;
					case 0:
						g.drawImage(floor,40*j,40*i,this);
						break;
					
					
					}
				}
		}	
	}
	@Override
	public void run() {
        init();
		
		while(running)
		{
		
			start();
		}
		stop();
		
	}

	
	


}
