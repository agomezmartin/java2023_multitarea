package dao;

import static helpers.EntityManagerLocator.getEntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Alumno;
public class AlumnosDaoImpl implements AlumnosDao {
	
	
	@Override
	public boolean existeAlumno(String dni) {

		return getEntityManager().find(Alumno.class, dni)!=null;
	}
	
	@Override
	public boolean guardarAlumno(Alumno alumno) {
		try {
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(alumno);
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean guardarAlumnos(List<Alumno> alumnos) {
		try {
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			for(Alumno alumno:alumnos) {
				em.persist(alumno);
			}
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Alumno> alumnos(){
		EntityManager em=getEntityManager();
		String jpql="select a from Alumno a";
		TypedQuery<Alumno> tq=em.createQuery(jpql,Alumno.class);
		return tq.getResultList();
	}
	@Override
	public List<Alumno> alumnos(int curso){
		EntityManager em=getEntityManager();
		String jpql="select a from Alumno a where a.curso=?1";
		/*TypedQuery<Alumno> tq=em.createQuery(jpql,Alumno.class);
		tq.setParameter(1, curso);
		return tq.getResultList();*/
		return em
			.createQuery(jpql,Alumno.class) //TypedQuery
			.setParameter(1, curso)
			.getResultList();
	}
	@Override
	public boolean eliminarAlumno(String dni) {
		EntityManager em=getEntityManager();
		String jpql="delete from Alumno a where a.dni=?1";
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		int res= em
				.createQuery(jpql)
				.setParameter(1, dni)
				.executeUpdate();
		tx.commit();
		return res>0;
	}
	
}
