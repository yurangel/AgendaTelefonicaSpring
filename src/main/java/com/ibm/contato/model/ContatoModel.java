package com.ibm.contato.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.ibm.telefone.model.TelefoneModel;

@Entity
public class ContatoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long codigo;
	
	@NotEmpty
	private String nome;
	
	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TelefoneModel> telefones;	
	
//	private String telefone;
//
//	public String getTelefone() {
//		return telefone;
//	}
//	public void setTelefone(String telefone) {
//		this.telefone = telefone;
//	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
			
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<TelefoneModel> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelefoneModel> telefones) {
		this.telefones = telefones;
	}	
	

}
