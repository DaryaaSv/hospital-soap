package Client.Responses;

import Client.Models.Doctor;
import jakarta.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "doctor"
})
@XmlRootElement(name = "getDoctorByIdResponse")
public class GetDoctorByIdResponse {

    @XmlElement(required = true)
    protected Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}