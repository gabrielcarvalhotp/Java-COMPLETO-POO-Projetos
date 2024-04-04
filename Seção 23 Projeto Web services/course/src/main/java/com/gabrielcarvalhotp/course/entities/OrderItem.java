package com.gabrielcarvalhotp.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabrielcarvalhotp.course.entities.constranties.OrderItemPrimaryKey;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    @EmbeddedId
    private final OrderItemPrimaryKey id = new OrderItemPrimaryKey();

    private Integer quantity;

    private Double price;

    public OrderItem() {}

    public OrderItem(Product product, Order order, Integer quantity, Double price) {
        id.setProduct(product);
        id.setOrder(order);
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setPrice(Product product) {
        id.setProduct(product);
    }

    public Double getSubTotal() {
        return this.getPrice() * this.getQuantity();
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setPrice(Order order) {
        id.setOrder(order);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
