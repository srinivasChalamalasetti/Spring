package com.example.demo.ProjectDetails;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {
    
    @Autowired 
    JdbcTemplate conn; 

    public int addEmployee(Details p)
    {
        String ename = p.getEname(); 
        System.out.println(ename);
        String pname = p.getPname(); 
        LocalDate passignedDate = p.getPassignedDate(); 
        int elead = p.getElead(); 
        int assignedBy = p.getAssignedBy(); 
        
        String a = "select EmpId from employee where FirstName = \""+ename+"\""; 
        int a1 = conn.queryForObject(a,Integer.class); 

        String b = "select id from Project where name = \""+pname+"\""; 
        int b1 = conn.queryForObject(b,Integer.class); 
        
        String c = "select Rname from Roles where Rid = (select Rid from employee where EmpId = \""+assignedBy+"\")"; 
        String sm = conn.queryForObject(c,String.class); 
        
        if("HR".equals(sm) || "Project_Manager".equals(sm))
        {            
            String ld = "select Rname from Roles where Rid in (select Rid from employee where EmpId = ?)"; 
            List<Map<String,Object>> t = conn.queryForList(ld,elead); 
            Object tp = t.get(0).get("Rname"); 
            String na = (String) tp; 
            if("Lead".equals(na))
            {
                String ss = "select start from Project where id = ?"; 
                List<Map<String,Object>> set = conn.queryForList(ss,b1); 
                Object op = set.get(0).get("start"); 
                java.sql.Date sqlDate = (java.sql.Date) op;
                LocalDate ProjectD = sqlDate.toLocalDate();

                if(passignedDate.compareTo(ProjectD) > 0)
                {
                    String result = "insert into projectDetails (eid, pid, passignedDate, elead, assignedBy) Values (?,?,?,?,?)";
                    return conn.update(result, a1, b1, passignedDate, elead, assignedBy);
                }
            }
        }
        return 0;
    }
}

