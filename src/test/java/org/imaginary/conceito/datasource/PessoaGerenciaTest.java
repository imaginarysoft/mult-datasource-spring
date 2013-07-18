package org.imaginary.conceito.datasource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "classpath:services-context.xml" })
public class PessoaGerenciaTest
{
	@Autowired
	PessoaGerencia pessoaGerencia;


	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testNovaPessoa()
	{
		DataBaseContextHolder.setDatabaseType("B");
		Pessoa pes = new Pessoa();
		pes.setDataNascimento(Calendar.getInstance().getTime());
		pes.setNome("Maria");
		pes.setEmail("Maria@gmail.com");
		
		Contato contato; 
		List<Contato> listContatos = new ArrayList<Contato>();
		
		contato = new Contato();
		contato.setNome("Valter Lobo");
		listContatos.add(contato);
		
		contato = new Contato();
		contato.setNome("Ana Beatriz Lobo");
		listContatos.add(contato);
		
		contato = new Contato();
		contato.setNome("Auginete Lobo");
		listContatos.add(contato);
		
		

		
		pes.setListaContatos(listContatos);
		
		pessoaGerencia.novaPessoaContatos(pes);
	}

	@Test
	public void testObterPessoa()
	{
		DataBaseContextHolder.setDatabaseType("B");
		System.out.println(pessoaGerencia.obterPessoa(2));
	}

}
