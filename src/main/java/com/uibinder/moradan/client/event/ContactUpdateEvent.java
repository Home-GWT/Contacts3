package com.uibinder.moradan.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.uibinder.moradan.shared.domain.ContactPerson;

public class ContactUpdateEvent extends GwtEvent<ContactUpdateEventHandler> {

	public ContactUpdateEvent(ContactPerson updatedContact) {
		this.updatedContact = updatedContact;
	}

	public ContactPerson getUpdatedContact() {
		return updatedContact;
	}

	@Override
	public Type<ContactUpdateEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ContactUpdateEventHandler handler) {
		handler.onContactUpdated(this);
	}

    public static Type<ContactUpdateEventHandler> TYPE = new Type<ContactUpdateEventHandler>();
    private final ContactPerson updatedContact;
}
