package mazectf.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mazectf.Handler;
import mazectf.entities.statics.Flags;
import mazectf.entities.statics.*;
import mazectf.gfx.Animation;
import mazectf.gfx.Assets;
import mazectf.tiles.Tile;

public class PlayerBlue extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	private Flags flag;
	private Icon_RedFlag Icon;
	private boolean flagCaptured=false;
	private boolean returnWithOponentFlag = false;
	public boolean getStatus(){
		return returnWithOponentFlag;
	}
	public PlayerBlue(Handler handler, float x, float y,Flags flagRed, Icon_RedFlag icon) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.flag = flagRed; 
		this.Icon = icon;
		bounds.x = 22/2;
		bounds.y = 44/2;
		bounds.width = 19/2;
		bounds.height = 19/2;
		
		//Animatons
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
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
		if((handler.getGamepadButtons().A)){
			if(handler.getGamepadButtons().UP    || (handler.getGamepadButtons().ANALOG_Y > 70 ))
				yMove = -speed;
			if(handler.getGamepadButtons().DOWN  || (handler.getGamepadButtons().ANALOG_Y < 30 ))
				yMove = speed;
			if(handler.getGamepadButtons().LEFT  || (handler.getGamepadButtons().ANALOG_X > 70 ))
				xMove = -speed;
			if(handler.getGamepadButtons().RIGHT || (handler.getGamepadButtons().ANALOG_X < 30 ))
				xMove = speed;
		}else if(handler.getGamepadButtons().B){
			if(handler.getGamepadButtons().UP    || (handler.getGamepadButtons().ANALOG_Y > 70 ))
				yMove = -(float)(speed+0.5);
			if(handler.getGamepadButtons().DOWN  || (handler.getGamepadButtons().ANALOG_Y < 30 ))
				yMove = (float)(speed+0.5);
			if(handler.getGamepadButtons().LEFT  || (handler.getGamepadButtons().ANALOG_X > 70 ))
				xMove = -(float)(speed+0.5);
			if(handler.getGamepadButtons().RIGHT || (handler.getGamepadButtons().ANALOG_X < 30 ))
				xMove = (float)(speed+0.5);
		}
		
		if((handler.getGamepadButtons().X) && checkFlagCaptured()){
			//this.flag.setFlagPosition(-32, -32, false);
			//this.flag.setFlagPosition(-32, -32, true);
			long startTimer = System.currentTimeMillis();
			while((System.currentTimeMillis()-startTimer) <= (200)){}
			this.flagCaptured = !this.flagCaptured;
			//this.Icon.setVisible(true);
		}

		if((handler.getGamepadButtons().Y || handler.getGamepadButtons().L) && flagCaptured == true){
			this.flag.setFlagPosition(getX()+10, getY()+10, true);
			this.Icon.setFlagPosition(-32, -32, this.flagCaptured);
			this.flagCaptured = !this.flagCaptured;
			if(base()){
				returnWithOponentFlag = true;
			}
		}
	}
	
	private boolean base(){
		//X 5 Tiles
		//Y 5 Tiles
		if(getX() < 4*Tile.TILEHEIGHT && getY() < 4*Tile.TILEWIDTH){
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
