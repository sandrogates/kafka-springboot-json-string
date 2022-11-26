/*
 * Author: Sandro Lemanski da Silva (sandrogates@gmail.com)
 * Version 1.0
 * Date: 01/10/2022 
 */

package br.com.dotingjava.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DotingJavaSampleApplication {

	/*
	 * here, start springboot server, etc...
	 * Port 8080
	 */
	public static void main(String[] args) {
		SpringApplication.run(DotingJavaSampleApplication.class, args);
	}

}
