package com.project.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.spring.model.User;
public interface UserRepository extends JpaRepository<User,Long>{
}
