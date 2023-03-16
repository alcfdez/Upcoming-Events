package com.Upcoming.Events.demo.models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date_hour")
    private Date date_hour;

    @Column(name = "max_participants")
    private int max_participants;

    @Column(name = "description")
    private String description;

    @Column(name = "style")
    private String style;

    @Column(name = "actual_participants")
    private int actual_participants;

    public Event() {
    }

    // // public long getId() {
    // //     return id;
    // // }

    // public Event(long id, String title, Date date_hour, int max_participants, String description, String style,
    //         int actual_participants) {
    //     this.id = id;
    public Event(String title, Date date_hour, int max_participants, String description,
            int actual_participants, Set<User> users, String style) {
        this.title = title;
        this.date_hour = date_hour;
        this.max_participants = max_participants;
        this.description = description;
        this.actual_participants = actual_participants;
        this.style = style;
        this.users = users;
    }

    public Event(String string, String string2, int i, String string3, int j, Object object) {
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    Set<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate_hour() {
        return date_hour;
    }

    public void setDate_hour(Date date_hour) {
        this.date_hour = date_hour;
    }

    public int getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(int max_participants) {
        this.max_participants = max_participants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getActual_participants() {
        return actual_participants;
    }

    public void setActual_participants(int actual_participants) {
        this.actual_participants = actual_participants;
    }

}
