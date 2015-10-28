package com.uibinder.moradan.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.uibinder.moradan.client.rpc.ContactsService;
import com.uibinder.moradan.shared.ContactPerson;
import com.uibinder.moradan.shared.ContactList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/**
 * https://netbeans.org/kb/74/web/quickstart-webapps-gwt_ru.html
 * сервлет, реализующий интерфейс ContactsService и предоставляющий возможность получения результатов обоаботки данных с помощью RPC
 */

@SuppressWarnings("serial")
public class ContactsServiceImpl extends RemoteServiceServlet implements ContactsService {

	private static final String[] contactsFirstNameData = new String[] {
			"Hollie", "Emerson", "Healy", "Brigitte", "Elba", "Claudio",
			"Dena", "Christina", "Gail", "Orville", "Rae", "Mildred",
			"Candice", "Louise", "Emilio", "Geneva", "Heriberto", "Bulrush",
			"Abigail", "Chad", "Terry", "Bell" };

	private final String[] contactsLastNameData = new String[] {
			"Voss", "Milton", "Colette", "Cobb", "Lockhart", "Engle",
			"Pacheco", "Blake", "Horton", "Daniel", "Childers", "Starnes",
			"Carson", "Kelchner", "Hutchinson", "Underwood", "Rush", "Bouchard",
			"Louis", "Andrews", "English", "Snedden" };

	private final String[] contactsEmailData = new String[] {
			"mark@example.com", "hollie@example.com", "boticario@example.com",
			"emerson@example.com", "healy@example.com", "brigitte@example.com",
			"elba@example.com", "claudio@example.com", "dena@example.com",
			"brasilsp@example.com", "parker@example.com", "derbvktqsr@example.com",
			"qetlyxxogg@example.com", "antenas_sul@example.com",
			"cblake@example.com", "gailh@example.com", "orville@example.com",
			"post_master@example.com", "rchilders@example.com", "buster@example.com",
			"user31065@example.com", "ftsgeolbx@example.com" };

	private final HashMap<String, ContactPerson> contacts = new HashMap<String, ContactPerson>();

	public ContactsServiceImpl() {
		initContacts();
	}

	private void initContacts() {
		for (int i = 0; i < contactsFirstNameData.length && i < contactsLastNameData.length && i < contactsEmailData.length; ++i) {
			ContactPerson contact = new ContactPerson(UUID.randomUUID().toString(), contactsFirstNameData[i], contactsLastNameData[i], contactsEmailData[i]);
			contacts.put(contact.getId(), contact);
		}
	}

	@Override
	public ContactPerson addContact(ContactPerson contact) {
		contact.setId(UUID.randomUUID().toString());
		contacts.put(contact.getId(), contact);
		return contact;
	}

	@Override
	public ContactPerson updateContact(ContactPerson contact) {
		contacts.remove(contact.getId());
		contacts.put(contact.getId(), contact);
		return contact;
	}

	@Override
	public Boolean deleteContact(String id) {
		contacts.remove(id);
		return true;
	}

	@Override
	public ArrayList<ContactList> deleteContacts(ArrayList<String> ids) {
		for (int i = 0; i < ids.size(); ++i) {
			deleteContact(ids.get(i));
		}

		return getContactDetails();
	}

	@Override
	public ArrayList<ContactList> getContactDetails() {
		ArrayList<ContactList> contactDetails = new ArrayList<ContactList>();

		Iterator<String> it = contacts.keySet().iterator();
		while (it.hasNext()) {
			ContactPerson contact = contacts.get(it.next());
			contactDetails.add(contact.getLightWeightContact());
		}

		return contactDetails;
	}

	@Override
	public ContactPerson getContact(String id) {
		return contacts.get(id);
	}
}
