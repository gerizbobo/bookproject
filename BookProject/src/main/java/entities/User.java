package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String username;
    @Column
    private String pass;
    @Column
    private int phone_number;
    @Column
    private String email;

   @ManyToOne
   @JoinColumn(name="RoleId")
   private Role role;

   @OneToMany(mappedBy = "user")
   private List<Library>library;

   @OneToMany(mappedBy = "user")
    private List<Review>review;

   @OneToMany(mappedBy = "user")
    private List<Order>order;





}
