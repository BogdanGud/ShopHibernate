package bogdangud.shop.service;

import bogdangud.shop.dao.CustomerDao;
import bogdangud.shop.dao.OrderDao;
import bogdangud.shop.dao.ProductDao;
import bogdangud.shop.model.Customer;
import bogdangud.shop.model.Order;
import bogdangud.shop.model.Product;

import java.util.Date;
import java.util.List;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private CustomerDao customerDao = new CustomerDao();
    private ProductDao productDao =  new ProductDao();

    public void createNewOrder(int customerId, Date date, int productId) {
        Customer tempCustomer = customerDao.get(customerId);
        Product tempProduct = productDao.get(productId);
        Order tempOrder = new Order(tempCustomer, date);
        tempOrder.addProduct(tempProduct);
        orderDao.add(tempOrder);
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
