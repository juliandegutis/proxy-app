package br.com.proxyapp.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.proxyapp.enums.HttpHeaderEnum;

@RestController
@RequestMapping( "/" )
public class ProxyController {

	@RequestMapping( value = "", method = RequestMethod.GET )
	public void get( HttpServletRequest request, HttpServletResponse response ) {

		try {

			Enumeration< String > headerNames = request.getHeaderNames();

			while ( headerNames.hasMoreElements() ) {

				String headerName = headerNames.nextElement();

				System.out.println( headerName + " : " + request.getHeader( headerName ) );

			}

			OutputStreamWriter writer = new OutputStreamWriter( response.getOutputStream() );
			HttpClient client = new HttpClient();

			HttpMethod method = null;

			method = new GetMethod( URLDecoder.decode( request.getHeader( HttpHeaderEnum.URL.value() ), "utf-8" ) );

			client.executeMethod( method );

			Header[] headers = method.getResponseHeaders();
			for ( Header header : headers ) {

				if ( "Content-Type".equalsIgnoreCase( header.getName() ) ) {

					response.setContentType( header.getValue() );
				}
			}

			writer.write( method.getResponseBodyAsString() );
			writer.flush();
			writer.close();

		} catch ( HttpException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	@RequestMapping( value = "", method = RequestMethod.POST )
	public void post( HttpServletRequest request, HttpServletResponse response ) {
		try {

			Enumeration< String > headerNames = request.getHeaderNames();

			while ( headerNames.hasMoreElements() ) {

				String headerName = headerNames.nextElement();

				System.out.println( headerName + " : " + request.getHeader( headerName ) );

			}

			OutputStreamWriter writer = new OutputStreamWriter( response.getOutputStream() );
			HttpClient client = new HttpClient();

			HttpMethod method = null;

			method = new PostMethod( URLDecoder.decode( request.getHeader( HttpHeaderEnum.URL.value() ), "utf-8" ) );

			Enumeration< String > paramNames = request.getParameterNames();

			while ( paramNames.hasMoreElements() ) {

				String paramName = paramNames.nextElement();
				( (PostMethod) method ).setParameter( paramName, request.getParameter( paramName ) );
			}

			client.executeMethod( method );

			Header[] headers = method.getResponseHeaders();
			for ( Header header : headers ) {

				if ( "Content-Type".equalsIgnoreCase( header.getName() ) ) {

					response.setContentType( header.getValue() );
				}
			}

			writer.write( method.getResponseBodyAsString() );
			writer.flush();
			writer.close();

		} catch ( HttpException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}
