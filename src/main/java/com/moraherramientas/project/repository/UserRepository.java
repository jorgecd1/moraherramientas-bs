package com.moraherramientas.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moraherramientas.project.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
