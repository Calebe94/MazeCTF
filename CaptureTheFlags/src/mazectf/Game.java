package mazectf;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import mazectf.display.Display;
import mazectf.gfx.Assets;
import mazectf.input.Buttons;
import mazectf.input.Gamepad;
//import mazectf.gfx.GameCamera; //Camera
import mazectf.input.KeyManager;
import mazectf.input.MouseManager;
import mazectf.states.GameState;
import mazectf.states.MenuState;
import mazectf.states.State;
import mazectf.worlds.World;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public ArrayList<State> states;
	
	public MenuState menuState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private Gamepad gamepad;
	private Buttons buttons;
	
	//Handler
	private Handler handler;
	private boolean pause=false;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		gamepad = new Gamepad();
		buttons = new Buttons();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);

		gamepad.start();
		
		gameState = new GameState(handler,new World(handler, "res/worlds/Maze1.txt"));
		
		menuState = new MenuState(handler);
		
		State.setState(menuState);
		//State.setState(gameState);
	}
	
	private void tick(){
		this.buttons.checkAction(this.gamepad.getCommands());
		keyManager.tick();
		
		if((handler.getKeyManager().start==true) || (handler.getGamepadButtons().START==true)){
			long startTimer = System.currentTimeMillis();
			while((System.currentTimeMillis()-startTimer) <= (500)){}
			pause=!pause;
		}

		if(pause==false){
			if(State.getState() != null)
				State.getState().tick();			
		}
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		if(pause == false){
			if(State.getState() != null)
				State.getState().render(g);
		}else{
			State.getState().render(g);
			g.drawImage(Assets.pause, 200, 100, 1024, 600, null);
		}
		
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	public Buttons getGamepadButtons(){
		return this.buttons;
	}
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
