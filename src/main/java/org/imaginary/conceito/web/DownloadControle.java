package org.imaginary.conceito.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/download")
public class DownloadControle
{

	private static final String DIR_TEMP = "C:/TEMP";
	
	private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

	@RequestMapping(value = "/doc/{zipfile}", method = RequestMethod.GET)
	public HttpEntity<byte[]> obterArquivo(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("zipfile")
			String nomeZipFile) throws IOException
	{
		File zipFile = new File(DIR_TEMP + "/" + nomeZipFile   + ".zip");
		
	
		InputStream input =  new FileInputStream(zipFile);
		byte[]  documento =  IOUtils.toByteArray(input);
		
		HttpHeaders header = new HttpHeaders();
		// application/x-zip-compressed
		header.setContentType( new MediaType("application" , "x-zip-compressed"));
        header.set("Content-Disposition", "attachment; filename=DocumentosProduto.zip");
        header.setContentLength(documento.length);
		
        IOUtils.closeQuietly(input);
        zipFile=null;
        input =null;
        
        return new HttpEntity<byte[]>(documento, header);
	
	}
	
	
	
	@RequestMapping(value = "/docsuper/{zipfile}", method = RequestMethod.GET)
	public void obterArquivoSUPER(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("zipfile")
			String nomeZipFile) throws IOException
	{
		File zipFile = new File(DIR_TEMP + "/" + nomeZipFile   + ".zip");
		
	
		InputStream inputFile =  new FileInputStream(zipFile);
		
		 BufferedInputStream bufferInput = new BufferedInputStream(inputFile, 1024);
		//byte[]  documento =  IOUtils.toByteArray(input);
		
		ServletOutputStream outStreamResponse = response.getOutputStream();
		BufferedOutputStream bufferOut = new BufferedOutputStream(outStreamResponse,1024);
		response.setHeader("Content-Disposition", "attachment; filename=DocumentosProduto.zip");
		response.setContentType("application/x-zip-compressed");
		//response.setContentLength(do)
		
		//java.nio.channels.
		IOUtils.copy(bufferInput, bufferOut); 

        //flushs 
		outStreamResponse.flush();
		bufferOut.flush();
		bufferInput.close();
	
		
		//fechar 
		inputFile.close();
        IOUtils.closeQuietly(inputFile);
        

      
        
      
	
	}
}
