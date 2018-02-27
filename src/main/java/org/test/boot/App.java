package org.test.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackages="org.test.boot")
public class App{
	public static void main(String []args){
		SpringApplication.run(App.class, args);
	}
}
