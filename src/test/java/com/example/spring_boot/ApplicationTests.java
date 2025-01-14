package com.example.spring_boot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void monoTest (){
		Mono<String> mono = Mono.just("hello");
		mono.subscribe(data ->{
			System.out.println(data);
		});
	}

}
