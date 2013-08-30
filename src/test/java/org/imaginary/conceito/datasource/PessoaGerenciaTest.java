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
	public void testObterPessoaContatos()
	{
		System.out.println(" Data Base B *******************************************");
		DataBaseContextHolder.setDatabaseType("B");
		System.out.println(" Chamando TODOS B  *******************************************");
		pessoaGerencia.obterTodos();
		System.out.println(pessoaGerencia.obterPessoa(2));
		System.out.println(" Chamando TODOS B  *******************************************");
		pessoaGerencia.obterTodos();
	
		
	}

	@Test
	public void testObterPessoa()
	{
		System.out.println(" Data Base B *******************************************");
		DataBaseContextHolder.setDatabaseType("B");
		System.out.println(pessoaGerencia.obterPessoa(1));
		
		System.out.println(pessoaGerencia.obterPessoa(4));
		
		
		System.out.println(" Data Base A *******************************************");
		DataBaseContextHolder.setDatabaseType("A");
		System.out.println(pessoaGerencia.obterPessoa(1));
		
		System.out.println(" De novo 1" +  pessoaGerencia.obterPessoa(1));
		
		
		System.out.println(" A  4 ? null" +  pessoaGerencia.obterPessoa(4));
		
		System.out.println(" Mudou para  B *******************************************");
		DataBaseContextHolder.setDatabaseType("B");
		System.out.println(pessoaGerencia.obterPessoa(4));
		
		/*System.out.println(" Inserinfo no A  *******************************************");
		DataBaseContextHolder.setDatabaseType("A");
		Pessoa pes = new Pessoa();
		pes.setDataNascimento(Calendar.getInstance().getTime());
		pes.setNome("Maria A");
		pes.setEmail("MariaA@gmail.com");
		
				
		pessoaGerencia.novaPessoaContatos(pes);
		
		System.out.println(" A  4 ? ficou  null : " +  pessoaGerencia.obterPessoa(4));*/
		
	
		
		
		
		/**  Pegar classe e implementar um cache com base no DataBaseContextHolder HOLDER
		 * https://github.com/mybatis/ehcache-cache/blob/master/src/main/java/org/mybatis/caches/ehcache/EhcacheCache.java
		 * 
		 */
	}

}
