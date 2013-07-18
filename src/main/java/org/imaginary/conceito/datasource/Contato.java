package org.imaginary.conceito.datasource;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Contato
{
	
	private Integer id; 
	private String nome; 
	private Integer idPes; 
	private Date dataCadastro;
	
	
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
	public Integer getIdPes()
	{
		return idPes;
	}
	public void setIdPes(Integer idPes)
	{
		this.idPes = idPes;
	}
	public Date getDataCadastro()
	{
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro)
	{
		this.dataCadastro = dataCadastro;
	}
	
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
			
}
