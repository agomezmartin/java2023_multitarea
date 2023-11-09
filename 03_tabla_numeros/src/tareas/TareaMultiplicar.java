package tareas;

public class TareaMultiplicar implements Runnable {
	
	private int numero;
	public TareaMultiplicar(int numero) {
		this.numero=numero;
	}

	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(numero+"X"+i+"="+numero*i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
