package bogdangud.shop.dao;


import bogdangud.shop.model.Booking;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookingDao {
    private EntityManager em = Persistence.createEntityManagerFactory("SHOP").createEntityManager();

    public Booking add(Booking newBooking) {
        em.getTransaction().begin();
        Booking bookingFromDB = em.merge(newBooking);
        em.getTransaction().commit();
        return bookingFromDB;
    }

    public Booking get(int id) {
        return em.find(Booking.class, id);
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public void update(Booking booking) {
        em.getTransaction().begin();
        em.merge(booking);
        em.getTransaction().commit();
    }

    public List<Booking> getAll() {
        TypedQuery<Booking> namedQuery = em.createNamedQuery("Order.getAll", Booking.class);
        return namedQuery.getResultList();
    }

}
