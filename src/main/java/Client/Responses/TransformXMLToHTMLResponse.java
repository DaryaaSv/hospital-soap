
package Client.Responses;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="htmlData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "htmlData"
})
@XmlRootElement(name = "transformXMLToHTMLResponse")
public class TransformXMLToHTMLResponse {

    @XmlElement(required = true)
    protected String htmlData;

    /**
     * Gets the value of the htmlData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHtmlData() {
        return htmlData;
    }

    /**
     * Sets the value of the htmlData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHtmlData(String value) {
        this.htmlData = value;
    }

}
