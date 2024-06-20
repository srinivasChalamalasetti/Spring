package com.example.demo.taskAssign;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class taskService {
    
    @Autowired 
    JdbcTemplate conn; 

    public int addTask(task t)
    {
        int id = t.getId();
        String name = t.getName(); 
        int createdBy = t.getCreatedBy(); 
        LocalDate creatDate = t.getCreatedDate(); 
        System.out.println(creatDate);
        int duration = t.getDuration();
        LocalDate start = t.getStart(); 
        String status = t.getStatus();
        String description = t.getDescription();

        String str = "select Rname from Roles where Rid in (select Rid from employee where EmpId = ?)"; 
        List<Map<String,Object>> list = conn.queryForList(str, createdBy); 
        Object obj = list.get(0).get("Rname"); 
        String temp = (String) obj; 

        if("Lead".equals(temp))
        {
            String s = "select eid from projectDetails where elead = "+createdBy; 
            List<Map<String,Object>> lt = conn.queryForList(s); 
            System.out.println(lt); 
            Object obj1 = lt.get(0).get("eid"); 
            int num = (int) obj1;   

            if(creatDate.isBefore(start)) 
            {
                double dur = Math.ceil(duration/8);
                int duration1 = (int) dur;
                LocalDate end_date = start.plusDays(duration1); 
                String tp = "insert into task (id, name, createdBy, assignedTo, createdDate, duration, start, end, status, description) Values (?,?,?,?,?,?,?,?,?,?)"; 
                return conn.update(tp, id, name, createdBy, num, creatDate, duration, start, end_date, status, description);
            }
        }        
        return 0;
    }
}
