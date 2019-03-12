package com.ibm.telefone.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.contato.model.ContatoModel;

@Entity
public class TelefoneModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private short ddd;
	

	private String numero;
	
//	@Autowired
//	private EnumTipoTelefone tipo_telefone;	

	@ManyToOne
	private ContatoModel contato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getDdd() {
		return ddd;
	}

	public void setDdd(short ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ContatoModel getContato() {
		return contato;
	}

	public void setContato(ContatoModel contato) {
		this.contato = contato;
	}
	
	
	
	
	
}
