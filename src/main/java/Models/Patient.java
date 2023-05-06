package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for patient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patient"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

/**
 * This class represents a Patient object that can be serialized to XML using JAXB.
 * The patient object contains information about the patient such as their id, first name,
 * surname, age, phone number, and email.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patient", propOrder = {
    "id",
    "firstName",
    "surname",
    "age",
    "phoneNumber",
    "email"
})
public class Patient {
    /**
     The unique identifier of the patient.
     */
    @XmlElement(required = true)
    protected int id;

    /**
     The first name of the patient.
     */
    @XmlElement(required = true)
    protected String firstName;

    /**
     The surname of the patient.
     */
    @XmlElement(required = true)
    protected String surname;

    /**
     The age of the patient.
     */
    @XmlElement(required = true)
    protected int age;

    /**
     The phone number of the patient.
     */
    @XmlElement(required = true)
    protected String phoneNumber;

    /**
     The email address of the patient.
     */
    @XmlElement(required = true)
    protected String email;

    /**
     Default constructor for the Patient object.
     */
    public Patient() {
    }

    /**
     Constructor for the Patient object that sets all fields.
     @param id The unique identifier of the patient.
     @param firstName The first name of the patient.
     @param surname The surname of the patient.
     @param age The age of the patient.
     @param phoneNumber The phone number of the patient.
     @param email The email address of the patient.
     */
    public Patient(int id, String firstName, String surname, int age, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Patient(ModelsHibernate.PatientDTO patient) {
        this.id = patient.getId();
        this.firstName = patient.getFirstName();
        this.surname = patient.getSurname();
        this.age = patient.getAge();
        this.phoneNumber = patient.getPhoneNumber();
        this.email = patient.getEmail();
    }
    /**
     * Returns the ID of the patient.
     * @return the ID of the patient
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the patient.
     * @param id the ID to be assigned to the patient
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the first name of the patient.
     * @return the first name of the patient
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the patient.
     * @param firstName the first name to be assigned to the patient
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the surname of the patient.
     * @return the surname of the patient
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the patient.
     * @param surname the surname to be assigned to the patient
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the age of the patient.
     * @return the age of the patient
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the patient.
     * @param age the age to be assigned to the patient
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the phone number of the patient.
     * @return the phone number of the patient
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the patient.
     * @param phoneNumber the phone number to be assigned to the patient
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the email of the patient.
     * @return the email of the patient
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the patient.
     * @param email the email to be assigned to the patient
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
