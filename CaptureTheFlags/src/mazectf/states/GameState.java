package mazectf.states;

import java.awt.Graphics;

import mazectf.Handler;
import mazectf.worlds.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Handler handler,World world){
		super(handler);
		//world = new World(handler, "res/worlds/world1.txt");
		//world = new World(handler, "res/worlds/Maze1.txt");
		this.world = world;
		//handler.addWorld(new World(handler, "res/worlds/Maze1.txt"));
		//handler.addWorld(new World(handler, "res/worlds/Maze2.txt"));
		//handler.addWorld(new World(handler, "res/worlds/Maze3.txt"));
		//world = new World(handler, "res/worlds/Maze3.txt");
		
		handler.setWorld(this.world);
	}
	
	@Override
	public void tick() {
		this.world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
