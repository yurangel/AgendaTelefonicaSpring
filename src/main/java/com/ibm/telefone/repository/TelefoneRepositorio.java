package com.ibm.telefone.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.contato.model.ContatoModel;
import com.ibm.telefone.model.TelefoneModel;

public interface TelefoneRepositorio extends CrudRepository<TelefoneModel, String> {
	Iterable<TelefoneModel> findByContato(ContatoModel contato);
	TelefoneModel findById(long codigo);
	//List<TelefoneModel> findByNumero(String numero);

}
