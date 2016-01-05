/*package game;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Gra extends Applet implements Runnable,KeyListener{
		
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
	Image bufor;
	Graphics bg;
	
	static Image background;
	static Image wall;
	static Image floor;
	static Image hero;
	static Applet applet;
	
	private Menu menu;	
	private Maze maze;
	
	public void start ()
	{
		thread = new Thread(this);
		thread.start ();
	}

	public void stop()
	{
		thread.stop();
	}

	public void destroy()
	{
		thread.stop();
	}

	
	/*private void render()
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
	 g.dispose();
	 bs.show();
	 
	}
	
	
	public void init()
	{
		applet = this;
		applet.setSize(800, 600);
		applet.addKeyListener(this);
		bufor = createImage(800, 600);
		bg = bufor.getGraphics();
		
		background = getImage(getDocumentBase(),"background.png");
		wall = getImage(getDocumentBase(),"wall.png");
		floor = getImage(getDocumentBase(),"floor.png");
		hero = getImage(getDocumentBase(),"sciana.png");
		menu = new Menu();
		maze = new Maze();
		
		
		this.addMouseListener(new MouseInput());
		//this.addKeyListener(new KeyInput(this));
	}
	
	
	public void update(Graphics g)
	{
		bg.clearRect(0, 0, 800, 600);
		paint(bg);
		g.drawImage(bufor, 0, 0, applet);
		
	}
	public void paint(Graphics g)
	{
		switch (State)
		{
			case GAME:
				maze.rysuj(g);
				break;
			case MENU:
				menu.rysuj(g);
				break;
		
		
		}
	}
	
	public void run()
	{
		
		while (true)
		{
			//openDeal();
			// repaint applet
			repaint();

		

			
		}
	
	}
	
	public void keyPressed(KeyEvent e)
	{
		
			switch (e.getKeyCode())
			{
			case 37:
				if(maze.board[x][y-1]==1)
				{
					maze.board[x][y-1]=2;
					maze.board[x][y-1]=1;
					y--;
				}	
				break;
			case 38:
				if(maze.board[x-1][y]==1)
				{
					maze.board[x-1][y]=2;
					maze.board[x-1][y]=1;
					x++;
				}	
				break;
			case 39:
				if(maze.board[x][y+1]==1)
				{
					maze.board[x][y+1]=2;
					maze.board[x][y+1]=1;
					y++;
				}
				break;
			case 40:
				if(maze.board[x+1][y]==1)
				{
					maze.board[x+1][y]=2;
					maze.board[x+1][y]=1;
					x--;
				}	
				break;
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	*/
	
	package game;
	import java.awt.Canvas;
	import java.awt.Dimension;
	import java.awt.Graphics;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.awt.image.BufferStrategy;
	import java.awt.image.BufferedImage;
	import java.io.IOException;

	import javax.swing.JFrame;
	public class Gra extends Canvas implements Runnable{
			
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
		
		private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		private BufferedImage background = null;
		public static BufferedImage wall = null;
		public static BufferedImage floor = null;
		public static BufferedImage postac = null;
		public static BufferedImage koniec = null;
		
		private Menu menu;
		private Maze maze;
		
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
				postac = loader.loadImage("/postac.png");
				koniec = loader.loadImage("/koniec.png");
			}catch(IOException e){
				e.printStackTrace();
			}
			
			menu = new Menu();
			maze = new Maze();
			
			
			
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
			}
			stop();
		}
		
		public void keyPressed(KeyEvent e)
		{
			if(State == STATE.GAME)
			{
			int key=e.getKeyCode();
			if(key== KeyEvent.VK_LEFT){
				
				if(maze.board[x][y-1]==1)
				{
					maze.board[x][y-1]=2;
					maze.board[x][y]=1;
					y--;
				}	
			}
			else if(key == KeyEvent.VK_UP){
				if(maze.board[x-1][y]==1)
				{
					maze.board[x-1][y]=2;
					maze.board[x][y]=1;
					x--;
				}	
			}	
			else if (key== KeyEvent.VK_RIGHT){
				if(maze.board[x][y+1]==1)
				{
					maze.board[x][y+1]=2;
					maze.board[x][y]=1;
					y++;
				}	
			}
			else if(key == KeyEvent.VK_DOWN){
				
				if(maze.board[x+1][y]==1)
				{
					maze.board[x+1][y]=2;
					maze.board[x][y]=1;
					x++;
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