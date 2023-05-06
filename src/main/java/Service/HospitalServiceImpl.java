package Service;


import Models.Appointment;
import Models.Doctor;
import Models.Equipment;
import Models.Patient;
import ModelsHibernate.AppointmentDTO;
import ModelsHibernate.DoctorDTO;
import ModelsHibernate.EquipmentDTO;
import ModelsHibernate.PatientDTO;
import Util.HibernateUtil;
import com.sun.xml.ws.util.ByteArrayDataSource;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.jws.WebService;
import org.springframework.stereotype.Service;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the HospitalService interface and provides methods to interact with the hospital system.
 * The service includes methods to retrieve patient and doctor information, add equipment to the hospital, and
 * transform XML data to HTML format.
 */
@Service
@WebService(endpointInterface = "Service.HospitalService")
public class HospitalServiceImpl implements HospitalService {
    private List<PatientDTO> patientsDTO;
    private List<DoctorDTO> doctorsDTO;
    private List<EquipmentDTO> equipmentsDTO;
    private String xslFilePath = "C:\\Users\\Dasha\\IdeaProjects\\XSLTransformation\\src\\main\\resources\\hospitalsToHTML.xsl";


    /**
     * Constructor for the HospitalServiceImpl object that initializes the lists of patients, doctors, appointments,
     * and equipments.
     * @throws ParseException
     */
    public HospitalServiceImpl() throws ParseException {
        patientsDTO =  HibernateUtil.getFromDatabase(PatientDTO.class);
        doctorsDTO = HibernateUtil.getFromDatabase(DoctorDTO.class);
        equipmentsDTO = HibernateUtil.getFromDatabase(EquipmentDTO.class);
    }

    /**
     * Retrieves a list of all patients in the hospital.
     * @return A List of Patient objects.
     */
    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        for(int i = 0; i < patientsDTO.size(); i++) {
            patients.add(new Patient(patientsDTO.get(i)));
        }
        return patients;
    }

    /**
     * Retrieves a doctor by their unique identifier.
     * @param doctorId The unique identifier of the doctor.
     * @return The Doctor object corresponding to the given identifier.
     */
    @Override
    public Doctor getDoctorById(int doctorId) {
        Doctor doctorOut = new Doctor();
        for (DoctorDTO doctor : doctorsDTO) {
            if (doctor.getId() == doctorId) {
                doctorOut = new Doctor(doctor);
                return doctorOut;
            }
        }
        return new Doctor();
    }

    /**
     * Adds equipment to the hospital system.
     * @param equipment The Equipment object to add.
     * @throws Exception An exception thrown when saving data to the database.
     */
    @Override
    public void addEquipment(Equipment equipment) throws Exception {
        try{
            HibernateUtil.saveToDatabase(List.of(new EquipmentDTO(equipment)));
        } catch(Exception e) {
            throw new Exception(e.toString());
        }
    }

    /**
     * Transforms XML data to HTML format.
     * @param xmlData The DataHandler object containing the XML data to transform.
     * @return A DataHandler object containing the transformed HTML.
     */
    @Override
    public DataHandler transformXMLToHTML(DataHandler xmlData) {
        String xslFile = "src/main/resources/hospitalsToHTML.xsl";
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            StreamSource xslt = new StreamSource(new File(xslFile));
            Transformer transformer = transformerFactory.newTransformer(xslt);

            Source xml = new StreamSource(xmlData.getInputStream());
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            transformer.transform(xml, result);

            byte[] htmlBytes = writer.toString().getBytes(StandardCharsets.UTF_8);

            DataSource htmlDataSource = new ByteArrayDataSource(htmlBytes, "text/html");

            return new DataHandler(htmlDataSource);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }
}
