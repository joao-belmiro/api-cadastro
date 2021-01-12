package br.com.apiCadastro.exceptions;

import java.sql.SQLException;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DadosCadastradosException extends DataIntegrityViolationException{

public DadosCadastradosException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

static final long serialVersionUID = 1L;


}
