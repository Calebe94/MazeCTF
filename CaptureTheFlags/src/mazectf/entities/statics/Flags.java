package mazectf.entities.statics;

import java.awt.Graphics;

import mazectf.Handler;
import mazectf.gfx.Animation;
import mazectf.gfx.Assets;
import mazectf.tiles.Tile;

public class Flags extends StaticEntity{
	
	private Animation flag;

	public Flags(Handler handler,String color, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
		if(color=="blue")
			flag = new Animation(500, Assets.blueFlag);
		else
			flag = new Animation(500, Assets.redFlag);
	}
	
	@Override
	public void tick() {
		flag.tick();
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(flag.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
}
