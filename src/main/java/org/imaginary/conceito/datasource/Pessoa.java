package org.imaginary.conceito.datasource;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Pessoa  implements Serializable
{

	private Integer id; 
	
    
    //adicionar recursos de messageresources....
    //http://www.intertech.com/Blog/spring-framework-jsr-303-validation-and-custom-messages/
	@NotNull
	@Size(min=4, max=256)
	private String nome; 
    @Email
	private String email; 
    
    @NotNull
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
