package com.uibinder.moradan.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ContactAddEvent extends GwtEvent<ContactAddEventHandler> {

    // метод getAssociatedType(), который возвращает тип события
    @Override
    public Type<ContactAddEventHandler> getAssociatedType() {
        return TYPE;
    }

    // метод dispatch(), который вызывает метод clear() обработчика события
    @Override
    protected void dispatch(ContactAddEventHandler handler) {
        handler.onAddContact(this);
    }

    // переменную TYPE, которая определяет тип события
    public static Type<ContactAddEventHandler> TYPE = new Type<ContactAddEventHandler>();

}
