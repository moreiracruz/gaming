package br.com.alura.gaming.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceCircuitBreaker {
	
	public void request() {
		System.out.println("Deu bom !");
	}

}
