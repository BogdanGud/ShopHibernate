package bogdangud.shop.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "booking")
@NamedQuery(name = "Order.getAll", query = "select o from Order o")
public class Order {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    private Set<Product> products = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Column(name = "date")
    private Date date;

    public Order() {
    }

    public Order(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        return date != null ? date.equals(order.date) : order.date == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
