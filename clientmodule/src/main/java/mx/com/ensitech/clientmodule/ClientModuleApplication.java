package mx.com.ensitech.clientmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value= {"mx.com.ensitech.proxymodule.*", "mx.com.ensitech.clientmodule.*"})
public class ClientModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientModuleApplication.class, args);
	}

}
