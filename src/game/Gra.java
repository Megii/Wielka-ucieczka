package game;
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
	public static int WIDTH = 320;
	public static int HEIGHT = 240;
	public static int SCALE = 2;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage background = null;
	
	private Menu menu;
	
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
			if(State == STATE.GAME)
			{
				background = loader.loadImage("/background1.png");
				
			}
			else if(State == STATE.MENU)
			{
				background = loader.loadImage("/background.png");
				
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		menu = new Menu();
		
		
		this.addMouseListener(new MouseInput());
	}
	
	private void tick()
	{
		
	}
	
	public void run()
	{
		init();
		long lastTime = System.nanoTime();
		final double amountofTicks = 60.0;
		double ns = 1000000000 / amountofTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0 ;
		long timer = System.currentTimeMillis();
		
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println(updates + "Ticks, FPS " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public static void main(String[] args)
	{
		Gra game = new Gra();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
		
		 ChatBot chat = new ChatBot(); 
		
	}

}
