package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for equipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="equipment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="modelNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

/**
 * The Equipment class represents a piece of medical equipment, containing information about the equipment's ID,
 * name, model number, manufacturer, and type.
 * This class is annotated with JAXB annotations to enable marshalling and unmarshalling between Java objects and XML.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "equipment", propOrder = {
    "id",
    "name",
    "modelNumber",
    "manufacturer",
    "type"
})
public class Equipment {
    /**
     * The unique identifier for the equipment.
     */
    @XmlElement(required = true)
    protected int id;

    /**
     * The name of the equipment.
     */
    @XmlElement(required = true)
    protected String name;

    /**
     * The model number of the equipment.
     */
    @XmlElement(required = true)
    protected String modelNumber;

    /**
     * The manufacturer of the equipment.
     */
    @XmlElement(required = true)
    protected String manufacturer;

    /**
     * The type of the equipment.
     */
    @XmlElement(required = true)
    protected String type;

    /**
     * Default constructor for the Equipment class.
     */
    public Equipment() {
    }

    /**
     * Constructor for the Equipment class, initializing the equipment with the provided parameters.
     * @param id The unique identifier for the equipment.
     * @param name The name of the equipment.
     * @param modelNumber The model number of the equipment.
     * @param manufacturer The manufacturer of the equipment.
     * @param type The type of the equipment.
     */
    public Equipment(int id, String name, String modelNumber, String manufacturer, String type) {
        this.id = id;
        this.name = name;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public Equipment(ModelsHibernate.EquipmentDTO equipment) {
        this.id = equipment.getId();
        this.name = equipment.getName();
        this.modelNumber = equipment.getModelNumber();
        this.manufacturer = equipment.getManufacturer();
        this.type = equipment.getType();
    }
    /**
     * Returns the ID of the equipment object.
     * @return the ID of the equipment object.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the equipment object.
     * @param id the new ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the equipment object.
     * @return the name of the equipment object.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the equipment object.
     * @param name the new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the model number of the equipment object.
     * @return the model number of the equipment object.
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     * Sets the model number of the equipment object.
     * @param modelNumber the new model number to set.
     */
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * Returns the manufacturer of the equipment object.
     * @return the manufacturer of the equipment object.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of the equipment object.
     * @param manufacturer the new manufacturer to set.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Returns the type of this equipment.
     * @return the type of this equipment.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of this equipment.
     * @param type the new type of this equipment.
     */
    public void setType(String type) {
        this.type = type;
    }

}
