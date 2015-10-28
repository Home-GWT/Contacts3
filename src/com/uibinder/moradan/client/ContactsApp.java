package com.uibinder.moradan.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.uibinder.moradan.client.presenter.AppController;
import com.uibinder.moradan.client.rpc.ContactsService;
import com.uibinder.moradan.client.rpc.ContactsServiceAsync;

/**
 * {@link https://github.com/isopov/mvp-uibinder}
 * **********************************************
 * (GWT MVP - Contacts - mvp-uibinder) https://github.com/isopov/mvp-uibinder
 * * * * * * * * * * * * * * * * * * * * * * * *
 * https://netbeans.org/kb/74/web/quickstart-webapps-gwt_ru.html
 * пример пользовательского интерфейса, созданный как тестовый клиент. Он может использоваться для вызова службы GWT
 */
public class ContactsApp implements EntryPoint {

	@Override
	public void onModuleLoad() {
        /**
         * https://drive.google.com/file/d/0B418nT5Bo9w_engtSTdpVDllY2s/view ( https://github.com/Home-GWT/docs/blob/master/gwt-tutorial-ru.pdf )
         * Создайте прокси сервисного класса:
         */
		new AppController((ContactsServiceAsync) GWT.create(ContactsService.class), new SimpleEventBus()).go(RootPanel.get());
	}
}
