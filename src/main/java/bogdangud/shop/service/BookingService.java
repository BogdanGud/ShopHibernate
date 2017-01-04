package bogdangud.shop.service;

import bogdangud.shop.dao.CustomerDao;
import bogdangud.shop.dao.BookingDao;
import bogdangud.shop.dao.ProductDao;
import bogdangud.shop.model.Booking;
import bogdangud.shop.model.Customer;
import bogdangud.shop.model.Product;

import java.util.Date;
import java.util.List;

public class BookingService {
    private BookingDao bookingDao = new BookingDao();
    private CustomerDao customerDao = new CustomerDao();
    private ProductDao productDao = new ProductDao();

    public void createNewOrder(int customerId, Date date, int productId) {
        Customer tempCustomer = customerDao.get(customerId);
        Product tempProduct = productDao.get(productId);
        Booking tempBooking = new Booking(tempCustomer, date);
        tempBooking.addProduct(tempProduct);
        bookingDao.add(tempBooking);
    }

    public Booking get(int id) {
        return bookingDao.get(id);
    }

    public void delete(int id) {
        bookingDao.delete(id);
    }

    public void update(Booking newBooking) {
        bookingDao.update(newBooking);
    }

    public List<Booking> getAll() {
        return bookingDao.getAll();
    }
}
