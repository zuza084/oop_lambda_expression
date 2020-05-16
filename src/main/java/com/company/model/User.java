package com.company.model;

import java.time.LocalDateTime;

// klasa modelu determinuje strukturę danych na zasadzie przepływu danych w projekcie
public class User {
    //skladowe statystyczne . zwiazane z klasa a nie z obiektem
    private static int idCounter = 1;
    private int userId;

    // prywatne pola klasowe ->
    private String name;
    private String lastName;
    private String email;
    private String password;

    private LocalDateTime registrationDate = LocalDateTime.now();
    private boolean status = true;
    //przypisanie uprawnień
    private Role role = Role.ROLE_USER;
// alt+insert
    public User() {
        this.userId = idCounter;
        idCounter++;
    }

    public User(String name, String lastName, String email, String password) {
        this.userId = idCounter;
        idCounter++;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    //metoda - napisowa reprezentacja obiektu

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", status=" + status +
                ", role=" + role +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }
}
