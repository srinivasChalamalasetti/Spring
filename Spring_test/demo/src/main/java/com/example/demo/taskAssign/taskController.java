package com.example.demo.taskAssign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/Giving")
public class taskController {

    @Autowired 
    taskService ts; 

    @PostMapping("/task")
    public String add(@RequestBody task t)
    {
        int temp = ts.addTask(t); 
        return (temp > 0)? "Task Assigned" : "Task not Assigned";
    }
    
}
