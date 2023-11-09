package tareas;

public class Lanzador {

	public static void main(String[] args) {
		new Thread(new TareaMultiplicar(5)).start();
		new Thread(new TareaMultiplicar(4)).start();
		new Thread(new TareaMultiplicar(8)).start();
		
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
