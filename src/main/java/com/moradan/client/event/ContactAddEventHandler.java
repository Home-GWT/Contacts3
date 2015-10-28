package com.moradan.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Создадим интерфейс обработчика события. Интерфейс содержит метод onAddContact(), который должен...
 */
public interface ContactAddEventHandler extends EventHandler {

    void onAddContact(ContactAddEvent event);

}
