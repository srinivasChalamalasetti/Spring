package com.example.demo.Project;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    
    @Autowired 
    JdbcTemplate conn; 

    public int addProject18(Projectpojo p)
    {
        int id = p.getId(); 
        String name = p.getName(); 
        String client = p.getClient(); 
        int assignedBy = p.getAssignedBy(); 
        LocalDate start = p.getStart(); 
        LocalDate end = p.getEnd(); 
        int duration = p.getDuration(); 
        int hr = p.getHr(); 
        int pm = p.getPm();

        String s = "select Rname from Roles where Rid in (select Rid from employee where EmpId = ?)"; 

        List<Map<String,Object>> list = conn.queryForList(s, assignedBy); 
        Object obj = list.get(0).get("Rname"); 
        String temp = (String) obj;   

        if("Admin".equals(temp) || "HR".equals(temp))
        {
            String s1 = "Select Rname from Roles where Rid in (select Rid from employee where EmpId = ?)"; 
            List<Map<String,Object>> li = conn.queryForList(s1, hr); 
            Object ob = li.get(0).get("Rname"); 
            String tp = (String) ob;  

            String s2 = "select Rname from Roles where Rid in (select Rid from employee where EmpId = ?)";
            List<Map<String,Object>> li2 = conn.queryForList(s2,pm); 
            Object ob2 = li2.get(0).get("Rname"); 
            String tp2 = (String) ob2;
            
            if("HR".equals(tp) && "Project_Manager".equals(tp2))
            {
                if(start != null && end != null && duration == 0)
                {
                    long x3 = ChronoUnit.DAYS.between(start, end);
                    int count = (int) x3;   
                    
                    String result = "insert into Project (id, name, client, assignedBy, start, end, duration, hr, pm) Values (?,?,?,?,?,?,?,?,?)";
                    return conn.update(result, id, name, client, assignedBy, start, end, count, hr, pm);
                }                
            }
        }
        return 0;
    }
}
