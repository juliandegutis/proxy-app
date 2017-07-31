package br.com.proxyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan
@EntityScan( basePackages = { "br.com.proxyapp.entity" } )
@EnableJpaRepositories( basePackages = { "br.com.proxyapp.repository" } )
public class ProxyAppApplication {
	
	/**
	 * Classpath URL of EHCACHE configuration
	 */
	public static final String EHCACHE_CONFIG = "ehcache.xml";
	
	/**
	 * CacheManager Bean
	 * @return CacheManager as EhCacheCacheManager
	 */
	@Bean
	public CacheManager getEhCacheManager() {
		return new EhCacheCacheManager( getEhCacheFactory().getObject() );
	}
	
	/**
	 * Configuration bean for EhCache
	 * @return EhCacheManagerFactoryBean
	 */
	@Bean
	public EhCacheManagerFactoryBean getEhCacheFactory() {
		EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
		factoryBean.setConfigLocation( new ClassPathResource( EHCACHE_CONFIG ) );
		factoryBean.setShared( true );
		return factoryBean;
	}
	
	public static void main( String[] args ) {
		SpringApplication.run( ProxyAppApplication.class, args );
	}
}
