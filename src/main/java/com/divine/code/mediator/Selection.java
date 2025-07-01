package com.divine.code.mediator;

public class Selection implements Component {
    private String id;
    private String selectedItem;
    private OnItemSelectedListener listener;
    private View view;

    public Selection(String id) {
        this.id = id;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public void onItemSelected(String selectedItem) {
        this.selectedItem = selectedItem;
        if (listener != null) {
            listener.onItemSelected(view, selectedItem);
        }
    }
}