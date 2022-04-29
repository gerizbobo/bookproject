package service;

import entities.Book;
import entities.Order;
import entities.OrderLine;
import org.hibernate.Session;
import repository.OrderLineRepository;

public class OrderLineService {
    private final Session session;
    OrderLineRepository orderLineRepository;

    public OrderLineService(Session session) {
        this.session = session;
        orderLineRepository= new OrderLineRepository(session);


    }

    public OrderLine addNewOrderLine(int count, Book book, Order order){
        OrderLine orderLine= orderLineRepository.create(OrderLine.builder()
        .count(count)
        .book(book).order(order).build());
        return orderLine;




    }
}
