package mazectf.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile marbleTile = new MarbleTile(0);
	public static Tile floorTile = new FloorTile(1);
	public static Tile graniteTile = new GraniteTile(2);
	public static Tile trapTile = new Trap(3);
	
	//CLASS
	
	public static final int TILEWIDTH = 64/2, TILEHEIGHT = 64/2;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
}
