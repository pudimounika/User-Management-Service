package com.project.spring.controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.project.spring.dto.UserRequest;
import com.project.spring.dto.UserResponse;
import com.project.spring.model.User;
import com.project.spring.service.UserService;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/api/users")
@Tag(name="User API",description = "User management operations")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "Create new user")
    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserRequest request){
        return userService.saveUser(request);
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public Page<UserResponse> getUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @Operation(summary = "Update user")
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id,@Valid @RequestBody UserRequest request) {
        return userService.updateUser(id,request);
    }

    @Operation(summary = "Delete user")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
         userService.deleteUser(id);
    }

    @Operation(summary = "Search user")
    @GetMapping("/search")
    public Page<UserResponse> search(@RequestParam String name,Pageable pageable) {
        return userService.searchUsers(name,pageable);
    }

}
