package com.project.spring.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.spring.model.User;
import org.springframework.data.domain.Pageable;

public interface UserRepository extends JpaRepository<User,Long>{
 Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
