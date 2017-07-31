package br.com.proxyapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "proxy_request"  )
public class ProxyRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1892447261973127228L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column( name = "request_id")
	private Long requestId;
	
	@Column( name = "request_date" )
	private Date requestDate;
	
	@Column( name = "request_ip" )
	private String requestIp;
	
	@Column( name = "request_name" )
	private String request_name;
	
	public ProxyRequest() {
	}

	public ProxyRequest( Date date, String requester, String localeName ) {
		this.requestDate = date;
		this.requestIp = requester;
		this.request_name = localeName;
	}
	
	public Date getRequestDate() {
		return requestDate;
	}

	
	public void setRequestDate( Date requestDate ) {
		this.requestDate = requestDate;
	}


	public Long getRequestId() {
		return requestId;
	}


	public void setRequestId( Long requestId ) {
		this.requestId = requestId;
	}

	
	public String getRequestIp() {
		return requestIp;
	}

	
	public void setRequestIp( String requestIp ) {
		this.requestIp = requestIp;
	}

	
	public String getRequest_name() {
		return request_name;
	}

	
	public void setRequest_name( String request_name ) {
		this.request_name = request_name;
	}
	
}
