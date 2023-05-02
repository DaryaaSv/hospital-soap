package Service;

import Models.Doctor;
import Models.Equipment;
import Models.Patient;
import jakarta.activation.DataHandler;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public interface HospitalService {
    @WebMethod
    List<Patient> getAllPatients();

    @WebMethod
    Doctor getDoctorById(@WebParam(name = "doctorId") int doctorId);

    @WebMethod
    void addEquipment(@WebParam(name = "equipment") Equipment equipment);

    @WebMethod
    DataHandler transformXMLToHTML(@WebParam(name = "xmlData") DataHandler xmlData);
}
