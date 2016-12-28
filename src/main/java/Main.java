import bogdangud.shop.dao.CustomerDao;
import bogdangud.shop.dao.OrderDao;
import bogdangud.shop.dao.OrderItemDao;
import bogdangud.shop.dao.ProductDao;
import bogdangud.shop.model.Customer;
import bogdangud.shop.model.Order;
import bogdangud.shop.model.OrderItem;
import bogdangud.shop.model.Product;
import bogdangud.shop.service.CustomerService;
import bogdangud.shop.service.OrderService;
import bogdangud.shop.service.ProductService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();


//        Customer bob = new Customer("Jack", "078453642", "WalkStreet");
//        customerService.create(bob);
//        System.out.println(customerService.getAll());

//        Product tv = new Product("Samsung Smart TV 3000", 2450d);
//        productService.create(tv);
        orderService.createNewOrder(1, new Date(), 3);

       // System.out.println(productService.getAll());
      //  System.out.println(productService.get(5));

    }
}
