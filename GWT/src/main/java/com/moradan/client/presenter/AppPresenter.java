package com.moradan.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.moradan.client.event.*;
import com.moradan.client.view.ContactPersonViewImpl;
import com.moradan.client.gwt_rpc.ContactsServiceAsync;
import com.moradan.client.view.ContactListViewImpl;

public class AppPresenter implements Presenter, ValueChangeHandler<String> {
	private final             EventBus eventBus;
	private final ContactsServiceAsync rpcService;
	private                 HasWidgets container;
	private        ContactListViewImpl contactsView;
	private      ContactPersonViewImpl editContactView;

	public AppPresenter(ContactsServiceAsync rpcService, EventBus eventBus) {
		this.eventBus   = eventBus;
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(ContactAddEvent.TYPE,
				new ContactAddEventHandler() {
					@Override
					public void onAddContact(ContactAddEvent event) {
						doAddNewContact();
					}
				});

		eventBus.addHandler(ContactEditEvent.TYPE,
				new ContactEditEventHandler() {
					@Override
					public void onEditContact(ContactEditEvent event) {
						doEditContact(event.getId());
					}
				});

		eventBus.addHandler(ContactCancelEditEvent.TYPE,
				new ContactCancelEditEventHandler() {
					@Override
					public void onEditContactCancelled(ContactCancelEditEvent event) {
						doEditContactCancelled();
					}
				});

		eventBus.addHandler(ContactUpdateEvent.TYPE,
				new ContactUpdateEventHandler() {
					@Override
					public void onContactUpdated(ContactUpdateEvent event) {
						doContactUpdated();
					}
				});
	}

	private void doAddNewContact() {
		History.newItem("add");
	}

	private void doEditContact(String id) {
		History.newItem("edit" + id);
	}

	private void doEditContactCancelled() {
		History.newItem("list");
	}

	private void doContactUpdated() {
		History.newItem("list");
	}

	@Override
	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("list");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		final String token = event.getValue();

		if (token != null) {
			if (token.equals("list")) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess() {
						new ContactListPresenter(rpcService, eventBus, getContactsView()).go(container);
					}
				});
			} else if (token.equals("add") || token.equals("edit")) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess() {
						new ContactPersonPresenter(rpcService, eventBus, getEditContactView()).go(container);
					}
				});
			} else if (token.startsWith("edit")) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess() {
						new ContactPersonPresenter(rpcService, eventBus, getEditContactView(), token.substring("edit".length())).go(container);
					}
				});
			}
		}
	}

	private ContactPersonViewImpl getEditContactView() {
		if (editContactView == null) {
			editContactView = new ContactPersonViewImpl();
		}
		return editContactView;
	}

	private ContactListViewImpl getContactsView() {
		if (contactsView == null) {
			contactsView = new ContactListViewImpl();
		}
		return contactsView;
	}
}
