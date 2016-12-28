package bogdangud.shop.service;

import bogdangud.shop.dao.CustomerDao;
import bogdangud.shop.dao.OrderDao;
import bogdangud.shop.dao.OrderItemDao;
import bogdangud.shop.dao.ProductDao;
import bogdangud.shop.model.Customer;
import bogdangud.shop.model.Order;
import bogdangud.shop.model.OrderItem;
import bogdangud.shop.model.Product;

import java.util.Date;
import java.util.List;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private OrderItemDao orderItemDao = new OrderItemDao();
    private CustomerDao customerDao = new CustomerDao();
    private ProductDao productDao = new ProductDao();

    public void createNewOrder(int customerId, Date date, int productId) {
        Product tempProduct = productDao.get(productId);
        Customer tempCustomer = customerDao.get(customerId);
        Order tempOrder = orderDao.add(new Order(tempCustomer, date));

        OrderItem tempOrderItem =  new OrderItem(tempOrder, tempProduct);
        System.out.println(tempOrderItem.toString());
        orderItemDao.add(tempOrderItem);
    }

    public Order get(int id) {
        return orderDao.get(id);
    }

    public void delete(int id) {
        orderDao.delete(id);
    }

    public void update(Order newOrder) {
        orderDao.update(newOrder);
    }

    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
