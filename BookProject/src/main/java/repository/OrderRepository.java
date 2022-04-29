package repository;

import entities.Order;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
@AllArgsConstructor
public class OrderRepository implements Repository<Order,Integer> {
    private final Session session;



    @Override
    public Order create(Order orders) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(orders);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> readAll() {
        return null;
    }

    @Override
    public Order read(Integer integer) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void delete(Order order) {

    }


}