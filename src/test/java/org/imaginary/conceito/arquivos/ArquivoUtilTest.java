package org.imaginary.conceito.arquivos;

import java.io.File;
import java.io.IOException;

import org.imaginary.conceito.datasource.DataBaseContextHolder;
import org.junit.Before;
import org.junit.Test;

public class ArquivoUtilTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testNovoArquivo() throws IOException
	{
		DataBaseContextHolder.setDatabaseType("A");
		File file = new File("C:/Users/valter/Desktop/imaginary-logo_reasonably_small.jpg");
		ArquivoUtil.novoArquivo("/logo", file);
		
		DataBaseContextHolder.setDatabaseType("B");		
		File file2 = new File("C:/Users/valter/Desktop/Logo-1908.jpg");
		ArquivoUtil.novoArquivo("/logo", file2);
	}

	@Test
	public void testRemoverArquivo() throws IOException
	{
		DataBaseContextHolder.setDatabaseType("B");		
				
		ArquivoUtil.removerArquivo("/logo", "Logo-1908.jpg");
	}

}
