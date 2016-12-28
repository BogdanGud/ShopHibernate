package bogdangud.shop.dao;

import bogdangud.shop.model.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderItemDao {
    private EntityManager em = Persistence.createEntityManagerFactory("SHOP").createEntityManager();

    public OrderItem add(OrderItem orderItem) {
        em.getTransaction().begin();
        OrderItem item = em.merge(orderItem);
        em.getTransaction().commit();
        return item;
    }

    public List<OrderItem> getAll() {
        TypedQuery<OrderItem> namedQuery = em.createNamedQuery("OrderItem.getAll", OrderItem.class);
        return namedQuery.getResultList();
    }

    public OrderItem get(int id){
        return em.find(OrderItem.class, id);
    }

    public void update(OrderItem orderItem) {
        em.getTransaction().begin();
        em.merge(orderItem);
        em.getTransaction().commit();
    }

    public void delete (int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

}
