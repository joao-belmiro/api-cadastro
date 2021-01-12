package br.com.apiCadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.apiCadastro.domain.models.Conta;
import br.com.apiCadastro.manager.ContaManager;

@RestController
@CrossOrigin("*")
@RequestMapping("conta")
public class ContaController {

	@Autowired
	ContaManager contaManager;
	
	@PostMapping("salvar")
	public @ResponseBody ResponseEntity<Conta> salvar (@RequestBody @Validated Conta conta) {
		return new ResponseEntity<Conta>(contaManager.salvar(conta),HttpStatus.CREATED);
	}
	
	@PutMapping("alterar")
	public  @ResponseBody ResponseEntity<Conta> alterar (@Valid @RequestBody Conta conta) {
		return new ResponseEntity<Conta>(contaManager.alterar(conta),HttpStatus.OK);
	}
	
	@GetMapping("listar-todas")
	public  @ResponseBody ResponseEntity<List<Conta>> listarTodas() {
		return new ResponseEntity<List<Conta>>(contaManager.todasContas(),HttpStatus.OK);
	}
	
	@DeleteMapping("excluir/{id}")
	public @ResponseBody ResponseEntity<?> exlcuir(@PathVariable Long id) {
		contaManager.excluir(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("validar-cpf/{cpf}")
	public @ResponseBody ResponseEntity<?> validaCpf(@PathVariable String cpf) {
		Optional<Conta> contaCadastrada = contaManager.contaCpf(cpf);	
		if(contaCadastrada.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
	}
	@GetMapping("validar-email/{email}")
	public @ResponseBody ResponseEntity<?> validaEmail(@PathVariable String email) {
		Optional<Conta> contaCadastrada = contaManager.contaEmail(email);	
		if(contaCadastrada.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
	}
}
