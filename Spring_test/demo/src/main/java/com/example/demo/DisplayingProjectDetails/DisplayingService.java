package com.example.demo.DisplayingProjectDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DisplayingService { 

    @Autowired 
    JdbcTemplate conn;
    
    public List<Map<String,Object>> myData(Displaying temp)
    {
        int id = temp.getId();   

        String str = "select id, name client, assignedBy, start, end, duration, HR, PM from Project where id = ?";
        List<Map<String,Object>> l1 = conn.queryForList(str, id); 
        

        String s = "select eid from projectDetails where pid = ?"; 
        List<Map<String,Object>> l2 = conn.queryForList(s,id);
        List<Integer> l3 = l2.stream().map(row->(Integer) row.get("eid")).collect(Collectors.toList()); 
        
        List<Map<String,Object>> empy = new ArrayList<>();  
        for(int j : l3)
        {
            String st = "select *from employee where EmpId = ?"; 
            List<Map<String,Object>> set = conn.queryForList(st,j); 

            if(!set.isEmpty())
            {
                empy.add(set.get(0));
            }
        }  

        String ls = "select elead from projectDetails where pid = ?"; 
        List<Map<String,Object>> l4 = conn.queryForList(ls,id); 
        List<Integer> lp3 = l4.stream().map(row->(Integer) row.get("elead")).collect(Collectors.toList());
        Set<Integer> sp = new HashSet<>(lp3); 
        List<Integer> lp = new ArrayList<>(sp);


        List<Map<String,Object>> etemp = new ArrayList<>(); 
        for(int i : lp) {
            String f = "select *from employee where EmpId = ?";
            List<Map<String,Object>> t = conn.queryForList(f,i); 
            if(!t.isEmpty()) etemp.add(t.get(0));
        }

        Map<String,Object> result = new HashMap<>();
        result.put("Employee", empy);  
        result.put("Project_Leads", etemp);  
        result.put("Project_Details",l1); 
        
        return List.of(result);
    }
}
