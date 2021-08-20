package mazectf;


public class Launcher {

	public static void main(String[] args){
		Game game = new Game("MazeCTF: GOTY Edition", 1366, 768);
		//Game game = new Game("MazeCTF: GOTY Edition", 1024, 600);
		game.start();
	}
}
