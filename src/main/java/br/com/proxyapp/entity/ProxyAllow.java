package br.com.proxyapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "proxy_allow" )
public class ProxyAllow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 968594392492299990L;
	
	@Id
	@Column( name = "url" )
	private String url;
	
	public ProxyAllow(){
		
	}

	
	public String getUrl() {
		return url;
	}

	
	public void setUrl( String url ) {
		this.url = url;
	}
	
}
