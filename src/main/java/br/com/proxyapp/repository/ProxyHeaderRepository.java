package br.com.proxyapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.proxyapp.entity.ProxyHeader;

@Repository
public interface ProxyHeaderRepository extends CrudRepository< ProxyHeader, Long >{

}
