package Controllers;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * PdfController is a class responsible for handling the conversion of an XML file to a PDF file.
 * This class is annotated with @Controller to indicate that it is a Spring Web MVC controller.
 */
@Controller
public class PdfController {
    /**
     * Endpoint to handle the conversion of the XML file to a PDF file and return the PDF file as a response.
     * @return ResponseEntity<byte [ ]> containing the PDF file as a byte array, along with appropriate response headers.
     */
    @GetMapping("/convertToPDF")
    public ResponseEntity<byte[]> convertToPDFController() {
        try {
            String pdfPath = "src/main/resources/file.pdf";
            convertToPDF(pdfPath);
            Path path = Paths.get(pdfPath);
            byte[] pdfBytes = Files.readAllBytes(path);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "file.pdf");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Converts the provided XML file to a PDF file using the given XSLT file and saves it to the specified outputFilePath.
     * @param outputFilePath The path where the resulting PDF file will be saved.
     * @throws Exception if any error occurs during the conversion process.
     */
    public static void convertToPDF(String outputFilePath) throws Exception {
        File xsltFile = new File("src/main/resources/hospitalsToPDF.xsl");
        StreamSource xmlSource = new StreamSource(new File("src/main/resources/hospital.xml"));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        OutputStream out;
        out = new java.io.FileOutputStream("src/main/resources/file.pdf");

        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(xmlSource, res);
        }
        finally {
            out.close();
        }
    }
}
