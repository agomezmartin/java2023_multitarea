package tareas;

import java.util.concurrent.CopyOnWriteArrayList;

public class Lanzador {

	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> lista=new CopyOnWriteArrayList<>();
		new Thread(new VolcadoLista(1,1000,lista)).start();
		new Thread(new VolcadoLista(1001,2000,lista)).start();
		new Thread(new VolcadoLista(2001,3000,lista)).start();
		
		//una vez terminen las treas tareas, ¿cual es el tamaño
		//de la lista? 3000
		try {
			Thread.sleep(4000);//para dar tiempo a que terminen
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lista.size());
	}

}
