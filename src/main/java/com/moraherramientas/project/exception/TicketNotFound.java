package com.moraherramientas.project.exception;

public class TicketNotFound extends RuntimeException{
    public TicketNotFound(Long id){
        super("Could not find ticket with tool id#" + id);
    }
}
