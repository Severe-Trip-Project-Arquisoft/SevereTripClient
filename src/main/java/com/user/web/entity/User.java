package com.user.web.entity;

import com.user.web.entity.auxiliar.UserResponse;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
@Document(collection = "user")
public abstract class User {

    abstract public UserResponse response();

    @Id private String id;
    @NotNull @Size(min = 1, max = 30, message = "userName must be between 1 and 30 characters") private String username;
    @NotNull @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters") private String firstName;
    @NotEmpty @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters") private String secondName;
    @Email @NotNull private String email;
    @NotNull private String address;
    @NotNull private String city;
    @NotNull private String country;
    @NotNull private String cellphone;
    @NotNull private String rol;
    @NonNull private int active;
    @NonNull private String password;
    private LocalDateTime creationTime;

    public User(@NotNull @Size(min = 1, max = 30, message = "userName must be between 1 and 30 characters") String username, @NotNull @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters") String firstName, @NotEmpty @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters") String secondName, @Email @NotNull String email, @NotNull String address, @NotNull String city, @NotNull String country, @NotNull String cellphone, @NotNull String rol) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.cellphone = cellphone;
        this.rol = rol;
        this.active = 1;
        this.creationTime = LocalDateTime.now();
    }

    public List<String> getRolList(){
        if(this.rol.length() > 0){
            return Arrays.asList(this.rol.split(","));
        }
        return new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getRol() {
        return rol;
    }

    public int getActive() {
        return active;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
