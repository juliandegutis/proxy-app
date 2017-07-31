package br.com.proxyapp.enums;


public enum HttpHeaderEnum {

	URL( "host" );
	
	private String value;
	
	private HttpHeaderEnum( String header ) {
		this.value = header;
	}
	
	public String value() {
		return this.value;
	}
}
