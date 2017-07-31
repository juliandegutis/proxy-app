package br.com.proxyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan
public class ProxyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyAppApplication.class, args);
	}
}
