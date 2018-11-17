package br.com.alura.gaming;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.alura.gaming.service.ServiceCircuitBreaker;

@EnableEurekaClient
@SpringBootApplication
public class GamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamingApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}
	
	@Bean
	public CommandLineRunner clr(ServiceCircuitBreaker service) {
		return args-> {
			service.request();
		};
	}
}
