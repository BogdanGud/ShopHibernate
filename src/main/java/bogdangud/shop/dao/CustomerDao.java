package bogdangud.shop.dao;

import bogdangud.shop.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDao {
    private EntityManager em = Persistence.createEntityManagerFactory("SHOP").createEntityManager();

    public Customer add(Customer newCustomer) {
        em.getTransaction().begin();
        Customer customerFromDB = em.merge(newCustomer);
        em.getTransaction().commit();
        return customerFromDB;
    }

    public Customer get(int id) {
        return em.find(Customer.class, id);
    }

    public void delete (int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(Customer customer) {
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }

    public List<Customer> getAll() {
        TypedQuery<Customer> namedQuery = em.createNamedQuery("Customer.getAll", Customer.class);
        return namedQuery.getResultList();
    }


}
