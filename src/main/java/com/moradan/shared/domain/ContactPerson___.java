//package com.uibinder.moradan.shared.domain;
//
//import com.uibinder.moradan.shared.ContactList;
//
//import java.io.Serializable;
//
///**
// * Это бин, на это указывает 'Serializable'
// */
//public class ContactPerson implements Serializable {
//    /**
//     * Mandatory for RPC serialization.
//     */
//    public ContactPerson() {}
//    public ContactPerson(String id, String firstName, String lastName, String emailAddress) {
//        this.id           = id;
//        this.firstName    = firstName;
//        this.lastName     = lastName;
//        this.emailAddress = emailAddress;
//    }
//
//    public String getId() {
//        return id;
//    }
//    public String getFirstName() {
//        return firstName;
//    }
//    public String getLastName() {
//        return lastName;
//    }
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//
//    public ContactList getLightWeightContact() {
//        return new ContactList(id, firstName + " " + lastName);
//    }
//
//    private String id;
//    private String firstName;
//    private String emailAddress;
//    private String lastName;
//}
