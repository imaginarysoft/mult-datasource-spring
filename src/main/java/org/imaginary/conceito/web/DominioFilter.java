package org.imaginary.conceito.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.imaginary.conceito.datasource.DataBaseContextHolder;

public class DominioFilter implements Filter 
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		final String dominio = request.getParameter("dominio");

    	DataBaseContextHolder.setDatabaseType(dominio);
    	
        chain.doFilter(request, response);
		
	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

}
