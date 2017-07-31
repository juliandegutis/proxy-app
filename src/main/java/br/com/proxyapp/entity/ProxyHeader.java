package br.com.proxyapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "proxy_header" )
public class ProxyHeader implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8002395339516464263L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column( name = "header_id" )
	private Long headerId;
	
	@Column( name="request_id" )
	private Long requestId;
	
	@Column( name = "header_name" )
	private String headerName;
	
	@Column( name = "header_value" )
	private String headerValue;
	
	public ProxyHeader() {
		
	}

	
	public Long getHeaderId() {
		return headerId;
	}

	
	public void setHeaderId( Long headerId ) {
		this.headerId = headerId;
	}

	
	public Long getRequestId() {
		return requestId;
	}

	
	public void setRequestId( Long requestId ) {
		this.requestId = requestId;
	}

	
	public String getHeaderName() {
		return headerName;
	}

	
	public void setHeaderName( String headerName ) {
		this.headerName = headerName;
	}

	
	public String getHeaderValue() {
		return headerValue;
	}

	
	public void setHeaderValue( String headerValue ) {
		this.headerValue = headerValue;
	}
}
