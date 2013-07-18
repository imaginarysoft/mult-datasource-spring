package org.imaginary.conceito.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DatabaseRouterDataSource extends AbstractRoutingDataSource 
{
	@Override
	protected Object determineCurrentLookupKey()
	{
		return DataBaseContextHolder.getDatabaseType();
	}


}


