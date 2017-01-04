package bogdangud.shop.service;

import bogdangud.shop.dao.CustomerDao;
import bogdangud.shop.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    public void create(Customer newCustomer) {
        customerDao.add(newCustomer);
    }

    public Customer get(int id) {
        return customerDao.get(id);
    }

    public void delete(int id) {
        customerDao.delete(id);
    }

    public void update(Customer newCustomer) {
        customerDao.update(newCustomer);
    }

    public List<Customer> getAll() {
        return customerDao.getAll();
    }

}
