package com.uibinder.moradan.client.presenter;

import java.util.ArrayList;
import java.util.List;

public class ListDeleteSelect<T> {
  List<T> selectedItems = new ArrayList<T>();
  
  public List<T> getSelectedItems() {
    return selectedItems;
  }
  
  public void addSelection(T item) {
    selectedItems.add(item);
  }
  
  public void removeSelection(T item) {
    selectedItems.remove(item);
  }
  
  public boolean isSelected(T item) {
    return selectedItems.contains(item);
  }
}