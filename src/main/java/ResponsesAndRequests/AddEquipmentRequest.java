package ResponsesAndRequests;

import Models.Equipment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "equipment"
})
@XmlRootElement(name = "addEquipmentRequest")
public class AddEquipmentRequest {

    @XmlElement(required = true)
    protected Equipment equipment;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment value) {
        this.equipment = value;
    }

}
