package com.moradan.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ContactCancelEditEvent extends GwtEvent<ContactCancelEditEventHandler> {

	public ContactCancelEditEvent(String contactId) {
		this.contactId = contactId;
	}

	@Override
	public Type<ContactCancelEditEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ContactCancelEditEventHandler handler) {
		handler.onEditContactCancelled(this);
	}

	public String getContactId() {
		return contactId;
	}

    public static Type<ContactCancelEditEventHandler> TYPE = new Type<ContactCancelEditEventHandler>();
    private final String contactId;

}
