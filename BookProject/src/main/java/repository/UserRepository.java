package repository;

import entities.User;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@AllArgsConstructor
public class UserRepository implements Repository<User, Integer> {

    private final Session session;


    @Override
    public User create(User user) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
        return user;
    }

    @Override
    public List<User> readAll() {
        return null;
    }

    @Override
    public User read(Integer integer) {
        return null;
    }

    @Override
    public User update(User user) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void delete(User user) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
