package com.habuma.santaslist;

import org.springframework.web.client.RestTemplate;

import com.habuma.santaslist.toy.Toy;

public class Main {
	public static void main(String[] args) {
		RestTemplate rest = new RestTemplate();
		
		Toy toy = rest.getForObject("http://localhost:8080/santaslist/toys/{toyId}", Toy.class, 2);
		
		System.out.println(toy.getName() + " - " + toy.getOnhand());
		
		toy.setOnhand(500);
		
		rest.put("http://localhost:8080/santaslist/toys/{toyId}", toy, 2);

		toy = rest.getForObject("http://localhost:8080/santaslist/toys/{toyId}", Toy.class, 2);
		
		System.out.println(toy.getName() + " - " + toy.getOnhand());
		}
}
