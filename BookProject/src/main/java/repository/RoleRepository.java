package repository;

import entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


@AllArgsConstructor
public class RoleRepository implements Repository<Role , Integer> {
    private final Session session;

    @Override
    public Role create(Role role) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();


        }
        return role;
    }

    @Override
    public List<Role> readAll() {
        return null;
    }

    @Override
    public Role read(Integer integer) {
        return null;
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public void delete(Role role) {

    }

}


