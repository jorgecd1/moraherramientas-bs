package com.moraherramientas.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {
    
    @Id
    @GeneratedValue
    private Long id;
    private String ticket_title;
    private String ticket_status;
    private String ticket_description;
    private String ticket_resolution;
    private String ticket_created_date;
    private String ticket_last_date;
    private String ticket_assigned_tool;

    // Getters
    public Long getId(){
        return id;
    }
    public String getTitle(){
        return ticket_title;
    }
    public String getStatus(){
        return ticket_status;
    }
    public String getDescription(){
        return ticket_description;
    }
    public String getResolution(){
        return ticket_resolution;
    }
    public String getCreatedDate(){
        return ticket_created_date;
    }
    public String getLastDateUpdate(){
        return ticket_last_date;
    }
    public String getAssignedTool(){
        return ticket_assigned_tool;
    }

    // Setters
    public void setId(Long id){
        this.id = id;
    }
    public void setTicket_title(String ticket_title){
        this.ticket_title = ticket_title;
    }
    public void setTicket_status(String ticket_status){
        this.ticket_status = ticket_status;
    }
    public void setTicket_description(String ticket_description){
        this.ticket_description = ticket_description;
    }
    public void setTicket_resolution(String ticket_resolution){
        this.ticket_resolution = ticket_resolution;
    }
    public void setTicket_created_date(String ticket_created_date){
        this.ticket_created_date = ticket_created_date;
    }
    public void setTicket_last_date(String ticket_last_date){
        this.ticket_last_date = ticket_last_date;
    }
    public void setTicket_assigned_tool(String ticket_assigned_tool){
        this.ticket_assigned_tool = ticket_assigned_tool;
    }
}
