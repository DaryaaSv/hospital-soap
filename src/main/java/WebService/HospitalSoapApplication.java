package WebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
@SpringBootApplication
@Import(WebServiceConfig.class)
public class HospitalSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalSoapApplication.class, args);
	}

}
