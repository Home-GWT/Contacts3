package com.moradan.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.moradan.client.presenter.AppPresenter;
import com.moradan.client.gwt_rpc.ContactsService;
import com.moradan.client.gwt_rpc.ContactsServiceAsync;

/**
 * {@link https://github.com/isopov/mvp-uibinder}
 * **********************************************
 * (GWT MVP - Contacts - mvp-uibinder) https://github.com/isopov/mvp-uibinder
 */
public class App implements EntryPoint {

	@Override
	public void onModuleLoad() {
        /**
         * https://drive.google.com/file/d/0B418nT5Bo9w_engtSTdpVDllY2s/view ( https://github.com/Home-GWT/docs/blob/master/gwt-tutorial-ru.pdf )
         * Создайте прокси сервисного класса:
         */
		new AppPresenter((ContactsServiceAsync) GWT.create(ContactsService.class), new SimpleEventBus()).go(RootPanel.get());
	}
}
