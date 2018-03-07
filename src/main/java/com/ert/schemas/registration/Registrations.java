package com.ert.schemas.registration;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "registration"
})
@XmlRootElement(name = "Registrations")
public class Registrations {

    @XmlElement(name = "Registration", required = true)
    protected List<Registration> registration;

    public List<Registration> getRegistration() {
        if (registration == null) {
            registration = new ArrayList<Registration>();
        }
        return this.registration;
    }

}
