package com.example.diplomovkareactive;

import com.example.diplomovkareactive.entity.SampleTest;
import com.example.diplomovkareactive.repo.SampleTestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class ReactiveThymeMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveThymeMongoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(SampleTestRepository rep){
//		return args -> {
//			for(int i = 0; i < 1000; i++){
//				rep.save(new SampleTest(i,i,i,i,i,i,i,i,i,i)).subscribe();
//			}
//		};
//	}
}
