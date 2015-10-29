package com.moradan.shared.domain;

import com.moradan.shared.ContactList;

import javax.persistence.*;
import java.io.Serializable;

/**
* Created by alexandr on 28.10.15.
*/

@Entity
@Table(name = "CONTACTS_HIB")
//@NamedQueries({
//        @NamedQuery(name ="contacts.findAll", query = "SELECT CONTACTS_HIB FROM ContactPerson contacts")
//})
public class ContactPerson implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    public ContactPerson() {}
    public ContactPerson(String id, String firstName, String lastName, String emailAddress) {
        this.id           = id;
        this.firstName    = firstName;
        this.lastName     = lastName;
        this.emailAddress = emailAddress;
    }

    public String getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ContactList getLightWeightContact() {
        return new ContactList(id, firstName + " " + lastName);
    }

}
