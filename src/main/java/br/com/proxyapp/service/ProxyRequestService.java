package br.com.proxyapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proxyapp.entity.ProxyRequest;
import br.com.proxyapp.repository.ProxyRequestRepository;

@Service
public class ProxyRequestService {
	
	@Autowired
	private ProxyRequestRepository proxyRequestRepository;
	
	public ProxyRequest save( String requester, String localeName ) {
		return proxyRequestRepository.save( new ProxyRequest( new Date(), requester, localeName ) );
	}
}
