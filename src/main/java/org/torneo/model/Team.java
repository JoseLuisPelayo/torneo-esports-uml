package org.torneo.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Team implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private User manager;
    private List<User> members;
    private LocalDate creationDate;

    public Team() {
    }

    public Team(String id, String name, User manager, List<User> members, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.members = members;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                ", members=" + members +
                ", creationDate=" + creationDate +
                '}';
    }
}
