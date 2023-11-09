package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cursos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
	@Id
	private int idCurso;
	private String curso;
	private int duracion;
	private double precio;
	private LocalDate fechaInicio;
	@Transient
	private List<Alumno> alumnos;
	
	@Override
	public String toString() {
		return curso;
	}
	
}
