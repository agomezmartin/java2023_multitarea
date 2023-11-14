package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSaludo {

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(8000);
		
		while(true) {
			System.out.println("Esperando llamadas...");
			try(Socket socket=server.accept();
				//operaciones entrada/salida
				OutputStream os=socket.getOutputStream();
				PrintStream out=new PrintStream(os);
				BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()))){
					//leemos el nombre
					String name=bf.readLine();
					//escribimos
					out.println("Hola "+name+", soy el servidor de sockets");
					System.out.println("Enviado mensaje a "+name);
			}
		}
	}

}
