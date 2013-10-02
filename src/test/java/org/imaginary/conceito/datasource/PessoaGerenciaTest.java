package org.imaginary.conceito.datasource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "classpath:services-context.xml" })
public class PessoaGerenciaTest
{
	@Autowired
	PessoaGerencia pessoaGerencia;
	
	@Autowired 
	ResourceBundleMessageSource messageSource; 


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
		pes.setNome("Maria A TESTE Roolbacl  novo");
		pes.setEmail("Maria@gmail.com");
		
		Contato contato; 
		List<Contato> listContatos = new ArrayList<Contato>();
		
		contato = new Contato();
		contato.setNome("Valter Lobo");
		listContatos.add(contato);
		
		contato = new Contato();
		contato.setNome("Ana Beatriz Lobo");
		listContatos.add(contato);
		

		
		pes.setListaContatos(listContatos);
		
		pessoaGerencia.novaPessoaContatos(pes);
		
		
		//banco A
		
		DataBaseContextHolder.setDatabaseType("A");
		contato = new Contato();
		contato.setNome("Auginete Lobo");
		listContatos.add(contato);
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
	
	
	@Test
	public void testPessoaValidador()
	{
	
		Pessoa pes = new Pessoa();
		//pes.setDataNascimento(Calendar.getInstance().getTime());
		//pes.setNome("Maria A");
		pes.setEmail("MariaAgmail.com");
		 Set<ConstraintViolation<Pessoa>> constrain = pessoaGerencia.validar(pes);
		 
		 for (Iterator iterator = constrain.iterator(); iterator.hasNext();)
		{
			ConstraintViolation<Pessoa> constraintViolation = (ConstraintViolation<Pessoa>) iterator.next();
			System.out.println(   "--" + constraintViolation.getInvalidValue() + "--" +  constraintViolation.getMessage()  + "--"  + constraintViolation.getMessageTemplate());
			 // @Todo nome do campo ? 
		}
	
	}
	
	
	@Test
	public void testPessoaValidadorContato()
	{
	
		Contato contato = new Contato();
		//contato.setNome("Valter Lobo");
		
		 Set<ConstraintViolation<Contato>> constrain = pessoaGerencia.validarContato(contato);
		 
		 for (Iterator iterator = constrain.iterator(); iterator.hasNext();)
		{
			ConstraintViolation<Contato> constraintViolation = (ConstraintViolation<Contato>) iterator.next();
			System.out.println(constraintViolation.getMessage());
			
		}
	
	}
	
	
	@Test
	public void testMensagem()
	{
	
		Object[] args = null;
		Locale locale = Locale.getDefault();
		String messagem1 = messageSource.getMessage("modulo.titulo", args, locale);
		
		System.out.println(messagem1);
		
		
		String messagem2 = messageSource.getMessage("modulo.nomecampo", args, locale);
		
		System.out.println(messagem2);
	
	}
	
	
	

}
