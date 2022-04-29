package service;

import entities.Role;
import lombok.Builder;
import org.hibernate.Session;
import repository.RoleRepository;

import java.util.List;

public class RoleService {
    private final Session session;
    private RoleRepository roleRepository;

    public RoleService(Session session) {
        this.session = session;
        roleRepository= new RoleRepository(session);
    }

    public Role addNewRole(String roles){
       Role role= roleRepository.create(Role.builder()
               .role(roles)
               .build());

       return role;


    }

}
