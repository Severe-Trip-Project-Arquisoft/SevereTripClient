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
    @NonNull private boolean active;
    @NonNull private String pass;
    private LocalDateTime creationTime;

    public User(@NotNull @Size(min = 1, max = 30, message = "userName must be between 1 and 30 characters") String username, @NotNull @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters") String firstName, @NotEmpty @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters") String secondName, @Email @NotNull String email, @NotNull String address, @NotNull String city, @NotNull String country, @NotNull String cellphone, @NotNull String rol, @NonNull String pass) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.cellphone = cellphone;
        this.rol = rol;
        this.active = false;
        this.pass = pass;
        this.creationTime = LocalDateTime.now();
    }

    public List<String> getRolList(){
        if(this.rol.length() > 0){
            return Arrays.asList(this.rol.split(","));
        }
        return new ArrayList<>();
    }
}
