package br.com.proxyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proxyapp.entity.ProxyAllow;
import br.com.proxyapp.repository.ProxyAllowRepository;

@Service
public class ProxyAllowService {
	
	@Autowired
	private ProxyAllowRepository proxyAllowRepository;
	
	public Boolean isAllowed( String url ) {
		ProxyAllow allow = proxyAllowRepository.findByUrl( url );
		if( allow != null ) {
			return true;
		} else {
			return false;
		}
	}
	
}
