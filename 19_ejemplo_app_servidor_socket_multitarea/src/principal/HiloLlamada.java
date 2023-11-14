package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HiloLlamada implements Runnable {
	final Socket socket;
	public HiloLlamada(Socket socket) {
		super();
		this.socket = socket;
	}
	@Override
	public void run() {
		//recoger el nombre enviado el cliente y enviarle
		//mensaje de saludo personalizado
		try(socket;PrintStream out=new PrintStream(socket.getOutputStream());
			BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));){
			out.println("Hola "+bf.readLine()+", bienvenido al servidor de sockets");
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}
	

}
