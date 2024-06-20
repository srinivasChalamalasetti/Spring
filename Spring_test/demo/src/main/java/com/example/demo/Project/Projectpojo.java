package com.example.demo.Project;

import java.time.LocalDate;

public class Projectpojo {
    private int id;
    private String name; 
    private String client; 
    private int assignedBy; 
    private LocalDate start;
    private LocalDate end; 
    private int duration;
    private int hr;
    private int pm;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public int getAssignedBy() {
        return assignedBy;
    }
    public void setAssignedBy(int assignedBy) {
        this.assignedBy = assignedBy;
    }
    public LocalDate getStart() {
        return start;
    }
    public void setStart(LocalDate start) {
        this.start = start;
    }
    public LocalDate getEnd() {
        return end;
    }
    public void setEnd(LocalDate end) {
        this.end = end;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getHr() {
        return hr;
    }
    public void setHr(int hr) {
        this.hr = hr;
    }
    public int getPm() {
        return pm;
    }
    public void setPm(int pm) {
        this.pm = pm;
    } 
}
