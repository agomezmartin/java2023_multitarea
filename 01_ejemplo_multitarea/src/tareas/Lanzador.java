package tareas;

public class Lanzador {

	public static void main(String[] args) {
		//Creamos las dos tareas 
		TareaAscendente ta=new TareaAscendente();
		TareaDescendente td=new TareaDescendente();
		//y las ponemos en ejecución concurrente
		ta.start();
		td.start();
	}

}
