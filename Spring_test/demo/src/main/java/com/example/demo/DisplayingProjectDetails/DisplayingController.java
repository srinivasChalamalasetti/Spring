package com.example.demo.DisplayingProjectDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("Data")
public class DisplayingController {

    @Autowired 
    DisplayingService ds;  

    @GetMapping("/Displaying")
    public List<Map<String,Object>> project(@RequestBody Displaying temp)
    {
        List<Map<String,Object>> list = ds.myData(temp); 
        
        if(list.isEmpty())
        {
            HashMap<String,Object> map = new HashMap<>(); 
            map.put("Null","Data"); 
            list.add(map);
        } 
        return list;
    }
    
}
