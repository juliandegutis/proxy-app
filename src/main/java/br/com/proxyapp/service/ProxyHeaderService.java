package br.com.proxyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.proxyapp.entity.ProxyHeader;
import br.com.proxyapp.repository.ProxyHeaderRepository;

@Service
public class ProxyHeaderService {
	
	@Autowired
	private ProxyHeaderRepository proxyHeaderRepository;
	
	public void save( List< ProxyHeader > proxyHeaders ) {
		for( ProxyHeader proxyHeader : proxyHeaders ) {
			proxyHeaderRepository.save( proxyHeader );
		}
	}
	
}
