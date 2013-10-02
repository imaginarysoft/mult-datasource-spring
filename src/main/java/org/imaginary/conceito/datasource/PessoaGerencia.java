package org.imaginary.conceito.datasource;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PessoaGerencia
{
	 @Autowired
     private SqlSession sqlsession;
	 
	 @Autowired
	 private Validator validator;
	 
	 
	
	 
	 
	 public  Pessoa novaPessoa(Pessoa pes)
	 {
		  sqlsession.insert("Pessoa.inserir", pes);
		  return pes;
	 }
	 
	 public  List<Pessoa> obterTodos()
	 {
		 return   sqlsession.selectList("Pessoa.obterTodos");
		 
	 }
	 
	 
	 public  Pessoa obterPessoa(Integer idPes)
	 {
		 
		 return (Pessoa) sqlsession.selectOne("obterPorID" , idPes);
		
	 }

    @Transactional
	public void novaPessoaContatos(Pessoa pes)
	{
		Contato contato;
		
		sqlsession.insert("Pessoa.inserir", pes);
		
		List<Contato> listaContatos = pes.getListaContatos();
		if(listaContatos!=null)
		{
			for (Iterator iterator = listaContatos.iterator(); iterator.hasNext();)
			{
				 contato = (Contato) iterator.next();
				 contato.setIdPes(pes.getId());
				 sqlsession.insert("Contato.inserir", contato);
				
			}
		}
		
		
	}

	public Set<ConstraintViolation<Pessoa>> validar(Pessoa pes)
	{
		//ver como instanciar mas centralizado o validator factory
		
		//ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		
		//Validator validator = validatorFactory.getValidator();

		
		return validator.validate(pes);
		
	}
	
	
	public Set<ConstraintViolation<Contato>> validarContato(Contato contato)
	{
		
		
		//ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		
		//Validator validator = validatorFactory.getValidator();

		
		return validator.validate(contato);
		
	}
}
