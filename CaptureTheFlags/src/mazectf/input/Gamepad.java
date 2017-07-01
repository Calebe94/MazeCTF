package mazectf.input;

public class Gamepad extends Thread{
	private String commands;

	private Serial serial;
	
	public Gamepad() {
		this.serial = new Serial("/dev/ttyACM0", 19200);
		serial.open();
	}
	
	public String getCommands() {
		return commands;
	}
	public void setCommands(String commands) {
		this.commands = commands;
	}
	@Override
	public void run() {
		super.run();
		while(true){
			String values = this.serial.read();
			setCommands(values);
		}
	}
}
