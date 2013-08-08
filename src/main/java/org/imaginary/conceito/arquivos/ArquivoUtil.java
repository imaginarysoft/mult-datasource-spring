package org.imaginary.conceito.arquivos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.imaginary.conceito.datasource.DataBaseContextHolder;

public class ArquivoUtil
{
	
	public final static  String  DIR = "C:/Temp/saas" ;

	
	public static void novoArquivo(String path ,   File file ) throws IOException
	{
		String dominio = DataBaseContextHolder.getDatabaseType() ; 
		
		File fileDest =     new File(DIR + "/" + dominio   + "/" + path  + "/"  );
	
		FileUtils.copyFileToDirectory(file, fileDest, true);
		
	}
	
	public static void removerArquivo(String path ,  String nomeArquivo)
	{
		String dominio = DataBaseContextHolder.getDatabaseType() ; 
		File fileRemove =     new File(DIR + "/" + dominio   + "/" + path  + "/"  + nomeArquivo );
		FileUtils.deleteQuietly(fileRemove);
		
	}
	//public static void removerArquivo(String stringNome);
	
}
