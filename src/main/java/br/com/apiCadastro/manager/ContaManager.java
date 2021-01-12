package br.com.apiCadastro.manager;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import br.com.apiCadastro.domain.models.Conta;
import br.com.apiCadastro.exceptions.DadosCadastradosException;
import br.com.apiCadastro.repository.ContaRepository;

@Component
public class ContaManager {

	@Autowired
	ContaRepository contaRepository;

	public Conta salvar(Conta conta) throws DadosCadastradosException{
		try {
		return contaRepository.save(conta);			
		} catch (DataIntegrityViolationException e) {
			throw new DadosCadastradosException(e.getMessage());
		}
	}

	public Conta alterar(Conta conta) {
		return contaRepository.save(conta);
	}

	public Optional<Conta> contaCpf(String cpf){
		return contaRepository.findByCpf(cpf);
	}
	
	public Optional<Conta> contaEmail(String email){
		return contaRepository.findByEmail(email);
	}
	
	public List<Conta> todasContas() {
		return contaRepository.findAll();
	}

	public void excluir(Long idConta) {
		contaRepository.deleteById(idConta);
	}

}
