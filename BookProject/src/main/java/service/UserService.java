package service;

import entities.Role;
import entities.User;
import org.hibernate.Session;
import repository.UserRepository;

import javax.persistence.NoResultException;

public class UserService {

    private final Session session;
    private UserRepository userRepository;

    public UserService(Session session) {
        this.session = session;
        userRepository = new UserRepository(session);
    }

    public User addNewUser(String name, String surname, String email, String username, String pass, int phoneNumber, Role role) {
        User user = userRepository.create(User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .username(username)
                .pass(pass)
                .phone_number(phoneNumber)
                .role(role)
                .build());
        return user;
    }


    public User login(String name, String pass) {
        try {
            return (User) this.session.createQuery
                    ("select u from User u where " +
                            "u.name= :userName and u.pass= :userPass")
                    .setParameter("userName", name)
                    .setParameter("userPass", pass)
                    .getSingleResult();

        } catch (NoResultException noResultException) {
            return null;
        }
    }

    public User updateUser(User user){
        userRepository.update(user);
        return user;
    }

    public void deleteTheUser(User user){
        userRepository.delete(user);

    }


}
