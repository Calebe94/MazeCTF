package mazectf.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import mazectf.Handler;
import mazectf.ui.ClickListener;
//import mazectf.input.Buttons;
//import mazectf.input.Gamepad;
//import mazectf.gfx.Assets;
//import mazectf.ui.ClickListener;
import mazectf.ui.UIImageButton;
import mazectf.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	private BufferedImage start;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		try{
			 //start = ImageIO.read(new File("/home/calebe/workspace_neon/CaptureTheFlags/res/textures/Originals/press_start_button.jpg"));
			start = ImageIO.read(new File("res/textures/Originals/press_start_button.jpg"));
		}catch(Exception e){}
		uiManager.addObject(new UIImageButton(450, 200, 500, 100, start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
