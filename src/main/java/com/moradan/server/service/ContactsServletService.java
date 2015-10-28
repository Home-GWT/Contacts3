package com.moradan.server.service;

import com.moradan.client.gwt_rpc.ContactsService;
import com.moradan.server.dao.ContactPersonMybatisDao;
import com.moradan.shared.ContactList;
import com.moradan.shared.domain.ContactPerson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

//public class ContactsServiceImpl extends RemoteServiceServlet implements ContactsService {
@Service("gwt-spring")
public class ContactsServletService implements ContactsService {

    private static Log log = LogFactory.getLog(ContactsServletService.class);

    /**
     * Чтобы использовать-создать объект persistence-модели, в 'Spring-е' аннотируем поле '@Autowired' (собственно в этом и заключается способ реализации работы с базой)
     */
    @Autowired
    private ContactPersonMybatisDao dao;

    @Override
    public ArrayList<ContactList> getContactDetails() {
        ArrayList<ContactList> contactDetails = new ArrayList<ContactList>();
        for (ContactPerson contact : dao.getContactDetails())
            contactDetails.add(contact.getLightWeightContact());
        return contactDetails;
    }

    @Override
    public ContactPerson getContact(String id) {
        return dao.getContact(id);
    }

    @Override
    public Boolean deleteContact(String id) {
        dao.deleteContact(id);
        return true;
    }

    @Override
    public ArrayList<ContactList> deleteContacts(ArrayList<String> ids) {
        for (int i = 0; i < ids.size(); ++i)
            deleteContact(ids.get(i));
        return getContactDetails();
    }

	@Override
	public ContactPerson addContact(ContactPerson contact) {
		contact.setId(UUID.randomUUID().toString());
        dao.addContact(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmailAddress());
		return contact;
	}

	@Override
	public ContactPerson updateContact(ContactPerson contact) {
//        contactPersonMapper.deleteContact(contact.getId());
//        contactPersonMapper.addContact(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmailAddress());
        dao.updateContact(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmailAddress());
		return contact;
	}
}
