package org.imaginary.conceito.datasource;

public class DataBaseContextHolder
{

	/*** @TODO Fazer um tipo para fixa o database e não ocorrer erro */
	private static final ThreadLocal contextHolder = new ThreadLocal();

	public static void setDatabaseType(String dbType)
	{
		// Assert.notNull(customerType, "customerType cannot be null");
		if (dbType == null)
		{
			throw new IllegalArgumentException("Not Null");
		}

		contextHolder.set(dbType);
	}

	public static String getDatabaseType()
	{
		return (String) contextHolder.get();
	}

	public static void clearDatabaseType()
	{
		contextHolder.remove();
	}

}
