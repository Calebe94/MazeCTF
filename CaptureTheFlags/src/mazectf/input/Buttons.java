package mazectf.input;
 
public class Buttons{
	
	public boolean START = false;
	public boolean UP = false;
	public boolean DOWN = false;
	public boolean RIGHT = false;
	public boolean LEFT = false;
	public boolean A = false;
	public boolean B = false;
	public boolean X = false;
	public boolean Y = false;
	public boolean R = false;
	public boolean L = false;
	
	public int ANALOG_X = 0;
	public int ANALOG_Y = 0;
	
	public void checkAction(String actions){
		try{
			String[] buttons = actions.split(";");
			for(String value : buttons){
				String[] button = value.split(":");
				switch(button[0]){
					case "S":
						START = Integer.parseInt(button[1])==1?true:false;
						break;
					case "U":
						UP = Integer.parseInt(button[1])==1?true:false;
						break;
					case "D":
						DOWN = Integer.parseInt(button[1])==1?true:false;
						break;
					case "L":
						LEFT = (Integer.parseInt(button[1])==1?true:false);
						break;
					case "R":
						RIGHT = (Integer.parseInt(button[1])==1?true:false);
						break;
					case "A":
						A = (Integer.parseInt(button[1])==1?true:false);
						break;
					case "B":
						B = (Integer.parseInt(button[1])==1?true:false);
						break;
					case "X":
						X = (Integer.parseInt(button[1])==1?true:false);
						break;
					case "Y":
						Y = (Integer.parseInt(button[1])==1?true:false);
						break;
					case "AL":
						L = (Integer.parseInt(button[1])==1?true:false);
						break;
					case "AR":
						R = (Integer.parseInt(button[1])==1?true:false);
						break;
					case "AX":
						ANALOG_X = Integer.parseInt(button[1]);
						break;
					case "AY":
						ANALOG_Y = (Integer.parseInt(button[1]));
						break;
					default:
						break;
				}
			}
		}catch(NullPointerException e){}
	}
	public Buttons() {
		super();
	}
}
