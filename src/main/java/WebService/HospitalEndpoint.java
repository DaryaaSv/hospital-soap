package WebService;

import ResponsesAndRequests.*;
import Service.HospitalService;
import com.sun.xml.ws.util.ByteArrayDataSource;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

@Endpoint
public class HospitalEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private HospitalService hospitalService;

	@Autowired
	public HospitalEndpoint(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPatientsRequest")
	@ResponsePayload
	public JAXBElement<GetAllPatientsResponse> getAllPatients(@RequestPayload JAXBElement<GetAllPatientsRequest> request) {
		GetAllPatientsResponse response = new GetAllPatientsResponse();
		response.getPatients().addAll(hospitalService.getAllPatients());

		QName qName = new QName(NAMESPACE_URI, "getAllPatientsResponse");
		JAXBElement<GetAllPatientsResponse> jaxbResponse = new JAXBElement<>(qName, GetAllPatientsResponse.class, response);

		return jaxbResponse;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDoctorByIdRequest")
	@ResponsePayload
	public JAXBElement<GetDoctorByIdResponse> getDoctorById(@RequestPayload JAXBElement<GetDoctorByIdRequest> request) {
		GetDoctorByIdResponse response = new GetDoctorByIdResponse();
		response.setDoctor(hospitalService.getDoctorById(request.getValue().getId()));

		QName qName = new QName(NAMESPACE_URI, "getDoctorByIdResponse");
		JAXBElement<GetDoctorByIdResponse> jaxbElement = new JAXBElement<>(qName, GetDoctorByIdResponse.class, response);

		return jaxbElement;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEquipmentRequest")
	@ResponsePayload
	public JAXBElement<AddEquipmentResponse> addEquipment(@RequestPayload JAXBElement<AddEquipmentRequest> request) {
		hospitalService.addEquipment(request.getValue().getEquipment());

		AddEquipmentResponse response = new AddEquipmentResponse();
		response.setStatus("Equipment added successfully");

		QName qName = new QName(NAMESPACE_URI, "addEquipmentResponse");
		JAXBElement<AddEquipmentResponse> jaxbElement = new JAXBElement<>(qName, AddEquipmentResponse.class, response);

		return jaxbElement;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "transformXMLToHTMLRequest")
	@ResponsePayload
	public JAXBElement<TransformXMLToHTMLResponse> transformXMLToHTML(@RequestPayload JAXBElement<TransformXMLToHTMLRequest> request) throws IOException {
		TransformXMLToHTMLRequest transformXMLToHTMLRequest = request.getValue();

		DataSource dataSource = new ByteArrayDataSource(transformXMLToHTMLRequest.getXmlData().getBytes(), "text/xml");
		DataHandler dataHandler = new DataHandler(dataSource);

		DataHandler htmlDataHandler = hospitalService.transformXMLToHTML(dataHandler);

		InputStream inputStream = htmlDataHandler.getInputStream();
		byte[] htmlContentBytes = inputStream.readAllBytes();
		String htmlContent = new String(htmlContentBytes, StandardCharsets.UTF_8);

		TransformXMLToHTMLResponse response = new TransformXMLToHTMLResponse();
		response.setHtmlData(htmlContent);

		String dir = "src/main/resources";
		String filename = "outputResponse.html";

		try {
			Files.write(Paths.get(dir, filename), htmlContent.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		QName qName = new QName(NAMESPACE_URI, "transformXMLToHTMLResponse");
		JAXBElement<TransformXMLToHTMLResponse> jaxbElement = new JAXBElement<>(qName, TransformXMLToHTMLResponse.class, response);

		return jaxbElement;
	}
}
