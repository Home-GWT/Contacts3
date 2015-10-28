package com.moradan.client.gwt_rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.moradan.shared.ContactList;
import com.moradan.shared.domain.ContactPerson;

import java.util.ArrayList;

public interface ContactsServiceAsync {

    public void getContact(String id, AsyncCallback<ContactPerson> callback);
    public void getContactDetails(AsyncCallback<ArrayList<ContactList>> callback);
	public void deleteContact(String id, AsyncCallback<Boolean> callback);
	public void deleteContacts(ArrayList<String> ids, AsyncCallback<ArrayList<ContactList>> callback);
    public void addContact(ContactPerson contact, AsyncCallback<ContactPerson> callback);
	public void updateContact(ContactPerson contact, AsyncCallback<ContactPerson> callback);

}
