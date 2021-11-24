package cl.dipol.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Politicos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String primerNombre;
	
	private String segundoNombre;
	
	private String apellidoPaterno;
	
	private String appellidoMaterno;

	protected Politicos(){}
}
