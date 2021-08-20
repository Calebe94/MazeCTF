package mazectf;

import java.util.ArrayList;

import mazectf.input.Buttons;
import mazectf.input.KeyManager;
import mazectf.input.MouseManager;
import mazectf.gfx.GameCamera;
import mazectf.states.State;
import mazectf.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	private ArrayList<State> states;
	
	private int playerBlueWin = 0, playerRedWin=0;
	private int winner = 0;

	public Handler(Game game){
		this.game = game;
		states = new ArrayList<State>();
	}
	
	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}
	
	public int getPlayerBlueWin() {
		return playerBlueWin;
	}

	public void setPlayerBlueWin(int playerBlueWin) {
		this.playerBlueWin = playerBlueWin;
	}

	public int getPlayerRedWin() {
		return playerRedWin;
	}

	public void setPlayerRedWin(int playerRedWin) {
		this.playerRedWin = playerRedWin;
	}
	
	public ArrayList<State> getStates(){
		return this.states;
	}
	
	public void setStates(ArrayList<State> aux){
		this.states = aux;
	}
	
	public State getState(){
		return this.states.get(0);
	}
	
	public void addWorld(State state){
		this.states.add(state);
	}
	
	public void removeWorld(int index){
		this.states.remove(index);
	}
	/*
	public Buttons getGamepadButtons(){
		return this.game.getGamepadButtons();
	}*/
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}

}
