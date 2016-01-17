	package game;
	import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
	public class Gra extends Canvas implements Runnable{
			
		public static enum STATE
		{
			MENU,
			GAME,
			CHOICE,
			END,
			LOSE
		}
		
		int x=1;
		int y=1;
		public static STATE State = STATE.MENU;
		public static String TITLE = "Wielka ucieczka";
		public static int WIDTH = 800;
		public static int HEIGHT = 600;
		
		private boolean running = false;
		public static Thread thread;
		
		private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		private BufferedImage background = null;
		private BufferedImage time = null;
		public static BufferedImage wall = null;
		public static BufferedImage floor = null;
		public static BufferedImage batman = null;
		public static BufferedImage clown = null;
		public static BufferedImage woman = null;
		public static BufferedImage superman = null;
		public static BufferedImage koniec = null;
		public static BufferedImage wygrana = null;
		
		public static BufferedImage hero = null;
		private Menu menu;
		public static Maze maze;
		private Choice choice;
		static Zegar zegar;
		
		
		private synchronized void start()
		{
			if(running)
				return;
			
			running = true;
			thread = new Thread(this);
			thread.start();
		}
		
		private synchronized void stop()
		{
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
		
		private void render()
		{
			BufferStrategy bs = this.getBufferStrategy();
			
			if(bs == null){
				createBufferStrategy(3);
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(background, 0, 0,null);
			
			
			
		 if(State == STATE.GAME)
		 {
			maze.render(g);
			
		 }
		 else if(State == STATE.MENU)
		 {
			 menu.render(g);
		 }
		 else if(State == STATE.END)
		 {
			 g.drawImage(wygrana,0,0,null);
		 }
		 else if(State == STATE.CHOICE)
		 {
			 choice.render(g);
		 }
		
		 else if(State == STATE.LOSE){
			 
			 g.drawImage(time,0,0,null);
		 }
		 g.dispose();
		 bs.show();
		 
		}
		
		
		private void init()
		{
			BufferedImageLoader loader = new BufferedImageLoader();
			try
			{
				background = loader.loadImage("/background.png");
				wall = loader.loadImage("/wall.png");
				floor = loader.loadImage("/floor.png");
				batman = loader.loadImage("/batman.png");
				superman = loader.loadImage("/superman.png");
				woman = loader.loadImage("/woman.png");
				clown = loader.loadImage("/clown.png");
				koniec = loader.loadImage("/koniec.png");
				wygrana = loader.loadImage("/wygrana.png");
				time = loader.loadImage("/przegrana.png");
				
			}catch(IOException e){
				e.printStackTrace();
			}
			
			menu = new Menu();
			maze = new Maze();
			choice = new Choice();
			
			
			
			this.addMouseListener(new MouseInput());
			this.addKeyListener(new KeyInput(this));
		}
		
		private void tick()
		{
			
		}
		
		
		public void run()
		{
			init();
			
			while(running)
			{
			
				render();
				if(State == STATE.GAME && zegar.timeRemaining == 0 )
					 State = STATE.LOSE;
				
			}
			
			stop();
		}
		public static void uncover(int x ,int y){
			if(maze.fog[x][y+1]!=maze.board[x][y+1]&& maze.board[x][y+1]!=2)
				maze.fog[x][y+1]=maze.board[x][y+1];
			if(maze.fog[x][y-1]!=maze.board[x][y-1]&& maze.board[x][y-1]!=2)
				maze.fog[x][y-1]=maze.board[x][y-1];
			if(maze.fog[x+1][y]!=maze.board[x+1][y]&& maze.board[x+1][y]!=2)
				maze.fog[x+1][y]=maze.board[x+1][y];
			if(maze.fog[x+1][y+1]!=maze.board[x+1][y+1]&& maze.board[x+1][y+1]!=2)
				maze.fog[x+1][y+1]=maze.board[x+1][y+1];
			if(maze.fog[x+1][y-1]!=maze.board[x+1][y-1]&& maze.board[x+1][y-1]!=22)
				maze.fog[x+1][y-1]=maze.board[x+1][y-1];
			if(maze.fog[x-1][y]!=maze.board[x-1][y]&& maze.board[x-1][y]!=2)
				maze.fog[x-1][y]=maze.board[x-1][y];
			if(maze.fog[x-1][y+1]!=maze.board[x-1][y+1]&& maze.board[x-1][y+1]!=2)
				maze.fog[x-1][y+1]=maze.board[x-1][y+1];
			if(maze.fog[x-1][y-1]!=maze.board[x-1][y-1]&& maze.board[x-1][y-1]!=2)
				maze.fog[x-1][y-1]=maze.board[x-1][y-1];
		}
		public void keyPressed(int key)
		{
			
			if(State == STATE.GAME)
			{
			
			if(key== KeyEvent.VK_LEFT){
				
				if(maze.board[x][y-1]==1)
				{
					maze.fog[x][y-1]=2;
					maze.fog[x][y]=1;
					y--;
					uncover(x,y);
					
				}	
			}
			else if(key == KeyEvent.VK_UP){
				if(maze.board[x-1][y]==1)
				{
					maze.fog[x-1][y]=2;
					maze.fog[x][y]=1;
					x--;
					
					uncover(x,y);
				}	
			}	
			else if (key== KeyEvent.VK_RIGHT){
				if(maze.board[x][y+1]==1)
				{
					maze.fog[x][y+1]=2;
					maze.fog[x][y]=1;
					y++;
					uncover(x,y);
					
				}	
			}
			else if(key == KeyEvent.VK_DOWN){
				
				if(maze.board[x+1][y]==1)
				{
					maze.fog[x+1][y]=2;
					maze.fog[x][y]=1;
					x++;
					uncover(x,y);
					
				}
				else if(maze.board[x+1][y]==3)
				{
					State = STATE.END;
				}
			}
			}
			
			}
			
		
		
		
		public static void main(String[] args)
		{
			Gra game = new Gra();
			
			game.setPreferredSize(new Dimension(WIDTH , HEIGHT ));
			game.setMaximumSize(new Dimension(WIDTH , HEIGHT ));
			game.setMinimumSize(new Dimension(WIDTH , HEIGHT ));
			
			JFrame frame = new JFrame(game.TITLE);
			frame.add(game);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			game.start();
			
			
			
		}
		
	}