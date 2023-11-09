package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="alumnos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alumno {
	@Id
	private String dni;
	private String nombre;
	private int edad;
	private double nota;
	private int curso;
}
