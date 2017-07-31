package br.com.proxyapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.proxyapp.cache.CacheRepository;
import br.com.proxyapp.entity.ProxyHeader;
import br.com.proxyapp.entity.ProxyRequest;
import br.com.proxyapp.enums.HttpHeaderEnum;
import br.com.proxyapp.service.ProxyAllowService;
import br.com.proxyapp.service.ProxyHeaderService;
import br.com.proxyapp.service.ProxyRequestService;

@RestController
@RequestMapping( "/" )
public class ProxyController {

	@Autowired
	private ProxyHeaderService proxyHeaderService;

	@Autowired
	private ProxyRequestService proxyRequestService;

	@Autowired
	private ProxyAllowService proxyAllowService;

	@Autowired
	private CacheRepository cacheRepository;

	@RequestMapping( value = "", method = RequestMethod.GET )
	public void get( HttpServletRequest request, HttpServletResponse response ) {

		try {

			ProxyRequest proxy = proxyRequestService.save( request.getRemoteAddr(), request.getLocalName() );
			List< ProxyHeader > headers = new ArrayList< ProxyHeader >();

			Enumeration< String > headerNames = request.getHeaderNames();

			while ( headerNames.hasMoreElements() ) {

				String headerName = headerNames.nextElement();

				ProxyHeader currentHeader = new ProxyHeader();
				currentHeader.setHeaderName( headerName );
				currentHeader.setHeaderValue( request.getHeader( headerName ) );
				currentHeader.setRequestId( proxy.getRequestId() );

				headers.add( currentHeader );

			}

			proxyHeaderService.save( headers );
			
			OutputStreamWriter writer = new OutputStreamWriter( response.getOutputStream() );
			StringBuffer result = new StringBuffer();
			String cachedBody = null;

			if ( cacheRepository.isTokenOnCache( request.getHeader( HttpHeaderEnum.URL.value() ) ) ) {
				net.sf.ehcache.Element element = cacheRepository.getFromCache( request.getHeader( HttpHeaderEnum.URL.value() ) );
				cachedBody = element.getObjectValue().toString();
				response.addHeader( "cached-by-me", "true" );
			} else {
				
				HttpClient httpClient = HttpClientBuilder.create().build();
				HttpResponse responseH;

				if ( proxyAllowService.isAllowed( request.getHeader( HttpHeaderEnum.URL.value() ) ) ) {

					HttpGet requesth = new HttpGet( "http://" + request.getHeader( HttpHeaderEnum.URL.value() ) );

					responseH = httpClient.execute( requesth );

				} else {

					HttpGet requesth = new HttpGet( "http://192.168.1.5:8080/greeting" );

					responseH = httpClient.execute( requesth );

				}

				BufferedReader rd = new BufferedReader( new InputStreamReader( responseH.getEntity().getContent() ) );

				result = new StringBuffer();
				String line = "";
				while ( ( line = rd.readLine() ) != null ) {
					result.append( line );
				}
				
				cacheRepository.putOnCache( request.getHeader( HttpHeaderEnum.URL.value() ), result.toString() );

			}

			writer.write( cachedBody == null ? result.toString() : cachedBody );
			writer.flush();
			writer.close();

		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}
