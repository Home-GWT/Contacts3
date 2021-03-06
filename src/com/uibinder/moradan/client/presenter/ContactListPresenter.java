package com.uibinder.moradan.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.uibinder.moradan.client.rpc.ContactsServiceAsync;
import com.uibinder.moradan.client.event.ContactAddEvent;
import com.uibinder.moradan.client.event.ContactEditEvent;
import com.uibinder.moradan.client.view.ContactListView;
import com.uibinder.moradan.shared.ContactList;

import java.util.ArrayList;
import java.util.List;

public class ContactListPresenter implements Presenter, ContactListView.Presenter<ContactList> {

	public ContactListPresenter(ContactsServiceAsync rpcService, EventBus eventBus, ContactListView<ContactList> view) {
		this.rpcService     = rpcService;
		this.eventBus       = eventBus;
		this.view           = view;
		this.selectionModel = new ListDeleteSelect<ContactList>();
		this.view.setPresenter(this);
	}

	@Override
	public void onAddButtonClicked() {
		eventBus.fireEvent(new ContactAddEvent());
	}

	@Override
	public void onDeleteButtonClicked() {
		deleteSelectedContacts();
	}

	@Override
	public void onItemClicked(ContactList contactDetails) {
		eventBus.fireEvent(new ContactEditEvent(contactDetails.getId()));
	}

	@Override
	public void onItemSelected(ContactList contactDetails) {
		if (selectionModel.isSelected(contactDetails)) {
			selectionModel.removeSelection(contactDetails);
		} else {
			selectionModel.addSelection(contactDetails);
		}
	}

	@Override
	public void go(final HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
		fetchContactDetails();
	}

	public void sortContactDetails() {
		// Yes, we could use a more optimized method of sorting, but the point is to create a test case that helps illustrate the higher level concepts used when creating MVP-based applications.
		for (int i = 0; i < contactDetails.size(); ++i) {
			for (int j = 0; j < contactDetails.size() - 1; ++j) {
				if (contactDetails.get(j).getDisplayName().compareToIgnoreCase(contactDetails.get(j + 1).getDisplayName()) >= 0) {
					ContactList tmp = contactDetails.get(j);
					contactDetails.set(j, contactDetails.get(j + 1));
					contactDetails.set(j + 1, tmp);
				}
			}
		}
	}

	public void setContactDetails(List<ContactList> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<ContactList> getContactDetails() {
		return contactDetails;
	}

	public ContactList getContactDetail(int index) {
		return contactDetails.get(index);
	}

    /**
     * https://drive.google.com/file/d/0B418nT5Bo9w_engtSTdpVDllY2s/view ( https://github.com/Home-GWT/docs/blob/master/gwt-tutorial-ru.pdf )
     * Создайте callback:
     * - Создайте экземпляр AsyncCallback
     * - Когда RPC вызов будет завершен, если все прошло хорошо будет вызван наш onSuccess(T) и мы получим возвращаемое значение в аргументе result
     * - Если что-то пойдет не так, GWT вызовет метод onFailure(Throwable), передающий нам исключение
     * - Сделайте вызов
     * ( Учтите, что можно кэшировать прокси сервиса для последующих вызовов сервиса. Когда вы вызываете удаленный метод getPrices(String[]), FlexTable содержащая ваш список будет обновлена или, в случае неудачи, ничего не произойдет )
     */
	private void fetchContactDetails() {
		rpcService.getContactDetails(new AsyncCallback<ArrayList<ContactList>>() {
			@Override
			public void onSuccess(ArrayList<ContactList> result) {
				contactDetails = result;
				sortContactDetails();
				view.setRowData(contactDetails);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error fetching contact details");
			}
		});
	}

	private void deleteSelectedContacts() {
		List<ContactList> selectedContacts = selectionModel.getSelectedItems();
		ArrayList<String> ids = new ArrayList<String>();

		for (int i = 0; i < selectedContacts.size(); ++i) {
			ids.add(selectedContacts.get(i).getId());
		}

		rpcService.deleteContacts(ids, new AsyncCallback<ArrayList<ContactList>>() {
			@Override
			public void onSuccess(ArrayList<ContactList> result) {
				contactDetails = result;
				sortContactDetails();
				view.setRowData(contactDetails);
			}

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Error deleting selected contacts");
			}
		});
	}

    private                  List<ContactList> contactDetails;
    private final         ContactsServiceAsync rpcService;
    private final                     EventBus eventBus;
    private final ContactListView<ContactList> view;
    private final ListDeleteSelect<ContactList> selectionModel;
}
