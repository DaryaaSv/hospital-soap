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

/**
 * This class configures the Hospital web service by setting up the HospitalService, message dispatcher servlet,
 * default WSDL 1.1 definition, and XSD schema.
 */
@EnableWs
@Configuration
@ComponentScan(basePackages = "WebService")
public class WebServiceConfig extends WsConfigurerAdapter {
	/**
	 * Creates a new instance of the HospitalServiceImpl object.
	 * @return A new instance of the HospitalServiceImpl object.
	 * @throws ParseException An exception thrown when parsing a date string.
	 */
	@Bean
	public HospitalService hospitalService() throws ParseException {
		return new HospitalServiceImpl();
	}

	/**
	 * Registers the MessageDispatcherServlet bean.
	 * @param applicationContext The ApplicationContext object to use.
	 * @return A new ServletRegistrationBean representing the MessageDispatcherServlet.
	 */
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	/**
	 * Creates a new instance of the DefaultWsdl11Definition object.
	 * @param hospitalSchema The XsdSchema object to use.
	 * @return A new instance of the DefaultWsdl11Definition object.
	 */
	@Bean(name = "hospital")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema hospitalSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("HospitalPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(hospitalSchema);
		return wsdl11Definition;
	}

	/**
	 * Creates a new instance of the SimpleXsdSchema object.
	 * @return A new instance of the SimpleXsdSchema object.
	 */
	@Bean
	public XsdSchema hospitalSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/hospital.xsd"));
	}
}
