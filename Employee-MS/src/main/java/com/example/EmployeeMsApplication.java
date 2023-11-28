package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients // enables component scanning for interfaces that declare they are Feign clients
@ImportAutoConfiguration({FeignAutoConfiguration.class})    //spring version above 3 should use this annoattion for compatibility with spring cloud feign
public class EmployeeMsApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeMsApplication.class, args);
	}

}
