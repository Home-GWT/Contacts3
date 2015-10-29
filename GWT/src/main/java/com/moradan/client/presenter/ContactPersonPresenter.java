package com.moradan.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.moradan.client.gwt_rpc.ContactsServiceAsync;
import com.moradan.client.event.ContactUpdateEvent;
import com.moradan.client.event.ContactCancelEditEvent;
import com.moradan.client.view.ContactPersonView;
import com.moradan.shared.domain.ContactPerson;

public class ContactPersonPresenter implements Presenter, ContactPersonView.Presenter<ContactPerson> {

	private ContactPerson model;
	private final             ContactsServiceAsync rpcService;
	private final                         EventBus eventBus;
	private final ContactPersonView<ContactPerson> display;

	public ContactPersonPresenter(ContactsServiceAsync rpcService, EventBus eventBus, ContactPersonView<ContactPerson> display) {
		this.rpcService = rpcService;
		this.eventBus   = eventBus;
		this.model      = new ContactPerson();
		this.display    = display;
		display.setPresenter(this);
	}

	public ContactPersonPresenter(ContactsServiceAsync rpcService, EventBus eventBus, ContactPersonView<ContactPerson> display, String id) {
		this.rpcService = rpcService;
		this.eventBus   = eventBus;
		this.display    = display;
		display.setPresenter(this);
        /**
         * https://drive.google.com/file/d/0B418nT5Bo9w_engtSTdpVDllY2s/view ( https://github.com/Home-GWT/docs/blob/master/gwt-tutorial-ru.pdf )
         * callback-метод (Асинхронный вызовы)
         */
        rpcService.getContact(id, new AsyncCallback<ContactPerson>() {
			@Override
			public void onSuccess(ContactPerson result) {
				if (result == null) {
                    model = new ContactPerson();
				} else {
                    model = result;
					ContactPersonPresenter.this.display.getFirstName().setValue(model.getFirstName());
					ContactPersonPresenter.this.display.getLastName().setValue(model.getLastName());
					ContactPersonPresenter.this.display.getEmailAddress().setValue(model.getEmailAddress());
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
        model.setFirstName(display.getFirstName().getValue());
        model.setLastName(display.getLastName().getValue());
        model.setEmailAddress(display.getEmailAddress().getValue());
        /**
         * https://drive.google.com/file/d/0B418nT5Bo9w_engtSTdpVDllY2s/view ( https://github.com/Home-GWT/docs/blob/master/gwt-tutorial-ru.pdf )
         * callback-метод (Асинхронный вызовы)
         */
        rpcService.updateContact(model, new AsyncCallback<ContactPerson>() {
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
		eventBus.fireEvent(new ContactCancelEditEvent(model.getId()));
	}

}
