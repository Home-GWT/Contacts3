package com.uibinder.moradan.client.view;

import com.google.gwt.user.client.ui.Widget;

import java.util.List;

public interface ContactListView<T> {
    void setPresenter(Presenter<T> presenter);
    void setRowData(List<T> rowData);
    Widget asWidget();

	public interface Presenter<T> {
		void onAddButtonClicked();
		void onDeleteButtonClicked();
		void onItemClicked(T clickedItem);
		void onItemSelected(T selectedItem);
	}
}
