package japy.shoopingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoopingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoopingMicroserviceApplication.class, args);
	}

}
