package com.project.spring.controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.project.spring.model.Role;
import com.project.spring.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
     private final RoleService roleService;

     public RoleController(RoleService roleService){
         this.roleService = roleService;
     }
     @PostMapping
     public Role createRole(@RequestBody Role role){
         return roleService.createRole(role);
     }
     @GetMapping
    public List<Role> getRoles() {
         return roleService.getAllRoles();
     }
}
