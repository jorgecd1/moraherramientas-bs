package com.moraherramientas.project.exception;

public class ToolNotFound extends RuntimeException {
    public ToolNotFound(Long id){
        super("Could not find tool with id#" + id);
    }
}
