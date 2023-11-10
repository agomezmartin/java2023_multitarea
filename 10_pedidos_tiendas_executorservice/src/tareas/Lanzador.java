package tareas;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Pedido;
import service.PedidosService;
import service.PedidosServiceFactory;

public class Lanzador {
	static String ruta1="c:\\temp\\pedidos\\tienda1.json";
	static String ruta2="c:\\temp\\pedidos\\tienda2.json";
	static String ruta3="c:\\temp\\pedidos\\tienda3.json";
	public static void main(String[] args) {
		/*new Thread(new TareaPedidos("c:\\temp\\pedidos\\tienda1.json","tienda1")).start();
		new Thread(new TareaPedidos("c:\\temp\\pedidos\\tienda2.json","tienda2")).start();
		new Thread(new TareaPedidos("c:\\temp\\pedidos\\tienda3.json","tienda3")).start();*/
		PedidosService service=PedidosServiceFactory.getPedidosService();
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(()->service.guardarPedidos(service.pedidosTienda(ruta1, "tienda1")));
		executor.submit(()->service.guardarPedidos(service.pedidosTienda(ruta2, "tienda2")));
		executor.submit(()->service.guardarPedidos(service.pedidosTienda(ruta3, "tienda3")));
		
	}

}
