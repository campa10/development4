package Entities;

import java.util.List;

public class Items {

    private List<Object>  items;

    private String error;

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}