package Controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * HtmlController is a class responsible for handling the retrieval of an HTML file.
 * This class is annotated with @Controller to indicate that it is a Spring Web MVC controller.
 */
@Controller
public class HtmlController {
    /**
     * Endpoint to handle the retrieval of the HTML file and return its content as a response.
     * @return ResponseEntity<String> containing the HTML content as a string, with a successful status code
     * or an error message with the corresponding status code.
     */
    @GetMapping(value = "/hospitalHTML", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getHtmlPage() {
        try {
            Path htmlPath = Paths.get("src/main/resources/outputResponse.html");
            String htmlContent = Files.readString(htmlPath);
            return ResponseEntity.ok(htmlContent);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error loading HTML page: " + e.getMessage());
        }
    }
}
