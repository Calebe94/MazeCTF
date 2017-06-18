package mazectf.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mazectf.Handler;
import mazectf.gfx.Animation;
import mazectf.gfx.Assets;

public class PlayerTwo extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	public PlayerTwo(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
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
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movement
		getInput();
		move();
		//handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		/*
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		*/
	}

	@Override
	public void render(Graphics g) {
		// Sem Camera
		g.drawImage(getCurrentAnimationFrame(), (int) (x - 0), (int) (y - 0), width, height, null);
		/*
		 * Com câmera
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		*/
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
