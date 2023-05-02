package Controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class HtmlController {

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
