package service;

import java.time.LocalDate;
import java.util.List;

import dao.AlumnosDao;
import dao.CursosDao;
import dao.CursosJsonDao;
import dao.DaoFactory;
import model.Alumno;
import model.Curso;

class FormacionServiceImpl implements FormacionService {
	@Override
	public void actualizarDatos() {
		var cursosService=DaoFactory.getCursosDao();
		var alumnosService=DaoFactory.getAlumnosDao();
		var jsonDao=new CursosJsonDao();
		jsonDao.cursos() //recorremos cursos
		.forEach(c->{
			if(!cursosService.existeCurso(c.getIdCurso())){//si curso no está en BD se añade
				cursosService.guardarCurso(c);
			}
			//recorremos alumnos de cada curso
			c.getAlumnos()
			.forEach(a->{
					if(!alumnosService.existeAlumno(a.getDni())) {
						a.setCurso(c.getIdCurso());//le asignamos al alumno el curso al que pertenece antes de guardarlo
						alumnosService.guardarAlumno(a);
					}
			});
		});
	}
	
	
	@Override
	public List<Curso> listadoCursos(){
		var cursosDao=DaoFactory.getCursosDao();
		return cursosDao.cursos();
	}
	
	@Override
	public List<Alumno> alumnosCurso(int idCurso){ //si pasan 0, todos los alumnos
		var alumnosDao =DaoFactory.getAlumnosDao();
		/*if(idCurso==0) {
			return alumnosDao.alumnos();
		}
		return alumnosDao.alumnos(idCurso);*/
		
		return idCurso==0?alumnosDao.alumnos(): alumnosDao.alumnos(idCurso);
		
		
	}
	//devuelve false si no existe o ha fallado la eliminación
	@Override
	public boolean eliminarAlumno(String dni) {
		var alumnosDao =DaoFactory.getAlumnosDao();
		if(!alumnosDao.existeAlumno(dni)) {
			return false; //no existe alumno
		}
		return alumnosDao.eliminarAlumno(dni);
	}


	@Override
	public List<Curso> cursosFechas(LocalDate f1, LocalDate f2) {
		var cursosDao=DaoFactory.getCursosDao();
		LocalDate fMin=f1.isBefore(f2)?f1:f2;
		LocalDate fMax=f1.isBefore(f2)?f2:f1;
		return cursosDao.cursosFechas(fMin, fMax);
	}
}
