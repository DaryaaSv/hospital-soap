package Client.Service;

import Client.Requests.TransformXMLToHTMLRequest;
import Client.Responses.TransformXMLToHTMLResponse;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ClientMain {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        HospitalPortService service = new HospitalPortService();
        HospitalPort port = service.getHospitalPortSoap11();

        ClassLoader classLoader = ClientMain.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("hospital.xml");
        StringBuilder stringBuilder = new StringBuilder();
        if (inputStream == null) {
            throw new FileNotFoundException("File not found in resources");
        } else {
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        String str = stringBuilder.toString();
        str = str.replace("\t", "");

        String value = "<![CDATA[" + str + "]]";

        TransformXMLToHTMLRequest request = new TransformXMLToHTMLRequest();
        request.setXmlData(str);

        TransformXMLToHTMLResponse response = port.transformXMLToHTML(request);

        StringBuilder htmlValue = new StringBuilder(response.getHtmlData());

        String resourcesPath = System.getProperty("user.dir") + "/src/main/resources/";
        File htmlFile = new File(resourcesPath, "output.html");
        FileWriter writer = new FileWriter(htmlFile);
        writer.write(htmlValue.toString());
        writer.close();


    }
}