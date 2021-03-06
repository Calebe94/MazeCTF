package mazectf.entities.statics;

import java.awt.Graphics;

import mazectf.Handler;
import mazectf.gfx.Assets;
import mazectf.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		// Sem Camera
		g.drawImage(Assets.tree, (int) (x - 0), (int) (y - 0), width, height, null);
		/* Com camera
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		*/
	}

}
