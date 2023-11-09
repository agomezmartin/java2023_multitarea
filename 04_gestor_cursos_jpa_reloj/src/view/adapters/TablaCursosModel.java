package view.adapters;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Curso;
import service.FormacionServiceFactory;

public class TablaCursosModel extends AbstractTableModel {
	List<Curso> cursos;
	final int COLS=4;
	
	public TablaCursosModel(LocalDate f1, LocalDate f2) {
		cursos=FormacionServiceFactory.getFormacionService().cursosFechas(f1, f2);
	}
	@Override
	public int getRowCount() {
		return cursos.size();
	}
	@Override
	public int getColumnCount() {
		
		return COLS;
	}
	@Override
	public String getColumnName(int column) {
		
		switch(column) {
			case 0:
				return "Curso";
			case 1:
				return "Duracion";
			case 2:
				return "Precio";
			case 3:
				return "Fecha inicio";
			default:
				return "Indeterminada";
		}
	}
	@Override
	public Object getValueAt(int row, int column) {
		switch(column) {
			case 0:
				return cursos.get(row).getCurso();
			case 1:
				return cursos.get(row).getDuracion();
			case 2:
				return cursos.get(row).getPrecio();
			case 3:
				return cursos.get(row).getFechaInicio();
			default:
				return null;
		}
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
			case 0:
				return String.class;
			case 1:
				return Integer.class;
			case 2:
				return Double.class;
			case 3:
				return LocalDate.class;
			default:
				return null;
		}
	}
	
	
}
