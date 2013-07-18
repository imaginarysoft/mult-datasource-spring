package org.imaginary.conceito.datasource;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaGerencia
{
	 @Autowired
     private SqlSession sqlsession;
	 
	 
	 public  Pessoa novaPessoa(Pessoa pes)
	 {
		  sqlsession.insert("Pessoa.inserir", pes);
		  return pes;
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
		
		for (Iterator iterator = listaContatos.iterator(); iterator.hasNext();)
		{
			 contato = (Contato) iterator.next();
			 contato.setIdPes(pes.getId());
			 sqlsession.insert("Contato.inserir", contato);
			
		}
		
	}
}
