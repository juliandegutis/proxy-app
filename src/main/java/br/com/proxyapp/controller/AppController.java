package br.com.proxyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.proxyapp.entity.ProxyHeader;
import br.com.proxyapp.entity.ProxyRequest;
import br.com.proxyapp.repository.ProxyHeaderRepository;
import br.com.proxyapp.repository.ProxyRequestRepository;

@Controller
public class AppController {
	
	@Autowired
	private ProxyRequestRepository proxyRequestRepository;
	
	@Autowired
	private ProxyHeaderRepository proxyHeaderRepository;
	
	@RequestMapping( "/proxy/request" )
	public Iterable< ProxyRequest > request() {
		return proxyRequestRepository.findAll();
	}
	
	@RequestMapping( "/proxy/header" )
	public Iterable< ProxyHeader > header() {
		return proxyHeaderRepository.findAll();
	}

}
