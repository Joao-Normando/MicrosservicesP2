package com.joao.normando.Client;

import com.joao.normando.Client.service.ViaCEPClient;
import com.joao.normando.Client.model.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(ViaCEPClient address){
		return args -> {
			if (args.length > 0) {
				String cep = args[0];

				Client client = address
						.searchAddress(cep);

				System.out.println(client);
			}
		};
	}
}
