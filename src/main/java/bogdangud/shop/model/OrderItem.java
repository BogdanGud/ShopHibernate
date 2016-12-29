package bogdangud.shop.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@NamedQuery(name = "OrderItem.getAll", query = "SELECT item from OrderItem item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (!id.equals(orderItem.id)) return false;
        if (!order.equals(orderItem.order)) return false;
        return product.equals(orderItem.product);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + order.hashCode();
        result = 31 * result + product.hashCode();
        return result;
    }
}
