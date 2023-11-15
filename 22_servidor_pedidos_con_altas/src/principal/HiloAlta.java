package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Pedido;
import serializacion.DeserializadorFecha;
import service.PedidosService;
import service.PedidosServiceFactory;

public class HiloAlta implements Runnable {
	final Socket socket;
	
	public HiloAlta(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		Gson gson=new GsonBuilder()//GsonBuilder
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha()) //GsonBuilder
				.create();
		PedidosService service=PedidosServiceFactory.getPedidosService();
		try(socket;BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()))){
			//leemos el JSON procedente del cliente
			String json=bf.readLine();
			//lo deserializamos a objeto Java
			Pedido pedido=gson.fromJson(json, Pedido.class);
			//a la base de datos
			service.altaPedido(pedido);
		
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
