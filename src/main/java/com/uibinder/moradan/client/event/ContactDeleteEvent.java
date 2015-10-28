package com.uibinder.moradan.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ContactDeleteEvent extends GwtEvent<ContactDeleteEventHandler>{

    @Override
    public Type<ContactDeleteEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ContactDeleteEventHandler handler) {
        handler.onContactDeleted(this);
    }

    public static Type<ContactDeleteEventHandler> TYPE = new Type<ContactDeleteEventHandler>();
}
