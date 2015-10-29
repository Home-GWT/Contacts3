package com.moradan.server.dao;

import com.moradan.shared.domain.ContactPerson;

import java.util.ArrayList;

/**
 * Created by Саша on 28.10.2015.
 */
public interface ContactPersonDao {

    ContactPerson getContact(String id);
    void addContact(String id, String firstName, String lastName, String emailAddress);
    void updateContact(String id, String firstName, String lastName, String emailAddress);
    void deleteContact(String id);
    ArrayList<ContactPerson> getContactDetails();

}