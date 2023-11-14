package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClienteSaludo {

	public static void main(String[] args) throws IOException{
		//Crear objeto Socket
		try(Socket socket=new Socket("localhost",8000);
		//entrada salida
		InputStream input=socket.getInputStream();
		PrintStream out=new PrintStream(socket.getOutputStream());
		BufferedReader bf=new BufferedReader(new InputStreamReader(input));){
			//primero enviamos el nombre
			out.println("profe");
			//leemos respuesta
			System.out.println(bf.readLine());
		}

	}

}
