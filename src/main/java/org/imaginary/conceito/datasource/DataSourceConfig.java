package org.imaginary.conceito.datasource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class DataSourceConfig
{

	
	@Bean(name = "multiDataSource")
	public DatabaseRouterDataSource criarDataSource()
	{
		DatabaseRouterDataSource databaseRouterDataSource = new DatabaseRouterDataSource();
		
	
		databaseRouterDataSource.setTargetDataSources(montarDataSources());
		databaseRouterDataSource.setDefaultTargetDataSource(new DriverManagerDataSource("jdbc:postgresql://localhost/data_c", "postgres" , "postgres" ));
		
		return databaseRouterDataSource;
		
	}
	
	/**
	 *  OBter via JNDI PADRAO os dados  para  cada DataBase
	 * @return
	 */
	public  Map<Object, Object> montarDataSources()
	{
		Map  mapDS = new HashMap();
		
		
		mapDS.put("A",  new DriverManagerDataSource("jdbc:postgresql://localhost/data_a", "postgres" , "postgres" ));
		mapDS.put("B", new DriverManagerDataSource("jdbc:postgresql://localhost/data_b", "postgres" , "postgres" ));
		mapDS.put("C", new DriverManagerDataSource("jdbc:postgresql://localhost/data_c", "postgres" , "postgres" ));
		
		
		
		return mapDS;
	}
	
	
	
	
}
