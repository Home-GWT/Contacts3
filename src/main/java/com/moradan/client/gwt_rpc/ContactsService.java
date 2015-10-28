package com.moradan.client.gwt_rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.moradan.shared.ContactList;
import com.moradan.shared.domain.ContactPerson;

import java.util.ArrayList;

//@RemoteServiceRelativePath("service")
@RemoteServiceRelativePath("service/gwt-spring")
public interface ContactsService extends RemoteService {

    ContactPerson getContact(String id);
    ArrayList<ContactList> getContactDetails();
	Boolean deleteContact(String id);
	ArrayList<ContactList> deleteContacts(ArrayList<String> ids);
    ContactPerson addContact(ContactPerson contact);
	ContactPerson updateContact(ContactPerson contact);

}
