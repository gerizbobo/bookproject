package service;

import entities.Book;
import entities.Role;
import entities.User;
import org.hibernate.Session;
import repository.BookRepository;
import repository.UserRepository;

import java.time.LocalDate;

public class BookService {

    private final Session session;
    private BookRepository bookRepository;

    public BookService(Session session) {
        this.session = session;
        bookRepository = new BookRepository(session);
    }

    public Book addNewBook(String author, String title, String summary, String publisherHouse, int  publisherYear) {
        Book book = bookRepository.create(Book.builder()
                .author(author)
                .title(title)
                .summary(summary)
                .publisher_House(publisherHouse)
                .publisher_Year(publisherYear)
                .build());
        return book;
    }
}

