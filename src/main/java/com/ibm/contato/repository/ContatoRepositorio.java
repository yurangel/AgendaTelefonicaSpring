package com.ibm.contato.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ibm.contato.model.ContatoModel;

public interface ContatoRepositorio extends CrudRepository<ContatoModel, String> {
	
	List<ContatoModel> findByNome(String nome);
	ContatoModel findByCodigo(long codigo);
	
//	public static ContatoModel Repositorio() {
//		//DEFININDO UMA LISTA PARA USAR NO REPOSITORIO
//		List<TelefoneModel> agenda = new ArrayList<TelefoneModel>();
//		
//		ContatoModel contato = new ContatoModel(1, "Yury");
//		
//		TelefoneModel tel = new TelefoneModel((short)19, "23211", EnumTipoTelefone.FAX);
//		agenda.add(tel);
//		
//		tel = new TelefoneModel((short)11, "99999999999", EnumTipoTelefone.CELULAR);
//		agenda.add(tel);
//		
//		contato.setTelefones(agenda); 
//		
//		return contato;
//	}
	
}
