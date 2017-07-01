package mazectf.tiles;

import mazectf.gfx.Assets;

public class GraniteTile extends Tile {

	public GraniteTile(int id) {
		super(Assets.granite, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
