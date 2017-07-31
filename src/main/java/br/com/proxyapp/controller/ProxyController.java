package br.com.proxyapp.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/" )
public class ProxyController {

	@RequestMapping( value = "", method = RequestMethod.GET )
	public void get( HttpServletRequest request, HttpServletResponse response ) {

		try {

			OutputStreamWriter writer = new OutputStreamWriter( response.getOutputStream() );

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet requesth = new HttpGet( "http://192.168.1.5:8080/greeting" );
			ResponseHandler< String > responseHandler = new BasicResponseHandler();

	        HttpContext context = new BasicHttpContext(); 
	        String responseH = httpClient.execute(requesth, responseHandler, context);
			
	        writer.write( responseH );
			writer.flush();
			writer.close();

		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	// @RequestMapping( value = "", method = RequestMethod.POST )
	// public void post( HttpServletRequest request, HttpServletResponse
	// response ) {
	// try {
	//
	// Enumeration< String > headerNames = request.getHeaderNames();
	//
	// while ( headerNames.hasMoreElements() ) {
	//
	// String headerName = headerNames.nextElement();
	//
	// System.out.println( headerName + " : " + request.getHeader( headerName )
	// );
	//
	// }
	//
	// OutputStreamWriter writer = new OutputStreamWriter(
	// response.getOutputStream() );
	// HttpClient client = new HttpClient();
	//
	// HttpMethod method = null;
	//
	// method = new PostMethod( URLDecoder.decode( request.getHeader(
	// HttpHeaderEnum.URL.value() ), "utf-8" ) );
	//
	// Enumeration< String > paramNames = request.getParameterNames();
	//
	// while ( paramNames.hasMoreElements() ) {
	//
	// String paramName = paramNames.nextElement();
	// ( (PostMethod) method ).setParameter( paramName, request.getParameter(
	// paramName ) );
	// }
	//
	// client.executeMethod( method );
	//
	// Header[] headers = method.getResponseHeaders();
	// for ( Header header : headers ) {
	//
	// if ( "Content-Type".equalsIgnoreCase( header.getName() ) ) {
	//
	// response.setContentType( header.getValue() );
	// }
	// }
	//
	// writer.write( method.getResponseBodyAsString() );
	// writer.flush();
	// writer.close();
	//
	// } catch ( HttpException e ) {
	// e.printStackTrace();
	// } catch ( IOException e ) {
	// e.printStackTrace();
	// }
	// }

}
