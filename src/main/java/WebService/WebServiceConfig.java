package WebService;

import Service.HospitalService;
import Service.HospitalServiceImpl;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.text.ParseException;

@EnableWs
@Configuration
@ComponentScan(basePackages = "WebService")
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public HospitalService hospitalService() throws ParseException {
		return new HospitalServiceImpl();
	}

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "hospital")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema hospitalSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("HospitalPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(hospitalSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema hospitalSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/hospital.xsd"));
	}
}
