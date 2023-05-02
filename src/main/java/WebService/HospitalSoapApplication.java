package WebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.mvc.Controller;

@SpringBootApplication
@Import(WebServiceConfig.class)
@ComponentScan(basePackages = "Controllers")
public class HospitalSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalSoapApplication.class, args);
	}

}
