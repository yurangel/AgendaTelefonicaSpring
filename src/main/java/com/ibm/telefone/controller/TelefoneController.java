//package com.ibm.telefone.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ibm.contato.model.ContatoModel;
//import com.ibm.contato.repository.ContatoRepositorio;
//import com.ibm.error.CustomErrorType;
//import com.ibm.telefone.model.TelefoneModel;
//import com.ibm.telefone.repository.TelefoneRepositorio;
//
//@Controller
//@RequestMapping("contatos/telefones")
//public class TelefoneController {
//	
//	private final TelefoneRepositorio telefoneDAO;
//	private final ContatoRepositorio contatoDAO;
//	
//	@Autowired
//	public TelefoneController(TelefoneRepositorio telefoneDAO, ContatoRepositorio contatoDAO) {
//		this.telefoneDAO = telefoneDAO;
//		this.contatoDAO = contatoDAO;
//	}
//
//
//	@GetMapping
//	public ResponseEntity<?> listAll(){
//		return new ResponseEntity<>(telefoneDAO.findAll(), HttpStatus.OK);
//	}
//	
//	
//
//	@GetMapping(path = "/{id}")
//	public ResponseEntity<?> getContatoById(@PathVariable("id") Long id){
//		Optional<TelefoneModel> contato = telefoneDAO.findById(id);
//		if(contato == null)
//			return new ResponseEntity<>(new CustomErrorType("Contato not found"), HttpStatus.NOT_FOUND);
//		return new ResponseEntity<>(telefoneDAO.findAll(), HttpStatus.OK);
//	}
//	
//	@PostMapping
//	public ResponseEntity<?> save(@RequestBody TelefoneModel telefone){
//		
//		return new ResponseEntity<>(telefoneDAO.save(telefone), HttpStatus.OK);
//	}
//	
//	@DeleteMapping(path = "/{id}")
//	public ResponseEntity<?> delContatoById(@PathVariable("id") Long id){
//		telefoneDAO.deleteById(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
////	
////	@PutMapping
////	public ResponseEntity<?> update(@RequestBody TelefoneModel telefone){
////		if(!contatoDAO.findById(telefone.getId()))
////			return new ResponseEntity<>(new CustomErrorType("Telefone not found"), HttpStatus.NOT_FOUND);
////		return new ResponseEntity<>(telefoneDAO.save(telefone), HttpStatus.OK);
////	}
//	
//}
