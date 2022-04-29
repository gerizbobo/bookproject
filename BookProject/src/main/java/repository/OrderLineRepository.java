package repository;

import entities.OrderLine;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
@AllArgsConstructor
public class OrderLineRepository implements Repository<OrderLine, Integer>{
   private final Session session;
    @Override
    public OrderLine create(OrderLine orderLine) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(orderLine);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return orderLine;
    }

    @Override
    public List<OrderLine> readAll() {
        return null;
    }

    @Override
    public OrderLine read(Integer integer) {
        return null;
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        return null;
    }

    @Override
    public void delete(OrderLine orderLine) {

    }

}
