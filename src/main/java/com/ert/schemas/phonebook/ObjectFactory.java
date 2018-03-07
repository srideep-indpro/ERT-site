package com.ert.schemas.phonebook;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public PhoneBook createPhoneBook() {
        return new PhoneBook();
    }

    public PhoneBooks createPhoneBooks() {
        return new PhoneBooks();
    }

}
