package bogdangud.shop.controller;

import bogdangud.shop.model.Product;
import bogdangud.shop.service.BookingService;
import bogdangud.shop.service.CustomerService;
import bogdangud.shop.service.ProductService;

public class ConsoleController {
    private ProductService productService = new ProductService();
    private CustomerService customerService = new CustomerService();
    private BookingService bookingService = new BookingService();

    public void work() {

    }

    public void addProduct(String name, Double price) {
        productService.create(new Product(name, price));
    }

    public void printAllProducts () {
        System.out.println(productService.getAll());
    }

}
