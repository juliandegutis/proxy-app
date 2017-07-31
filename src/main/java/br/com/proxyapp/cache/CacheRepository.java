package br.com.proxyapp.cache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Component
public class CacheRepository {

	@CachePut( "request" )
	public String refreshToken( String key ) {
		return key;
	}
	
	public void putOnCache( String host, String body ) {
		CacheManager instance = CacheManager.getInstance();

		Cache cache = instance.getCache( "request" );
		
		cache.put( new Element(host, body) );

	}

	public Boolean isTokenOnCache( String key ) {

		CacheManager instance = CacheManager.getInstance();

		Cache cache = instance.getCache( "request" );

		Element element = cache.get( key );

		if ( element == null ) {
			return false;
		}

		return true;

	}
	
	public Element getFromCache( String key ) {

		CacheManager instance = CacheManager.getInstance();

		Cache cache = instance.getCache( "request" );

		Element element = cache.get( key );

		return element;

	}

}
