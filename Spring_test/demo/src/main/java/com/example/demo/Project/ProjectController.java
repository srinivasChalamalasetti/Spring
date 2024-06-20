package com.example.demo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/add")
public class ProjectController {
    
    @Autowired 
    ProjectService ps; 

    @PostMapping("/project")
    public String add(@RequestBody Projectpojo p)
    {
        int temp = ps.addProject18(p); 
        return (temp > 0)? "Project Inserted " : "Project not inserted ";
    }
}
