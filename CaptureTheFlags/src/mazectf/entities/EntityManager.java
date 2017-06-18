package mazectf.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import mazectf.Handler;
import mazectf.entities.creatures.PlayerOne;
import mazectf.entities.creatures.PlayerTwo;

public class EntityManager {
	
	private Handler handler;
	private PlayerOne playerOne;
	private PlayerTwo playerTwo;
	private ArrayList<Entity> entities;
	
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	
	public EntityManager(Handler handler){
		this.handler = handler;
		//this.playerOne = player;
		entities = new ArrayList<Entity>();
		//addEntity(player);
	}
	
	public void tick(){
		for(int i = 0;i < entities.size();i++){
			Entity e = entities.get(i);
			e.tick();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
	}
	
	public void addPlayerOne(PlayerOne player){
		this.playerOne = player;
		this.entities.add(player);
	}

	public void addPlayerTwo(PlayerTwo player){
		this.playerTwo = player;
		this.entities.add(player);
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	//GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public PlayerOne getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(PlayerOne playerOne) {
		this.playerOne = playerOne;
	}
	
	public PlayerTwo getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(PlayerTwo player) {
		this.playerTwo = player;
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
