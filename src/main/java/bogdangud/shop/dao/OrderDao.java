package bogdangud.shop.dao;

import bogdangud.shop.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderDao {
    private EntityManager em = Persistence.createEntityManagerFactory("SHOP").createEntityManager();

    public Order add(Order newOrder) {
        em.getTransaction().begin();
        Order orderFromDB = em.merge(newOrder);
        em.getTransaction().commit();
        return orderFromDB;
    }

    public Order get(int id) {
        return em.find(Order.class, id);
    }

    public void delete (int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(Order order) {
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }

    public List<Order> getAll() {
        TypedQuery<Order> namedQuery = em.createNamedQuery("Order.getAll", Order.class);
        return namedQuery.getResultList();
    }
    
}
