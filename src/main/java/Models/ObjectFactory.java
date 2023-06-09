package Models;

import Responses.GetAllPatientsResponse;
import Responses.TransformXMLToHTMLResponse;
import Requests.*;
import Responses.AddEquipmentResponse;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.spring.guides.gs_producing_web_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllPatientsRequest_QNAME = new QName("http://spring.io/guides/gs-producing-web-service", "getAllPatientsRequest");
    private final static QName _GetDoctorByIdResponse_QNAME = new QName("http://spring.io/guides/gs-producing-web-service", "getDoctorByIdResponse");
    private final static QName _AddEquipmentRequest_QNAME = new QName("http://spring.io/guides/gs-producing-web-service", "addEquipmentRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.spring.guides.gs_producing_web_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllPatientsResponse }
     *
     */
    public GetAllPatientsResponse createGetAllPatientsResponse() {
        return new GetAllPatientsResponse();
    }

    /**
     * Create an instance of {@link Patient }
     * 
     */
    public Patient createPatient() {
        return new Patient();
    }

    /**
     * Create an instance of {@link GetDoctorByIdRequest }
     * 
     */
    public GetDoctorByIdRequest createGetDoctorByIdRequest() {
        return new GetDoctorByIdRequest();
    }

    /**
     * Create an instance of {@link Doctor }
     * 
     */
    public Doctor createDoctor() {
        return new Doctor();
    }

    /**
     * Create an instance of {@link Appointment }
     * 
     */
    public Appointment createAppointment() {
        return new Appointment();
    }

    /**
     * Create an instance of {@link Equipment }
     * 
     */
    public Equipment createEquipment() {
        return new Equipment();
    }

    /**
     * Create an instance of {@link AddEquipmentResponse }
     * 
     */
    public AddEquipmentResponse createAddEquipmentResponse() {
        return new AddEquipmentResponse();
    }

    /**
     * Create an instance of {@link TransformXMLToHTMLRequest }
     * 
     */
    public TransformXMLToHTMLRequest createTransformXMLToHTMLRequest() {
        return new TransformXMLToHTMLRequest();
    }

    /**
     * Create an instance of {@link TransformXMLToHTMLResponse }
     * 
     */
    public TransformXMLToHTMLResponse createTransformXMLToHTMLResponse() {
        return new TransformXMLToHTMLResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://spring.io/guides/gs-producing-web-service", name = "getAllPatientsRequest")
    public JAXBElement<Object> createGetAllPatientsRequest(Object value) {
        return new JAXBElement<Object>(_GetAllPatientsRequest_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Doctor }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Doctor }{@code >}
     */
    @XmlElementDecl(namespace = "http://spring.io/guides/gs-producing-web-service", name = "getDoctorByIdResponse")
    public JAXBElement<Doctor> createGetDoctorByIdResponse(Doctor value) {
        return new JAXBElement<Doctor>(_GetDoctorByIdResponse_QNAME, Doctor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Equipment }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Equipment }{@code >}
     */
    @XmlElementDecl(namespace = "http://spring.io/guides/gs-producing-web-service", name = "addEquipmentRequest")
    public JAXBElement<Equipment> createAddEquipmentRequest(Equipment value) {
        return new JAXBElement<Equipment>(_AddEquipmentRequest_QNAME, Equipment.class, null, value);
    }

}
