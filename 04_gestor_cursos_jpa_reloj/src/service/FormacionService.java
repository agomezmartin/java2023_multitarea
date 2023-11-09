package service;

import java.time.LocalDate;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	void actualizarDatos();

	List<Curso> listadoCursos();

	List<Alumno> alumnosCurso(int idCurso);

	//devuelve false si no existe o ha fallado la eliminación
	boolean eliminarAlumno(String dni);
	
	List<Curso> cursosFechas(LocalDate f1, LocalDate f2);

}