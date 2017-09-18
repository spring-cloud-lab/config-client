package me.huangjing.lab.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConfigClientApplication {

	@Value("${foo}")
	private String foo;

	@Value("${encrypted}")
	private String encrypted;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@RequestMapping("/")
	ResponseEntity hello() {
		return ResponseEntity.ok(foo);
	}

	@RequestMapping("/encrypted")
	ResponseEntity encrypted() {return ResponseEntity.ok(encrypted);}

}
