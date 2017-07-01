package mazectf.entities.statics;

import java.awt.Graphics;

import mazectf.Handler;
import mazectf.gfx.Assets;
import mazectf.tiles.Tile;

public class Icon_RedFlag extends StaticEntity {
	
	private boolean visible=false;
	
	public Icon_RedFlag(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 10;
		bounds.height = (int) (height - height / 1.5f);
	}
	
	public boolean getVisible(){
		return this.visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public void setFlagPosition(float x, float y, boolean state){
		setVisible(state);
		setX(x);
		setY(y);
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		// Sem Camera
		if(visible)
			g.drawImage(Assets.IconRedFlag, (int) (x - 0), (int) (y - 0), width, height, null);
	}

}
