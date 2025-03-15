package org.example.ikm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IkmApplication {

	public static void main(String[] args) {
		SpringApplication.run(IkmApplication.class, args);
	}

}

/*
users	/list	1
		/new	1
		/save	1
		/delete	1
		/edit	1

products/list	1
		/new	1
		/save	1
		/delete	1
		/edit	1

orders	/list	1
		/new	0
		/save	0
		/delete	1
		/edit	0
*/
