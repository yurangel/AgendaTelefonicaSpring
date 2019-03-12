package com.ibm.contato.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibm.contato.model.ContatoModel;
import com.ibm.contato.repository.ContatoRepositorio;
import com.ibm.telefone.model.TelefoneModel;
import com.ibm.telefone.repository.TelefoneRepositorio;

@Controller
//@RestController
//@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	private TelefoneRepositorio telefoneDAO;
	@Autowired
	private ContatoRepositorio contatoDAO;
	
	@RequestMapping(value="/cadastrarContato", method=RequestMethod.GET)
	public String form() {
		return "contato/formContato";
	}
	
	
	@RequestMapping(value="/cadastrarContato", method=RequestMethod.POST)
	public String form(@Valid ContatoModel contato, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			 attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			 return "redirect:/cadastrarContato";
			
		}	
		
		contatoDAO.save(contato);	
		
		attributes.addFlashAttribute("mensagem", "Contato cadastrado com sucesso!");
		
		return "redirect:/cadastrarContato";
	}
	
	@RequestMapping("/contatos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<ContatoModel> contatos = contatoDAO.findAll();
		mv.addObject("contatos", contatos);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesContato(@PathVariable("codigo") long codigo) {
		ContatoModel contato = contatoDAO.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("contato/detalhesContato");
		mv.addObject("contato", contato);
		
		Iterable<TelefoneModel> telefones = telefoneDAO.findByContato(contato);
		mv.addObject("telefones", telefones);
		
		return mv;
	}
	
	@RequestMapping(value="/deletarContato/{codigo}")
	public String deletarContato(@PathVariable("codigo") long codigo) {
		ContatoModel contato = contatoDAO.findByCodigo(codigo);
		contatoDAO.delete(contato);
		return "redirect:/contatos";
		
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesContatoPost(@PathVariable("codigo") long codigo, @Valid TelefoneModel telefone, BindingResult result, RedirectAttributes attributes) {		
		if(result.hasErrors()) {
			 attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			 return "redirect:/{codigo}";
			
		}
		
		ContatoModel contato = contatoDAO.findByCodigo(codigo);
		telefone.setContato(contato);
		telefoneDAO.save(telefone);
		
		contato.getTelefones().add(telefone);

		contatoDAO.save(contato);
		
		attributes.addFlashAttribute("mensagem", "Telefone adicionado com sucesso!");
		return "redirect:/{codigo}";
	}
	
	@RequestMapping(value="/deletarTelefone/{id}")
	public String deletarTelefone(@PathVariable("id") long id) {
		TelefoneModel telefone = telefoneDAO.findById(id);
		
		ContatoModel evento = telefone.getContato();
		long codigoLong = evento.getCodigo();
		
		
		telefoneDAO.delete(telefone);
		
		
		String codigo = "" + codigoLong;
		
		return "redirect:/" + codigo;
	}
	
	
	

	
//	@GetMapping
//	public Iterable<ContatoModel> listAll(){
//		//System.out.println("Mostrando: "+contatoDAO.findAll());
//		Iterable<ContatoModel> findAll = contatoDAO.findAll();
//		return findAll;
//	}
//	
//
//	@GetMapping(path = "/{id}")
//	public ResponseEntity<?> getContatoById(@PathVariable("id") Long id){
//		Optional<ContatoModel> contato = contatoDAO.findById(id);
//		if(contato == null)
//			return new ResponseEntity<>(new CustomErrorType("Contato not found"), HttpStatus.NOT_FOUND);
//		return new ResponseEntity<>(contato, HttpStatus.OK);
//	}
//	
//	@PostMapping
//	public ResponseEntity<?> save(@RequestBody ContatoModel contato, TelefoneModel telefone){
//		
////		if(contato.getTelefones() != null) {
////			TelefoneModel telefone = contato.getTelefones().get(0);
////			telefone.setContato(contato);
////			
////		}
////		
////		contato.getTelefones().get(0).setContato(contato);
////		
////		telefoneDAO.save(contato.getTelefones().get(0));
//		//telefone.setContato(contato);
//		contatoDAO.save(contato);
//		
//		ContatoModel next = contatoDAO.findAll().iterator().next();
//		
//		telefone.setDdd(next.getTelefones().get(0).getDdd());
//		telefone.setNumero(next.getTelefones().get(0).getNumero());
//		telefone.setTipo_telefone(next.getTelefones().get(0).getTipo_telefone());
//		telefone.setContato(next);
//		
//		telefoneDAO.save(telefone);
//		
//		
//		return new ResponseEntity<>(contatoDAO.save(contato), HttpStatus.OK);
//	}
//	
////	@PostMapping
////	public ResponseEntity<?> save(@RequestBody ContatoModel contato){
////		if(contato.getTelefones() == null) 	
////			return new ResponseEntity<>(new CustomErrorType("Telefone not found"), HttpStatus.NOT_FOUND);
////		
////		return new ResponseEntity<>(contatoDAO.save(contato), HttpStatus.OK);
////	}
//	
//	@DeleteMapping(path = "/{id}")
//	public ResponseEntity<?> delContatoById(@PathVariable("id") Long id){
//		contatoDAO.deleteById(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
//	@PutMapping
//	public ResponseEntity<?> update(@RequestBody ContatoModel contato){
//		
//		return new ResponseEntity<>(contatoDAO.save(contato), HttpStatus.OK);
//	}
	
}
