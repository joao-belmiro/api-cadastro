package br.com.apiCadastro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apiCadastro.domain.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
	

	Optional<Conta>findByEmail(String email);
	Optional<Conta> findByCpf(String cpf);
}
