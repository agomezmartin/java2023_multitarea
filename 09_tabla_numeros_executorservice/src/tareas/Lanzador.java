package tareas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(new TareaMultiplicar(5));
		executor.submit(new TareaMultiplicar(4));
		executor.submit(new TareaMultiplicar(8));
		
		for(int i=1;i<=10;i++) {
			System.out.println("ejecutando main");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
