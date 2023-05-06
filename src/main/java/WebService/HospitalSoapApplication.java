package WebService;

import ModelsHibernate.*;
import Util.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
@Import(WebServiceConfig.class)
@ComponentScan(basePackages = "Controllers")
public class HospitalSoapApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HospitalSoapApplication.class, args);
	}

}
