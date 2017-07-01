package mazectf.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mazectf.Handler;
import mazectf.entities.statics.Flags;
import mazectf.entities.statics.*;
import mazectf.gfx.Animation;
import mazectf.gfx.Assets;
import mazectf.tiles.Tile;

public class PlayerRed extends Creature {
	
	private Animation animDown, animUp, animLeft, animRight;
	private Flags flag;
	//private Icon_BlueFlag Icon;
	private boolean flagCaptured=false;
	private boolean returnWithOponentFlag = false;
	public boolean getStatus(){
		return returnWithOponentFlag;
	}
	public PlayerRed(Handler handler, float x, float y, Flags blueFlag, Icon_BlueFlag icon) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.flag = blueFlag;
		//this.Icon = icon;
		bounds.x = 22/2;
		bounds.y = 44/2;
		bounds.width = 19/2;
		bounds.height = 19/2;
		
		animDown = new Animation(500, Assets.playerTwo_down);
		animUp = new Animation(500, Assets.playerTwo_up);
		animLeft = new Animation(500, Assets.playerTwo_left);
		animRight = new Animation(500, Assets.playerTwo_right);
	}

	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		getInput();
		move();
		/*if(flagCaptured){
			Icon.setX(x+10);
			Icon.setY(y-(32-10));
		}*/
		if(flagCaptured){
			flag.setX(x+10);
			flag.setY(y-(32-10));
		}
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().walk){
			if(handler.getKeyManager().up)
				yMove = -speed;
			if(handler.getKeyManager().down)
				yMove = speed;
			if(handler.getKeyManager().left)
				xMove = -speed;
			if(handler.getKeyManager().right)
				xMove = speed;
		}else if(handler.getKeyManager().run){
			if(handler.getKeyManager().up)
				yMove = -(float)(speed+0.5);
			if(handler.getKeyManager().down)
				yMove = (float)(speed+0.5);
			if(handler.getKeyManager().left)
				xMove = -(float)(speed+0.5);
			if(handler.getKeyManager().right)
				xMove = (float)(speed+0.5);
		}
		if((handler.getKeyManager().takeFlag || handler.getKeyManager().takeFlag1) && (checkFlagCaptured())){
			//this.flag.setFlagPosition(-32, -32, false);
			long startTimer = System.currentTimeMillis();
			while((System.currentTimeMillis()-startTimer) <= (200)){}
			this.flagCaptured = !this.flagCaptured;
			//this.Icon.setVisible(true);
		}
		
		if((handler.getKeyManager().dropFlag || handler.getKeyManager().dropFlag1) && flagCaptured == true){
			this.flag.setFlagPosition(getX()+10, getY()+10, this.flagCaptured);
			//this.Icon.setFlagPosition(-32, -32, this.flagCaptured);
			this.flagCaptured = !this.flagCaptured;
			if(base()){
				returnWithOponentFlag = true;
			}
		}
		
	}
	private boolean base(){
		//X 5 Tiles
		//Y 5 Tiles
		if(getX() > 38*Tile.TILEHEIGHT && getY() > 18*Tile.TILEWIDTH){
			return true;
		}else return false;
	}
	
	private boolean checkFlagCaptured(){
		if((this.flag.getX()+32 > getX()) && (this.flag.getX()-32 < getX()) && (this.flag.getY()+32 > getY()) && (this.flag.getY()-32 < getY())){
			if(this.flag.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xMove, yMove)))
				return true;
			return true;
		}else return false;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - 0), (int) (y - 0), width, height, null);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else{
			return animDown.getCurrentFrame();
		}
	}

}
