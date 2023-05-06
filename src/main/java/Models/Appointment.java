package Models;

import ModelsHibernate.DoctorDTO;
import ModelsHibernate.PatientDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * <p>Java class for appointment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="appointment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="patient" type="{http://spring.io/guides/gs-producing-web-service}patient"/&gt;
 *         &lt;element name="doctor" type="{http://spring.io/guides/gs-producing-web-service}doctor"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

/**
 * The Appointment class represents an appointment in a medical context, containing information about the
 * appointment ID, type, date, patient, and doctor.
 * This class is annotated with JAXB annotations to enable marshalling and unmarshalling between Java objects and XML.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appointment", propOrder = {
    "id",
    "type",
    "date",
    "patient",
    "doctor"
})
public class Appointment {
    /**
     * The unique id of the appointment.
     */
    @XmlElement(required = true)
    protected int id;

    /**
     * The type of the appointment, e.g. "checkup", "surgery", "consultation", etc.
     */
    @XmlElement(required = true)
    protected String type;

    /**
     * The date of the appointment.
     */
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date date;

    /**
     * The Patient object representing the patient who made the appointment.
     */
    @XmlElement(required = true)
    protected Patient patient;

    /**
     * The Doctor object representing the doctor who checked the patient.
     */
    @XmlElement(required = true)
    protected Doctor doctor;

    /**
     * Default constructor for the Appointment class.
     */
    public Appointment() {
    }

    /**
     * Constructor for the Appointment class, initializing the appointment with the provided parameters.
     * @param id The unique identifier for the appointment.
     * @param type The type of appointment (e.g., consultation, surgery, etc.).
     * @param date The date of the appointment.
     * @param patient The patient involved in the appointment.
     * @param doctor The doctor involved in the appointment.
     */
    public Appointment(int id, String type, Date date, Patient patient, Doctor doctor) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Appointment(ModelsHibernate.AppointmentDTO appointment) {
        this.id = appointment.getId();
        this.type = appointment.getType();
        this.date = appointment.getDate();
        this.patient = new Patient(appointment.getPatient());
        this.doctor = new Doctor(appointment.getDoctor());
    }
    /**
     * Gets the value of the id property.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Returns the type of the appointment.
     * @return the type of the appointment
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the appointment.
     * @param type the type of the appointment
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the date of the appointment.
     * @return the date of the appointment
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the appointment.
     * @param date the date of the appointment
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the Patient object representing the patient who made the appointment.
     * @return the Patient object representing the patient who made the appointment
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the Patient object representing the patient who made the appointment.
     * @param patient the Patient object representing the patient who made the appointment
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Gets the value of the doctor property.
     * @return the Doctor object representing the doctor who checked the patient.
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Sets the value of the doctor property.
     * @param value the Doctor object representing the doctor who checked the patient.
     */
    public void setDoctor(Doctor value) {
        this.doctor = value;
    }
}
