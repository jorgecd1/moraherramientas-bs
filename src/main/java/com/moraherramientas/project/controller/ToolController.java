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

import com.moraherramientas.project.repository.ToolRepository;
import com.moraherramientas.project.exception.ToolNotFound;
import com.moraherramientas.project.model.Tool;

@RestController
@CrossOrigin("http://localhost:3000")
public class ToolController {
    
    @Autowired
    private ToolRepository toolRepository;

    @PostMapping("/tool")
    Tool newTool(@RequestBody Tool newTool){
        return toolRepository.save(newTool);
    }

    @GetMapping("/tools")
    List<Tool> getAllTools(){
        return toolRepository.findAll();
    }

    @GetMapping("/tool/{id}")
    Tool getToolById(@PathVariable Long id){
        return toolRepository.findById(id)
        .orElseThrow(()-> new ToolNotFound(id));
    }

    // tool_name, tool_model, tool_detail, tool_description, tool_code

    @PutMapping("/tool/{id}")
    Tool updateTool(@RequestBody Tool newTool, @PathVariable Long id){
        return toolRepository.findById(id)
        .map(tool -> {
            tool.setTool_name(newTool.getTool_name());
            tool.setTool_model(newTool.getTool_model());
            tool.setTool_detail(newTool.getTool_detail());
            tool.setTool_description(newTool.getTool_description());
            tool.setTool_code(newTool.getTool_code());
            return toolRepository.save(tool);
        }).orElseThrow(()->new ToolNotFound(id));
    }

    @DeleteMapping("/tool/{id}")
    String deleteUser(@PathVariable Long id){
        if(!toolRepository.existsById(id)){
            throw new ToolNotFound(id);
        }
        toolRepository.deleteById(id);
        return "Tool with id#" + id + " has been deleted.";
    }

}
