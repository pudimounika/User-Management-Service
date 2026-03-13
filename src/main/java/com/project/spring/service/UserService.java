package com.project.spring.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.project.spring.model.User;
import com.project.spring.repository.UserRepository;
import com.project.spring.exception.UserNotFoundException;
import com.project.spring.dto.UserRequest;
import com.project.spring.dto.UserResponse;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserResponse saveUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    public Page<UserResponse> getAllUsers(Pageable pageable) {

        return userRepository.findAll(pageable)
                .map(this::mapToResponse);

    }


    public UserResponse getUserById(Long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id "+ id));

        return mapToResponse(user);
    }


    public UserResponse updateUser(Long id,UserRequest request) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        existingUser.setName(request.getName());
        existingUser.setEmail(request.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return mapToResponse(updatedUser);
    }

    public void deleteUser(Long id) {
        User deleteUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.delete(deleteUser);
    }

    private UserResponse mapToResponse(User user){
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        return response;
    }

}
