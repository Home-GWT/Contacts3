package com.moradan.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ContactEditEvent extends GwtEvent<ContactEditEventHandler>{

    public ContactEditEvent(String id) {
    this.id = id;
    }

    public String getId() { return id; }

    @Override
    public Type<ContactEditEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ContactEditEventHandler handler) {
        handler.onEditContact(this);
    }

    public static Type<ContactEditEventHandler> TYPE = new Type<ContactEditEventHandler>();
    private final String id;

}
