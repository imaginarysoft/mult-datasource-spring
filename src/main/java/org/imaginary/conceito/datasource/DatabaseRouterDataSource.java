package org.imaginary.conceito.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DatabaseRouterDataSource extends AbstractRoutingDataSource 
{
	@Override
	protected Object determineCurrentLookupKey()
	{
		return DataBaseContextHolder.getDatabaseType();
	}
	
	@Override
	public Connection getConnection() throws SQLException
	{
		Connection  connection = super.getConnection();
		//connection.set
		//connection.
		System.out.println("TESTE ........obter  conexao");
		//select set_config('dominio.user' , 'TESTE TRTRTRETRETRETER' , FALSE ) ; 
		PreparedStatement ps = connection.prepareStatement("select set_config('dominio.user','"  + DataBaseContextHolder.getDatabaseType() + "', FALSE)");
		ps.execute();
		return connection ; 
	}
	
	


}


