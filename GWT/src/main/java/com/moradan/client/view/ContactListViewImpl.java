package com.moradan.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import com.moradan.shared.ContactList;

import java.util.List;

public class ContactListViewImpl extends Composite implements ContactListView<ContactList> {

	@UiTemplate("ContactListView.ui.xml")
	interface ContactsViewUiBinder extends UiBinder<Widget, ContactListViewImpl> {}
	private static ContactsViewUiBinder uiBinder = GWT.create(ContactsViewUiBinder.class);

	@UiField
	FlexTable contactsTable;
	@UiField
	Button addButton;
	@UiField
	Button deleteButton;

	private Presenter<ContactList> presenter;
	private List<ContactList> rowData;

	public ContactListViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("addButton")
	void onAddButtonClicked(@SuppressWarnings("unused") ClickEvent event) {
		if (presenter != null) {
			presenter.onAddButtonClicked();
		}
	}

	@UiHandler("deleteButton")
	void onDeleteButtonClicked(@SuppressWarnings("unused") ClickEvent event) {
		if (presenter != null) {
			presenter.onDeleteButtonClicked();
		}
	}

	@UiHandler("contactsTable")
	void onTableClicked(ClickEvent event) {
		if (presenter != null) {
			HTMLTable.Cell cell = contactsTable.getCellForEvent(event);

			if (cell != null) {
				// Suppress clicks if the user is actually selecting the check box
				if (cell.getCellIndex() > 0) {
					presenter.onItemClicked(rowData.get(cell.getRowIndex()));
				} else {
					presenter.onItemSelected(rowData.get(cell.getRowIndex()));
				}
			}
		}
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void setPresenter(Presenter<ContactList> presenter) {
		this.presenter = presenter;

	}

	@Override
	public void setRowData(List<ContactList> rowData) {
		contactsTable.removeAllRows();
		for (int i = 0; i < rowData.size(); i++) {
			contactsTable.setWidget(i, 0, new CheckBox());
			contactsTable.setText(i, 1, rowData.get(i).getDisplayName());
		}
		this.rowData = rowData;
	}
}
