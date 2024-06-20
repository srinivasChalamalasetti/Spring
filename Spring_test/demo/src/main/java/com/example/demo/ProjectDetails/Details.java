package com.example.demo.ProjectDetails;

import java.time.LocalDate;

public class Details {
    
    private String ename; 
    private String pname; 
    private LocalDate passignedDate; 
    private int elead; 
    private int assignedBy;

    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public LocalDate getPassignedDate() {
        return passignedDate;
    }
    public void setPassignedDate(LocalDate passignedDate) {
        this.passignedDate = passignedDate;
    }
    public int getElead() {
        return elead;
    }
    public void setElead(int elead) {
        this.elead = elead;
    }
    public int getAssignedBy() {
        return assignedBy;
    }
    public void setAssignedBy(int assignedBy) {
        this.assignedBy = assignedBy;
    }
    
}
