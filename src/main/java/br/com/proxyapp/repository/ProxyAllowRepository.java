package br.com.proxyapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.proxyapp.entity.ProxyAllow;

@Repository
public interface ProxyAllowRepository extends CrudRepository< ProxyAllow, Long >{
	
	public ProxyAllow findByUrl( @Param( "url") String url );
	
}
