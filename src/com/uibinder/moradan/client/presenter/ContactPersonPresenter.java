package com.uibinder.moradan.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.uibinder.moradan.client.rpc.ContactsServiceAsync;
import com.uibinder.moradan.client.event.ContactUpdateEvent;
import com.uibinder.moradan.client.event.ContactCancelEditEvent;
import com.uibinder.moradan.client.view.ContactPersonView;
import com.uibinder.moradan.shared.ContactPerson;

public class ContactPersonPresenter implements Presenter, ContactPersonView.Presenter<ContactPerson> {

	private ContactPerson contact;
	private final ContactsServiceAsync rpcService;
	private final EventBus eventBus;
	private final ContactPersonView<ContactPerson> display;

	public ContactPersonPresenter(ContactsServiceAsync rpcService, EventBus eventBus, ContactPersonView<ContactPerson> display) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.contact = new ContactPerson();
		this.display = display;
		display.setPresenter(this);
	}

	public ContactPersonPresenter(ContactsServiceAsync rpcService, EventBus eventBus, ContactPersonView<ContactPerson> display,
                                  String id) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		display.setPresenter(this);

		rpcService.getContact(id, new AsyncCallback<ContactPerson>() {
			@Override
			public void onSuccess(ContactPerson result) {
				if (result == null) {
					contact = new ContactPerson();
				} else {
					contact = result;
					ContactPersonPresenter.this.display.getFirstName().setValue(contact.getFirstName());
					ContactPersonPresenter.this.display.getLastName().setValue(contact.getLastName());
					ContactPersonPresenter.this.display.getEmailAddress().setValue(contact.getEmailAddress());
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error retrieving contact");
			}
		});

	}

	@Override
	public void go(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	@Override
	public void onSaveButtonClicked() {
		contact.setFirstName(display.getFirstName().getValue());
		contact.setLastName(display.getLastName().getValue());
		contact.setEmailAddress(display.getEmailAddress().getValue());

		rpcService.updateContact(contact, new AsyncCallback<ContactPerson>() {
			@Override
			public void onSuccess(ContactPerson result) {
				eventBus.fireEvent(new ContactUpdateEvent(result));
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error updating contact");
			}
		});
	}

	@Override
	public void onCancelButtonClicked() {
		eventBus.fireEvent(new ContactCancelEditEvent(contact.getId()));
	}

}
