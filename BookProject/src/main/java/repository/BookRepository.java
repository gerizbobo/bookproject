package repository;

import entities.Book;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@AllArgsConstructor
public class BookRepository implements Repository<Book, Integer>{
    private final Session session;

    @Override
    public Book create(Book book) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }

        return book;
    }

    @Override
    public List<Book> readAll() {
        return null;
    }

    @Override
    public Book read(Integer integer) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(Book book) {

    }

}
