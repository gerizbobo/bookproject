import com.config.HibernateConfig;
import entities.Book;
import entities.Order;
import entities.Role;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.*;

import java.time.LocalDate;

import java.time.LocalDate;

public class Main {
    public static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    public static Session session = sessionFactory.openSession();


    public static void main(String[] args) {

        UserService userService = new UserService(session);
        RoleService roleService= new RoleService(session);
        BookService bookService= new BookService(session);
        OrderService ordersService=new OrderService(session);
        OrderLineService orderLineService = new OrderLineService(session);
        Role adminRole= roleService.addNewRole("Admin");
        Role userRole= roleService.addNewRole("User");
        User user1= userService.addNewUser("Romina", "Bishani","rominabishani@gmail.com", "romina","1234",687362842, userRole);
        User user2= userService.addNewUser("Dea", "Sojati","deasojati@gmail.com", "dea","3476",697365736, adminRole);
        Book book1 = bookService.addNewBook("Ismail Kadare", "Dimri i thyer", "A book about Albanian Drama", "Pegi", 1999);
        Book book2 = bookService.addNewBook("Khaled Hosseini", "Gjuetari i balonave", "A book about war and emigration", "Pegi", 1965);
        Order order1= ordersService.addNewOrders(user1);
        Order order2= ordersService.addNewOrders(user2);
        orderLineService.addNewOrderLine(10, book1, order1);
        User user = userService.login("romina", "1234");
        if(user== null){
            System.out.println("Nuk u gjet");
        }else{
            System.out.println("Logimi u be me sukses");
        }

        user1.setName("Denalda");
        userService.updateUser(user);
        userService.deleteTheUser(user1);












    }

}
