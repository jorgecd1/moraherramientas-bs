package com.moraherramientas.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tool {
    
    // Fetch and create data to SQL Table

    @Id
    @GeneratedValue
    private Long id;
    private String tool_name;
    private String tool_model;
    private String tool_detail;
    private String tool_description;
    private String tool_code;

    // Getters
    public Long getId(){
        return id;
    }
    public String getTool_name(){
        return tool_name;
    }
    public String getTool_model(){
        return tool_model;
    }
    public String getTool_detail(){
        return tool_detail;
    }
    public String getTool_description(){
        return tool_description;
    }
    public String getTool_code(){
        return tool_code;
    }
    // Setters
    public void setId(Long id){
        this.id = id;
    }
    public void setTool_name(String tool_name){
        this.tool_name = tool_name;
    }
    public void setTool_model(String tool_model){
        this.tool_model = tool_model;
    }
    public void setTool_detail(String tool_detail){
        this.tool_detail = tool_detail;
    }
    public void setTool_description(String tool_description){
        this.tool_description = tool_description;
    }
    public void setTool_code(String tool_code){
        this.tool_code = tool_code;
    }
}
