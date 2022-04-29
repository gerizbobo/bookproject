package service;

import org.hibernate.Session;
import entities.Order;
import entities.User;
import lombok.AllArgsConstructor;
import repository.OrderRepository;

public class OrderService {
    private final Session session;
    private OrderRepository orderRepository;

    public OrderService(Session session) {
        this.session = session;
        orderRepository= new OrderRepository(session);
    }

    public Order addNewOrders(User user) {
        Order orders = orderRepository.create(Order.builder()
                .user(user)
                .build());

        return orders;
    }
}