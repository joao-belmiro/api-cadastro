package br.com.apiCadastro.domain.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraintvalidation.SupportedValidationTarget;


@Entity
@Table(name= "CONTA")
public class Conta {
	
	@Id
	@Column(name ="ID_CONTA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConta;
	
	@NotNull(message = "O atributo nome não pode ser vazio")
	@Column(name ="NOME",nullable = false)
	private String nome;

	@Email(message = "Insira um e-mail válido")
	@Column(name ="EMAIL", unique = true, nullable = false)
	private String email;
	
	@NotNull(message ="O cpf não pode ser vazio")
	@Column(name ="CPF", unique = true, nullable = false, length=11)
	private String cpf;
	
	@NotNull(message = "A data de nascimento não pode ser vazia")
	@Column(name ="DATA_NASCIMENTO" , nullable = false)
	private LocalDate dataNascimento;

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	
	
	
}
