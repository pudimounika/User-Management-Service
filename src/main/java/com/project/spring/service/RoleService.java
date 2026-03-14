package com.project.spring.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.project.spring.model.Role;
import com.project.spring.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Role createRole(Role role){
        return roleRepository.save(role);
    }
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

}
