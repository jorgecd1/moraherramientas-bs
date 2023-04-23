package com.moraherramientas.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.moraherramientas.project.repository.TicketRepository;
import com.moraherramientas.project.exception.TicketNotFound;
import com.moraherramientas.project.model.Ticket;

@RestController
@CrossOrigin("http://localhost:3000")
public class TicketController {
    
    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/ticket")
    Ticket newTicket(@RequestBody Ticket newTicket){
        return ticketRepository.save(newTicket);
    }

    @GetMapping("/tickets")
    List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    @GetMapping("/ticket/{id}")
    Ticket getTicketById(@PathVariable Long id){
        return ticketRepository.findById(id)
        .orElseThrow(()->new TicketNotFound(id));
    }

    @PutMapping("/ticket/{id}")
    Ticket updaTicket(@RequestBody Ticket newTicket, @PathVariable Long id){
        return ticketRepository.findById(id)
        .map(ticket -> {
            ticket.setTicket_title(newTicket.getTitle());
            ticket.setTicket_status(newTicket.getStatus());
            ticket.setTicket_description(newTicket.getDescription());
            ticket.setTicket_resolution(newTicket.getResolution());
            ticket.setTicket_created_date(newTicket.getCreatedDate());
            ticket.setTicket_last_date(newTicket.getLastDateUpdate());
            ticket.setTicket_assigned_tool(newTicket.getAssignedTool());
            return ticketRepository.save(ticket);
        }).orElseThrow(()->new TicketNotFound(id));
    }

    @DeleteMapping("/ticket/{id}")
    String deleteTicket(@PathVariable Long id){
        if(!ticketRepository.existsById(id)){
            throw new TicketNotFound(id);
        }
        ticketRepository.deleteById(id);
        return "Tool with id#" + id + " has been deleted.";
    }

}
