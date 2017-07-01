package mazectf.tiles;

import mazectf.gfx.Assets;

public class Trap extends Tile {

	public Trap(int id) {
		super(Assets.trap, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
