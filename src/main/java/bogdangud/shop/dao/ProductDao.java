package bogdangud.shop.dao;

import bogdangud.shop.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDao {
    private EntityManager em = Persistence.createEntityManagerFactory("SHOP").createEntityManager();

    public Product add(Product newProduct) {
        em.getTransaction().begin();
        Product productFromDB = em.merge(newProduct);
        em.getTransaction().commit();
        return productFromDB;
    }

    public Product get(int id) {
        return em.find(Product.class, id);
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(Product product) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

    public List<Product> getAll() {
        TypedQuery<Product> namedQuery = em.createNamedQuery("Product.getAll", Product.class);
        return namedQuery.getResultList();
    }
}
