package com.moradan;

import com.moradan.client.gwt_rpc.ContactsService;
import com.moradan.dao.ContactPersonMybatisDao;
import com.moradan.service.ContactPersonService;
import com.moradan.shared.ContactList;
import com.moradan.shared.domain.ContactPerson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//public class ContactsServiceImpl extends RemoteServiceServlet implements ContactsService {
@Service("gwt-spring")
public class ContactsServiceServlet implements ContactsService {

    private static Log log = LogFactory.getLog(ContactsServiceServlet.class);

    /**
     * Чтобы использовать-создать объект persistence-модели, в 'Spring-е' аннотируем поле '@Autowired' (собственно в этом и заключается способ реализации работы с базой)
     */
    @Autowired
    private ContactPersonMybatisDao dao;

    @Override
    public ArrayList<ContactList> getContactDetails() {
        ContactPersonService service = new ContactPersonService(dao);
        return service.getAll();
    }

    @Override
    public ContactPerson getContact(String id) {
        ContactPersonService service = new ContactPersonService(dao);
        return service.get(id);
    }

    @Override
    public Boolean deleteContact(String id) {
        ContactPersonService service = new ContactPersonService(dao);
        return service.delete(id);
    }

    @Override
    public ArrayList<ContactList> deleteContacts(ArrayList<String> ids) {
        ContactPersonService service = new ContactPersonService(dao);
        return service.delete(ids);
    }

    @Override
    public ContactPerson addContact(ContactPerson contact) {
        ContactPersonService service = new ContactPersonService(dao);
        return service.add(contact);
    }

    @Override
    public ContactPerson updateContact(ContactPerson contact) {
        ContactPersonService service = new ContactPersonService(dao);
        return service.add(contact);
    }
}
