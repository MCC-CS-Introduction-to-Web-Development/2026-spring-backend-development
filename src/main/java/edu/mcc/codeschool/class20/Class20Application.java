package edu.mcc.codeschool.class20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Class20Application {

	static void main(String[] args) {
		SpringApplication.run(Class20Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplateBuilder().interceptors(
				(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) -> {
					request.getHeaders().set("Accepts", MediaType.APPLICATION_JSON_VALUE);
//					request.getHeaders().set("X-RapidAPI-Host", "your-host-here");
					return execution.execute(request, body);
				}
		).build();
	}

}
