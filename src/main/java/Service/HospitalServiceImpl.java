package Service;

import Models.Doctor;
import Models.Equipment;
import Models.Patient;
import Models.Appointment;
import Util.HibernateUtil;
import com.sun.xml.ws.util.ByteArrayDataSource;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.jws.WebService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@WebService(endpointInterface = "Service.HospitalService")
public class HospitalServiceImpl implements HospitalService {

    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private List<Equipment> equipments;
    private String xslFilePath = "C:\\Users\\Dasha\\IdeaProjects\\XSLTransformation\\src\\main\\resources\\hospitalsToHTML.xsl";


    public HospitalServiceImpl() throws ParseException {

        Patient patient1 = new Patient(1,"Alice", "Pattinson", 19, "+37063945276", "alicepattinson@gmail.com");
        Patient patient2 = new Patient(2, "Peter", "Parker", 28, "+37015947852", "peter.park@gmail.com");

        Doctor doctor1 = new Doctor(1, "Bob", "Stevens", "+37067645456", "Physiotherapist");
        Doctor doctor2 = new Doctor(2, "Alex", "Vivien", "+37065645456", "Cardiology");

        Appointment appointment1 = new Appointment(1, "monitoring", new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString()), patient1, doctor1);
        Appointment appointment2 = new Appointment(2, "monitoring", new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString()), patient2, doctor2);


        Equipment equipment1 = new Equipment(1, "Patient monitor", "HospEq", "For monitoring", "Utility room");
        Equipment equipment2 = new Equipment(2, "Elliptical", "Precor", "Cardio Equipment", "Fitness Center");

        patients = List.of(patient1, patient2);
        doctors = List.of(doctor1, doctor2);
        appointments = List.of(appointment1, appointment2);
        equipments = List.of(equipment1, equipment2);
    }

    @Override
    public List<Patient> getAllPatients() {
        return this.patients;
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == doctorId) {
                return doctor;
            }
        }

        return new Doctor();
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
        HibernateUtil.saveToDatabase(equipments);
    }

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
