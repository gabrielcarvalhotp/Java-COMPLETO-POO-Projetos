package entities;

public class OrderItem {

    private Integer quantity;
    private Product product;
    public OrderItem() {
    }
    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double subTotal() {
        return this.getProduct().getPrice() * this.getQuantity();
    }

    @Override
    public String toString() {
        return getProduct().getName() + ", " + String.format("$%.2f", getProduct().getPrice()) + ", Quantity: " +
                getQuantity() + ", Subtotal: " + String.format("$%.2f", subTotal());
    }
}
