package com.uibinder.moradan.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uibinder.moradan.shared.ContactPerson;
import com.uibinder.moradan.shared.ContactList;

import java.util.ArrayList;

/**
 * https://netbeans.org/kb/74/web/quickstart-webapps-gwt_ru.html
 * асинхронный интерфейс, основанный на исходном интерфейсе ContactsService. Он предоставляет объект обратного вызова, обеспечивающий асинхронную связь между сервером и клиентом
 */

public interface ContactsServiceAsync {

	public void addContact(ContactPerson contact, AsyncCallback<ContactPerson> callback);

	public void deleteContact(String id, AsyncCallback<Boolean> callback);

	public void deleteContacts(ArrayList<String> ids, AsyncCallback<ArrayList<ContactList>> callback);

	public void getContactDetails(AsyncCallback<ArrayList<ContactList>> callback);

	public void getContact(String id, AsyncCallback<ContactPerson> callback);

	public void updateContact(ContactPerson contact, AsyncCallback<ContactPerson> callback);
}
