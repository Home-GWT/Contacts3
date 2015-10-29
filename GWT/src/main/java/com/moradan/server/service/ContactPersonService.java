package com.moradan.server.service;

import com.moradan.server.dao.ContactPersonDao;
import com.moradan.shared.ContactList;
import com.moradan.shared.domain.ContactPerson;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Саша on 28.10.2015.
 */
public class ContactPersonService {

    private ContactPersonDao dao;

    public ContactPersonService(){}
    public ContactPersonService(ContactPersonDao dao){
        this.dao = dao;
    }

    public ContactPerson get(String id) {
        return dao.getContact(id);
    }

    public ArrayList<ContactList> getAll() {
        ArrayList<ContactList> contactDetails = new ArrayList<ContactList>();
        for (ContactPerson contact : dao.getContactDetails())
            contactDetails.add(contact.getLightWeightContact());
        return contactDetails;
    }

    public Boolean delete(String id) {
        dao.deleteContact(id);
        return true;
    }

    public ArrayList<ContactList> delete(ArrayList<String> ids) {
        for (int i = 0; i < ids.size(); ++i)
            delete(ids.get(i));
        return getAll();
    }

    public ContactPerson add(ContactPerson contact) {
        contact.setId(UUID.randomUUID().toString());
        dao.addContact(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmailAddress());
        return contact;
    }

    public ContactPerson update(ContactPerson contact) {
//        dao.deleteContact(contact.getId());
        dao.updateContact(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmailAddress());
        return contact;
    }
}