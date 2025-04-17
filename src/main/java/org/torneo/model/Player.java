package org.torneo.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String dni;
    private String name;
    private String lName1;
    private String lName2;
    private String email;
    private String phone;
    private String teamName;
    private LocalDate dateOfBirth;
    private String userName;

    public Player() {
    }

    public Player(String dni, String name, String lName1, String lName2, String email, String phone, String teamName, LocalDate dateOfBirth, String userName) {
        this.dni = dni;
        this.name = name;
        this.lName1 = lName1;
        this.lName2 = lName2;
        this.email = email;
        this.phone = phone;
        this.teamName = teamName;
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
        Player player = (Player) o;
        return Objects.equals(dni, player.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lName1='" + lName1 + '\'' +
                ", lName2='" + lName2 + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", teamId='" + teamName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", userName='" + userName + '\'' +
                '}';
    }
}
