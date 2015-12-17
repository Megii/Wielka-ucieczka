/*package game;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
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
		g.drawImage(background, 0, 0,getWidth(),getHeight(),null);
		
		
		
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
		}catch(IOException e){
			e.printStackTrace();
		}
		
		menu = new Menu();
		maze = new Maze();
		
		
		this.addMouseListener(new MouseInput());
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
				maze.board[x][y-1]=1;
				y--;
			}	
		}
		else if(key == KeyEvent.VK_UP){
			if(maze.board[x+1][y]==1)
			{
				maze.board[x+1][y]=2;
				maze.board[x+1][y]=1;
				x++;
			}	
		}	
		else if (key== KeyEvent.VK_RIGHT){
			if(maze.board[x][y+1]==1)
			{
				maze.board[x][y+1]=2;
				maze.board[x][y+1]=1;
				y++;
			}	
		}
		else if(key == KeyEvent.VK_DOWN){
			if(maze.board[x-1][y]==1)
			{
				maze.board[x-1][y]=2;
				maze.board[x-1][y]=1;
				x--;
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