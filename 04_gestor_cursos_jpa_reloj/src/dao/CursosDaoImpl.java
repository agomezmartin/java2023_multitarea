package dao;

import static helpers.EntityManagerLocator.getEntityManager;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;

import model.Curso;
public class CursosDaoImpl implements CursosDao {
	
	
	@Override
	public boolean existeCurso(int idCurso) {
		return getEntityManager().find(Curso.class, idCurso)!=null;
	}
	@Override
	public boolean guardarCurso(Curso curso) {
		try {
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(curso);
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Curso> cursos(){
		
		String jpql="select c from Curso c";
		return getEntityManager()
				.createQuery(jpql,Curso.class)
				.getResultList();
	}
	@Override
	public List<Curso> cursosFechas(LocalDate f1, LocalDate f2) {
		String jpql="select c from Curso c where c.fechaInicio between ?1 and ?2";
		return getEntityManager()
				.createQuery(jpql,Curso.class)
				.setParameter(1, f1)
				.setParameter(2, f2)
				.getResultList();
	}
}
