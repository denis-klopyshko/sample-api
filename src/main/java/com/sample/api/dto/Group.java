package com.sample.api.dto;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id @Column Long id;
    private @Column String name;
    private @Column int rating;

    @ManyToMany(mappedBy = "userGroups", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Group() {
    }

    public Group(String name, int rating, Set<User> users) {
        this.name = name;
        this.rating = rating;
        this.users = users;
    }
}
