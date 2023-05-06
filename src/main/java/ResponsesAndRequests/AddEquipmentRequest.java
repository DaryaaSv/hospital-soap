package ResponsesAndRequests;

import Models.Equipment;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "name",
        "modelNumber",
        "manufacturer",
        "type"
})
@XmlRootElement(name = "addEquipmentRequest")
public class AddEquipmentRequest {

    protected int id;
    protected String name;
    protected String modelNumber;
    protected String manufacturer;
    protected String type;

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String value) {
        this.modelNumber = value;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public Equipment getEquipment() {
        Equipment equipment = new Equipment();
        equipment.setId(this.id);
        equipment.setName(this.name);
        equipment.setModelNumber(this.modelNumber);
        equipment.setManufacturer(this.manufacturer);
        equipment.setType(this.type);
        return equipment;
    }

    public void setEquipment(Equipment value) {
        this.id = value.getId();
        this.name = value.getName();
        this.modelNumber = value.getModelNumber();
        this.manufacturer = value.getManufacturer();
        this.type = value.getType();
    }
}
