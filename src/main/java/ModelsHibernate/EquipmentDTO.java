package ModelsHibernate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import javax.persistence.*;

/**
 * This class represents equipment that can be used in various facilities.
 * The class contains properties such as name, model number, manufacturer, and type.
 * Each equipment is uniquely identified by its ID.
 **/
@Entity
@Table(name="equipment")
@XmlAccessorType(XmlAccessType.FIELD)
public class EquipmentDTO {
    /**
     * The unique identifier for the equipment.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The name of the equipment.
     */
    private String name;

    /**
     * The model number of the equipment.
     */
    private String modelNumber;

    /**
     * The manufacturer of the equipment.
     */
    private String manufacturer;

    /**
     * The type of the equipment.
     */
    private String type;

    /**
     * Default constructor for the equipment class.
     */
    public EquipmentDTO() {

    }

    /**
     * Creates a new instance of Equipment with the given values.
     * @param name The name of the equipment.
     * @param modelNumber The model number of the equipment.
     * @param manufacturer The manufacturer of the equipment.
     * @param type The type of the equipment.
     */
    public EquipmentDTO(String name, String modelNumber, String manufacturer, String type) {
        this.name = name;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public EquipmentDTO(Models.Equipment equipment) {
        this.name = equipment.getName();
        this.modelNumber = equipment.getModelNumber();
        this.manufacturer = equipment.getManufacturer();
        this.type = equipment.getType();
    }

    /**
     * Creates a new instance of Equipment with the given values.
     * @param id The unique identifier for the equipment.
     * @param name The name of the equipment.
     * @param modelNumber The model number of the equipment.
     * @param manufacturer The manufacturer of the equipment.
     * @param type The type of the equipment.
     */
    public EquipmentDTO(int id, String name, String modelNumber, String manufacturer, String type) {
        this.id = id;
        this.name = name;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.type = type;
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
