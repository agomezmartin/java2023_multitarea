package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Curso;
import service.FormacionService;
import service.FormacionServiceFactory;

public class ListaCursosModel extends DefaultComboBoxModel<Curso> {
	List<Curso> cursos;
	public ListaCursosModel() {
		cursos=new ArrayList<>(FormacionServiceFactory.getFormacionService().listadoCursos());
		cursos.add(0, new Curso(0,"-Todos-",0,0,null,null));
	}
	@Override
	public int getSize() {
		return cursos.size();
	}
	@Override
	public Curso getElementAt(int index) {
		return cursos.get(index);
	}
	
	
}
