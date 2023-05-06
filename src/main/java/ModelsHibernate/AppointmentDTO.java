package ModelsHibernate;

import javax.persistence.*;
import java.util.Date;
/**
 * Appointment class represents a medical appointment made by a patient to see a doctor or specialist.
 * It contains information about the appointment such as its unique id, type, date, and result.
 * The class also has a Patient object that represents the patient who made the appointment.
 */
@Entity
@Table(name="appointment")
public class AppointmentDTO {

    /**
     * The unique id of the appointment.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The type of the appointment, e.g. "checkup", "surgery", "consultation", etc.
     */
    private String type;

    /**
     * The date of the appointment.
     */
    private Date date;

    /**
     * The Patient object representing the patient who made the appointment.
     */
    @OneToOne(targetEntity = PatientDTO.class, cascade = CascadeType.ALL)
    private PatientDTO patient;

    /**
     * The Doctor object representing the doctor who checked the patient.
     */
    @OneToOne(targetEntity = DoctorDTO.class, cascade = CascadeType.ALL)
    private DoctorDTO doctor;

    /**
     * Constructs an empty Appointment object.
     */
    public AppointmentDTO() {
    }

    public AppointmentDTO(Models.Appointment appointment) {
        this.id = appointment.getId();
        this.type = appointment.getType();
        this.date = appointment.getDate();
        this.patient = new PatientDTO(appointment.getPatient());
        this.doctor = new DoctorDTO(appointment.getDoctor());
    }
    public AppointmentDTO(String type, Date date, PatientDTO patient, DoctorDTO doctor) {
        this.type = type;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    public AppointmentDTO(int id, String type, Date date, PatientDTO patient, DoctorDTO doctor) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    /**
     * Returns the unique id of the appointment.
     * @return the unique id of the appointment
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique id of the appointment.
     * @param id the unique id of the appointment
     */
    public void setId(int id) {
        this.id = id;
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
    public PatientDTO getPatient() {
        return patient;
    }

    /**
     * Sets the Patient object representing the patient who made the appointment.
     * @param patient the Patient object representing the patient who made the appointment
     */
    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }
}