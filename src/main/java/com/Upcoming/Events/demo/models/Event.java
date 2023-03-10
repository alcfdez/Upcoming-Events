package com.Upcoming.Events.demo.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column 
    private long id;

    @Column (name = "title")
    private String title;

    @Column (name = "date_hour")
    private String date_hour;

    @Column (name = "max_participants")
    private int max_participants;

    @Column (name = "description")
    private String description;

    // @Column (name = "id_image")
    // private String id_image;

    @Column (name = "actual_participants")
    private int actual_participants;

    public Event() {
    }

    public Event(String title, String date_hour, int max_participants, String description,
            int actual_participants, Set<User> users) {
        this.title = title;
        this.date_hour = date_hour;
        this.max_participants = max_participants;
        this.description = description;
        // this.id_image = id_image;
        this.actual_participants = actual_participants;
        this.users = users;
    }

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

    public String getDate_hour() {
        return date_hour;
    }

    public void setDate_hour(String date_hour) {
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

    // public String getId_image() {
    //     return id_image;
    // }

    // public void setId_image(String id_image) {
    //     this.id_image = id_image;
    // }

    public int getActual_participants() {
        return actual_participants;
    }

    public void setActual_participants(int actual_participants) {
        this.actual_participants = actual_participants;
    }

    
}
