package models;

public class Order {
    private int id;
    private String orderName;
    private int date;

    public Order(int id, String orderName, int date) {
        this.id = id;
        this.orderName = orderName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
