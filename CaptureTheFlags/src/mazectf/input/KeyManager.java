package mazectf.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean walk;
	public boolean run;
	public boolean takeFlag;
	public boolean takeFlag1;
	public boolean dropFlag;
	public boolean dropFlag1;
	public boolean start;

	public KeyManager(){
		keys = new boolean[256];
	}

	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		run  = keys[KeyEvent.VK_SPACE];
		walk = keys[KeyEvent.VK_L];
		takeFlag = keys[KeyEvent.VK_Q];
		takeFlag1= keys[KeyEvent.VK_J];
		dropFlag = keys[KeyEvent.VK_E];
		dropFlag1= keys[KeyEvent.VK_K];
		start    = keys[KeyEvent.VK_ENTER];
	}

	@Override
	public void keyPressed(KeyEvent e) {
        try {
            keys[e.getKeyCode()] = true;
            System.out.println("Key Pressed: " + e.getKeyCode());
        } catch (ArrayIndexOutOfBoundsException ex) {
            // Handle the exception (e.g., log it or show an error message)
            System.err.println("An error occurred while processing a key press event: " + ex.getMessage());
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		System.out.println("Key released"+e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
