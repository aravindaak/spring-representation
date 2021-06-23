package demo.representation.web;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class Web {
	
	public Web() {
	}
	
	@Bean
	public WebClient distanceClient() {
		return WebClient.create("https://httpbin.org/anything");
	}

}
