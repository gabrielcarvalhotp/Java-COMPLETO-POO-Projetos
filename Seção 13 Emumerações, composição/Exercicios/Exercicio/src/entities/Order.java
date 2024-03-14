package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus orderStatus;
    private Client client;

    private List<OrderItem> orderItemList = new ArrayList<>();

    public Order(){

    }

    public Order(Date moment, OrderStatus orderStatus, Client client) {
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.getOrderItemList().add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        this.getOrderItemList().remove(orderItem);
    }

    public double total() {
        double sum = 0;
        for (OrderItem orderItem: orderItemList) {
            sum += orderItem.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("Order moment: " + sdf.format(moment) + "\n")
                .append("Order status: " + orderStatus + "\n")
                .append("Client: " + client + "\n")
                .append("Order items: \n");

        for (OrderItem orderItem: orderItemList) {
            stringBuilder.append(orderItem + "\n");
        }
        stringBuilder.append(String.format("Total price: $%.2f \n", total()));

        return stringBuilder.toString();
    }
}
