package com.moraherramientas.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moraherramientas.project.model.Tool;

public interface ToolRepository extends JpaRepository<Tool, Long>{
    
}
