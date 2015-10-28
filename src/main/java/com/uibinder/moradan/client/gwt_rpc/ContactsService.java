package com.uibinder.moradan.client.gwt_rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uibinder.moradan.shared.domain.ContactPerson;
import com.uibinder.moradan.shared.ContactList;

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
