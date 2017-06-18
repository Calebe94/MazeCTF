package mazectf.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	//private static final int width = 32, height = 32;
	private static final int width = 63, height = 63;
	private static final int charWidth = 44, charHeight = 52;
	
	public static BufferedImage dirt, grass, stone, tree, rock;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] playerTwo_down, playerTwo_up, playerTwo_left,playerTwo_right;
	public static BufferedImage[] zombie_down, zombie_up, zombie_left, zombie_right;
	public static BufferedImage[] blueFlag;
	public static BufferedImage[] redFlag; 
	public static BufferedImage[] btn_start;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		//btn_start = new BufferedImage[2];
		//btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
		//btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
		
		player_down = new BufferedImage[3];
		player_up = new BufferedImage[3];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		
		player_down[0] = sheet.crop(0,			 	((width*2)+10), charWidth, charHeight-10);
		player_down[1] = sheet.crop(charWidth+5, 	((width*2)+10), charWidth, charHeight-10);
		player_down[2] = sheet.crop((charWidth+5)*2,((width*2)+10), charWidth, charHeight-10);

		player_left[0] = sheet.crop(0, 				((width*2)+10+charWidth), charWidth, charHeight-10);
		player_left[1] = sheet.crop(charWidth+5, 	((width*2)+10+charWidth), charWidth, charHeight-10);
		player_left[2] = sheet.crop((charWidth+5)*2,((width*2)+10+charWidth), charWidth, charHeight-10);
		
		player_right[0] = sheet.crop(0, 				((width*2)+10+(2*charWidth)), charWidth, charHeight-10);
		player_right[1] = sheet.crop(charWidth+5, 		((width*2)+10+(2*charWidth)), charWidth, charHeight-10);
		player_right[2] = sheet.crop((charWidth+5)*2,	((width*2)+10+(2*charWidth)), charWidth, charHeight-10);

		player_up[0] = sheet.crop(0, 				((width*2)+10+(3*charWidth)), charWidth, charHeight-10);
		player_up[1] = sheet.crop(charWidth+5, 		((width*2)+10+(3*charWidth)), charWidth, charHeight-10);
		player_up[2] = sheet.crop((charWidth+5)*2,  ((width*2)+10+(3*charWidth)), charWidth, charHeight-10);
		

		playerTwo_down = new BufferedImage[3];
		playerTwo_up = new BufferedImage[3];
		playerTwo_left = new BufferedImage[3];
		playerTwo_right = new BufferedImage[3];
		
		playerTwo_down[0] = sheet.crop((charWidth+5)*3,((width*2)+10), charWidth, charHeight-10);
		playerTwo_down[1] = sheet.crop((charWidth+5)*4,((width*2)+10), charWidth, charHeight-10);
		playerTwo_down[2] = sheet.crop((charWidth+5)*5,((width*2)+10), charWidth, charHeight-10);
		

		playerTwo_left[0] = sheet.crop((charWidth+5)*3,((width*2)+10+charWidth), charWidth, charHeight-10);
		playerTwo_left[1] = sheet.crop((charWidth+5)*4,((width*2)+10+charWidth), charWidth, charHeight-10);
		playerTwo_left[2] = sheet.crop((charWidth+5)*5,((width*2)+10+charWidth), charWidth, charHeight-10);
		
		playerTwo_right[0] = sheet.crop((charWidth+5)*3,((width*2)+10+(2*charWidth)), charWidth, charHeight-10);
		playerTwo_right[1] = sheet.crop((charWidth+5)*4,((width*2)+10+(2*charWidth)), charWidth, charHeight-10);
		playerTwo_right[2] = sheet.crop((charWidth+5)*5,((width*2)+10+(2*charWidth)), charWidth, charHeight-10);

		playerTwo_up[0] = sheet.crop((charWidth+5)*3,((width*2)+10+(3*charWidth)), charWidth, charHeight-10);
		playerTwo_up[1] = sheet.crop((charWidth+5)*4,((width*2)+10+(3*charWidth)), charWidth, charHeight-10);
		playerTwo_up[2] = sheet.crop((charWidth+5)*5,((width*2)+10+(3*charWidth)), charWidth, charHeight-10);
		
		blueFlag = new BufferedImage[8];
		
		blueFlag[0] = sheet.crop(261, 33, 24, 51);
		blueFlag[1] = sheet.crop(286, 33, 24, 51);
		blueFlag[2] = sheet.crop(311, 33, 24, 51);
		blueFlag[3] = sheet.crop(336, 33, 24, 51);
		blueFlag[4] = sheet.crop(361, 33, 24, 51);
		blueFlag[5] = sheet.crop(386, 33, 24, 51);
		blueFlag[6] = sheet.crop(411, 33, 24, 51);
		blueFlag[7] = sheet.crop(436, 33, 24, 51);
		
		redFlag = new BufferedImage[8];
		
		redFlag[0] = sheet.crop(261, 83, 24, 49);
		redFlag[1] = sheet.crop(286, 83, 24, 49);
		redFlag[2] = sheet.crop(311, 83, 24, 49);
		redFlag[3] = sheet.crop(336, 83, 24, 49);
		redFlag[4] = sheet.crop(361, 83, 24, 49);
		redFlag[5] = sheet.crop(386, 83, 24, 49);
		redFlag[6] = sheet.crop(411, 83, 24, 49);
		redFlag[7] = sheet.crop(436, 83, 24, 49);
		
		
		dirt = sheet.crop(2*width, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop((width * 4)+3, 0, 31, 31);
		//tree = sheet.crop(0, 0, width, height * 2);
		rock = sheet.crop(0, height * 2, width, height);
	}
	
}
