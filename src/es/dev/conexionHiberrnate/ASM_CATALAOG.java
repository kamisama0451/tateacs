package es.dev.conexionHiberrnate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ASM_CATALAOG")
public class ASM_CATALAOG {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ASM_CATALAOG_SEQ")
	@SequenceGenerator(name = "ASM_CATALAOG_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "ID_GRUPO")
	private Integer idGrupo;

	public ASM_CATALAOG() {
	}
	///mensaeje
	
	public ASM_CATALAOG(String value, Integer idGrupo) {			
		this.value = value;
		this.idGrupo = idGrupo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	
	/*
	 * ID NUMBER(10), VALUE VARCHAR2(25), ID_GRUPO NUMBER(25),
	 */
}
