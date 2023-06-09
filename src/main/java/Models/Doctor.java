package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for doctor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doctor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="specialty" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

/**
 * The Doctor class represents a medical doctor, containing information about the doctor's ID, first name,
 * surname, phone number, and specialty.
 * This class is annotated with JAXB annotations to enable marshalling and unmarshalling between Java objects and XML.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doctor", propOrder = {
    "id",
    "firstName",
    "surname",
    "phoneNumber",
    "specialty"
})
public class Doctor {
    /**
     * The unique id of the doctor.
     */
    @XmlElement(required = true)
    protected int id;

    /**
     * The first name of this doctor.
     */
    @XmlElement(required = true)
    protected String firstName;

    /**
     * The surname of this doctor.
     */
    @XmlElement(required = true)
    protected String surname;

    /**
     * The phone number of this doctor.
     */
    @XmlElement(required = true)
    protected String phoneNumber;

    /**
     * The specialty of this doctor (e.g. cardiology, pediatrics).
     */
    @XmlElement(required = true)
    protected String specialty;

    /**
     * Default constructor for the Doctor class.
     */
    public Doctor() {
    }

    public Doctor(ModelsHibernate.DoctorDTO doctor) {
        this.id = doctor.getId();
        this.firstName = doctor.getFirstName();
        this.surname = doctor.getSurname();
        this.phoneNumber = doctor.getPhoneNumber();
        this.specialty = doctor.getSpecialty();
    }
    /**
     * Constructor for the Doctor class, initializing the doctor with the provided parameters.
     * @param id The unique identifier for the doctor.
     * @param firstName The doctor's first name.
     * @param surname The doctor's surname.
     * @param phoneNumber The doctor's phone number.
     * @param specialty The doctor's medical specialty.
     */
    public Doctor(int id, String firstName, String surname, String phoneNumber, String specialty) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
    }

    /**
     * Returns the unique identifier of the doctor.
     * @return the unique identifier of the doctor
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the doctor to the specified value.
     * @param id the new unique identifier of the doctor
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the first name of the doctor.
     * @return the first name of the doctor
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the doctor to the specified value.
     * @param firstName the new first name of the doctor
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the phone number of the doctor.
     * @return the phone number of the doctor
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the doctor to the specified value.
     * @param phoneNumber the new phone number of the doctor
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the surname of the doctor.
     * @return the surname of the doctor
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the doctor to the specified value.
     * @param surname the new surname of the doctor
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the specialty of the doctor.
     * @return the specialty of the doctor
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Sets the specialty of the doctor to the specified value.
     * @param specialty the new specialty of the doctor
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
