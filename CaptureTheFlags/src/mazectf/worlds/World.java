package mazectf.worlds;

import java.awt.Graphics;
import java.util.Random;

import mazectf.Handler;
import mazectf.entities.EntityManager;
import mazectf.entities.creatures.*;
//import mazectf.entities.creatures.PlayerRed;
import mazectf.entities.statics.Flags;
import mazectf.entities.statics.Icon_BlueFlag;
import mazectf.entities.statics.Icon_RedFlag;
import mazectf.gfx.Assets;
//import mazectf.entities.statics.Icon_RedFlag;
import mazectf.tiles.Tile;
import mazectf.utils.Utils;

public class World {

	//private Handler handler;
	private int width, height;
	private int[][] tiles;
	private int[][] aux_tiles;
	//Entities
	private EntityManager entityManager;
	private Flags blue;
	private Flags red;
	private PlayerBlue playerBlue;
	private PlayerRed  playerRed;
	private Icon_RedFlag iconRed;
	private Icon_BlueFlag iconBlue;
	private int winner = 0;
	protected long startTimer = 0;
	//Random
	protected Random random;

	public World(Handler handler, String path){
		//this.handler = handler;
		entityManager = new EntityManager(handler);
		blue = new Flags(handler,"blue",2*32, 2*32);
		red = new Flags(handler,"red", 40*32, 19*32);

		playerBlue = new PlayerBlue(handler, 1*32, 1*32,red,iconRed);
		playerRed  = new PlayerRed(handler, 41*32, 18*32,blue,iconBlue);
		
		entityManager.addPlayerBlue(playerBlue);
		entityManager.addPlayerRed(playerRed);
		entityManager.addEntity(blue);
		entityManager.addEntity(red);

		loadWorld(path);
		
		startTimer = System.currentTimeMillis();
		random = new Random();
	}
	
	public void tick(){
		entityManager.tick();
		
		if(playerBlue.getStatus()){
			//System.out.println(" Player Blue Win!");
			if(this.winner == 0)
				this.winner = 1;
		}
		if(playerRed.getStatus()){
			//System.out.println(" Player Red Win!");
			if(this.winner == 0)
				this.winner = 2;
		}
		
	}
	public void trapGenerator(){
		int aux_x = 0,aux_y=0;
		if((System.currentTimeMillis() - startTimer)>=10000){
			startTimer = System.currentTimeMillis();
			System.out.println("ARMADRILA!");
			tilesClone();
			do{
				aux_x = (random.nextInt(width));
				aux_y = (random.nextInt(height));
			}while(tiles[aux_x][aux_y]!=0);
			aux_tiles[aux_x][aux_y] = 3;
		}
	}
	public void render(Graphics g){
		
		trapGenerator();
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH), (int) (y * Tile.TILEHEIGHT));
			}
		}
		entityManager.render(g);
		
		if(this.winner == 1){
			g.drawImage(Assets.playerBlue_Winner, 200, 100, 1024, 600, null);
		}else if(this.winner == 2){
			g.drawImage(Assets.playerRed_Winner, 200, 100, 1024, 600, null);
		}
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.marbleTile;
		
		//Tile t = Tile.tiles[tiles[x][y]];
		Tile t = Tile.tiles[aux_tiles[x][y]];
		if(t == null)
			return Tile.floorTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		
		tiles = new int[width][height];
		aux_tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 2]);
			}
		}
		tilesClone();
		//aux_tiles = tiles;
	}
	
	public void tilesClone(){
		for(int y = 0; y < height ; y++){
			for(int x = 0; x < width ; x++){
				aux_tiles[x][y] = tiles[x][y];
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
