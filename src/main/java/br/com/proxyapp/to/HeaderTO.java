package br.com.proxyapp.to;

import java.io.Serializable;

public class HeaderTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2760200896126307345L;
	
	private String headerName;
	
	private String headerValue;
	
	public HeaderTO( String headerName, String headerValue ) {
		this.headerName = headerName;
		this.headerValue = headerValue;
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
