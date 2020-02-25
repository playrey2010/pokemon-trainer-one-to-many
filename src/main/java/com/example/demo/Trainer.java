package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Pokemon> team;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(Set<Pokemon> team) {
        this.team = team;
    }
}
