package com.example.demo.ProjectDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/add")
public class DetailsController {
    
    @Autowired 
    DetailsService ds; 

    @PostMapping("/ProjectDetails")

    public String empAdd(@RequestBody Details p)
    {
        int temp = ds.addEmployee(p); 
        return (temp > 0) ? "Employee added to project" : " Employee not added to project";
    }
}
