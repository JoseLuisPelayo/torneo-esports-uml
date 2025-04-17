package org.torneo.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String lName1;
    private String lName2;
    private String email;
    private String phone;
    private String teamId;
    private LocalDate dateOfBirth;
    private String userName;

    public User() {
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

    public String getLName1() {
        return lName1;
    }

    public void setLName1(String lName1) {
        this.lName1 = lName1;
    }

    public String getLName2() {
        return lName2;
    }

    public void setLName2(String lName2) {
        this.lName2 = lName2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lName1='" + lName1 + '\'' +
                ", lName2='" + lName2 + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", teamId='" + teamId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", userName='" + userName + '\'' +
                '}';
    }
}
