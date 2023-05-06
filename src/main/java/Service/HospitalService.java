package Service;

import Models.Doctor;
import Models.Equipment;
import Models.Patient;
import jakarta.activation.DataHandler;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * This interface defines the HospitalService, which provides methods to interact with the hospital system.
 * The service includes methods to retrieve patient and doctor information, add equipment to the hospital, and
 * transform XML data to HTML format.
 */
@Service
public interface HospitalService {
    /**
     * Retrieves a list of all patients in the hospital.
     * @return A List of Patient objects.
     */
    @WebMethod
    List<Patient> getAllPatients();

    /**
     * Retrieves a doctor by their unique identifier.
     * @param doctorId The unique identifier of the doctor.
     * @return The Doctor object corresponding to the given identifier.
     */
    @WebMethod
    Doctor getDoctorById(@WebParam(name = "doctorId") int doctorId);

    /**
     * Adds equipment to the hospital system.
     * @param equipment The Equipment object to add.
     */
    @WebMethod
    void addEquipment(@WebParam(name = "equipment") Equipment equipment) throws Exception;

    /**
     * Transforms XML data to HTML format.
     * @param xmlData The DataHandler object containing the XML data to transform.
     * @return A DataHandler object containing the transformed HTML data.
     */
    @WebMethod
    DataHandler transformXMLToHTML(@WebParam(name = "xmlData") DataHandler xmlData);
}
