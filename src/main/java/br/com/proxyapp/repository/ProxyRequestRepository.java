package br.com.proxyapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.proxyapp.entity.ProxyRequest;

@Repository
public interface ProxyRequestRepository extends CrudRepository< ProxyRequest, Long >{

}
