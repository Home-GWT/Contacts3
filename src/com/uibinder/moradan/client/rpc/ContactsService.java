package com.uibinder.moradan.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uibinder.moradan.shared.ContactPerson;
import com.uibinder.moradan.shared.ContactList;

import java.util.ArrayList;

/**
 * https://netbeans.org/kb/74/web/quickstart-webapps-gwt_ru.html
 * (клас службы GWT) определение службы на стороне клиента. Этот интерфейс расширяет интерфейс тега RemoteService
 */

@RemoteServiceRelativePath("service")
public interface ContactsService extends RemoteService {

	ContactPerson addContact(ContactPerson contact);

	Boolean deleteContact(String id);

	ArrayList<ContactList> deleteContacts(ArrayList<String> ids);

	ArrayList<ContactList> getContactDetails();

	ContactPerson getContact(String id);

	ContactPerson updateContact(ContactPerson contact);
}
