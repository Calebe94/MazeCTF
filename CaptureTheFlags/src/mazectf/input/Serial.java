// package mazectf.input;

// import gnu.io.CommPortIdentifier;
// import gnu.io.NoSuchPortException;
// import gnu.io.PortInUseException;
// import gnu.io.SerialPort;
// import gnu.io.UnsupportedCommOperationException;

// import java.io.*;

// public class Serial{

// 	public boolean accessing = false;

// 	int timeout = 1000;
// 	private CommPortIdentifier idPort;
// 	private String tipoPorta;
// 	private SerialPort porta;
// 	private int baudrate;

// 	public Serial(String whichPort,int bautrate){
// 		this.tipoPorta = whichPort;
// 		this.baudrate = bautrate;
// 	}

// 	public void open(){
// 		try{
// 			idPort = CommPortIdentifier.getPortIdentifier(tipoPorta);
// 			porta = (SerialPort)this.idPort.open("Controle",timeout);
// 			porta.setSerialPortParams(this.baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
// 		}catch(NoSuchPortException e){
// 			System.err.println("Porta "+this.tipoPorta+" não Existe!");
// 			//System.exit(-1);
// 		}catch(PortInUseException e){
// 			System.err.println("Porta "+this.tipoPorta+" já está Aberta!");
// 			System.exit(-1);
// 		}catch(UnsupportedCommOperationException e){
// 			System.err.println("Configuração dos Parâmetros não Suportada!");
// 			System.exit(-1);
// 		}
// 	}

// 	public String read(){
// 		try{
// 			InputStream input =  porta.getInputStream();

// 			BufferedReader in = new BufferedReader(new InputStreamReader(input));
// 			String inputLine;
// 			while(in.readLine()==null);
// 			inputLine = in.readLine();
// 			in.close();
// 			return inputLine;
// 		}catch(IOException e){}
// 		return null;
// 	}
// }
