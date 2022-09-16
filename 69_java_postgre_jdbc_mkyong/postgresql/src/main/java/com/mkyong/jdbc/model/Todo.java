package com.mkyong.jdbc.model;

import java.time.LocalTime;

public class Todo {

    private Long id;
    private String assign_to;
    private String description;
    private LocalTime time_stamp;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssign_to() {
        return assign_to;
    }

    public void setAssign_to(String assign_to) {
        this.assign_to = assign_to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(LocalTime time_stamp) {
        this.time_stamp = LocalTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
