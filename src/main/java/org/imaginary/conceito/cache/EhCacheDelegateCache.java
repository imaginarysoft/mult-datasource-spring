package org.imaginary.conceito.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.imaginary.conceito.datasource.DataBaseContextHolder;
import org.mybatis.caches.ehcache.EhcacheCache;

/* Referencias : 
* http://www.ehcache.org/documentation/code-samples
* https://github.com/mybatis/ehcache-cache/blob/master/src/main/java/org/mybatis/caches/ehcache/EhcacheCache.java
* @author valter
*/
public class EhCacheDelegateCache   implements Cache
{

    private final Map<String, Cache> mapDominioCache; 
    
    
    /**
     * The cache id.
     */
    private final String id;
   
   
    public EhCacheDelegateCache(String id) 
    {
       mapDominioCache = new HashMap<String, Cache>();
       if (id == null) {
           throw new IllegalArgumentException("[]Cache instances require an ID");
       }
      this.id = id ;
       System.out.println("*****Cache ID:"  + id);
    }    
    /*********************************************************************/
    
    protected Cache getCacheCurrentDominio() {
        Cache  cache  = null;
        String dominio = DataBaseContextHolder.getDatabaseType();
        cache = getCacheCurrentDominio(dominio);
        
        return cache;
        
    }
    
    private Cache getCacheCurrentDominio(final String dominio) {
    	
        Cache cache = mapDominioCache.get(dominio);

        if (cache == null) {
        	cache = createNewCacheController(dominio);
        	mapDominioCache.put(dominio, cache);
        }

        return cache;
     }
    private Cache  createNewCacheController(String dominio)  
    {
    	
    	String key= getIdDominio();
		System.out.println("Criando um novo cache :" +  key);
        final Cache cache = new EhcacheCache(key);      

        return cache;
    }
    
    
    private String getIdDominio()
    {
    	 String dominio = DataBaseContextHolder.getDatabaseType();
    	 String key = dominio + "." + this.id;
    	 return key;
    	
    }

    
    
    /*********************************************************************/
   
	  
	@Override
	public void clear()
	{
		getCacheCurrentDominio().clear();
		
	}

	@Override
	public String getId()
	{
		
		String idDominio = getIdDominio();
		System.out.println("******Solicitando id do Cache Delegate" + idDominio);
		return idDominio;
	}

	@Override
	public Object getObject(Object key)
	{
		System.out.println("obtendo do cache:[" +  key + "]");
		return getCacheCurrentDominio().getObject(key);
	}

	@Override
	public ReadWriteLock getReadWriteLock()
	{
		return getCacheCurrentDominio().getReadWriteLock();
	}

	@Override
	public int getSize()
	{
		return getCacheCurrentDominio().getSize();
		
	}

	@Override
	public void putObject(Object key, Object value)
	{
		System.out.println("Colocando no cache:[" +  key + "] [" + value + "]");
		getCacheCurrentDominio().putObject(key, value);
		
	}

	@Override
	public Object removeObject(Object key)
	{
		System.out.println("Removendo do cache:[" +  key + "]");
		return getCacheCurrentDominio().removeObject(key);
	}
	

}
