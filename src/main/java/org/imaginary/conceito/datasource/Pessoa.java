package org.imaginary.conceito.datasource;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Pessoa
{

	private Integer id; 
	private String nome; 
	private String email; 
	private Date dataNascimento;
	private List<Contato> listaContatos;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Date getDataNascimento()
	{
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	} 
	
	public List<Contato> getListaContatos()
	{
		return listaContatos;
	}
	public void setListaContatos(List<Contato> listaContatos)
	{
		this.listaContatos = listaContatos;
	}
	
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
		
	}
	
	
	
}
