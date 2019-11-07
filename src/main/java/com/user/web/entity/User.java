package com.user.web.entity;

import com.user.web.entity.auxiliar.UserResponse;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.time.LocalDateTime;


@Data
@Document(collection = "user")
public abstract class User {

    abstract public UserResponse response();

    @Id private String id;
    @NotNull private String password;
    @NotNull @Size(min = 1, max = 30, message = "userName must be between 1 and 30 characters") private String username;
    @NotNull @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters") private String firstName;
    @NotEmpty @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters") private String secondName;
    @Email @NotNull private String email;
    @NotNull private String address;
    @NotNull private String city;
    @NotNull private String country;
    @NotNull private String cellphone;
    @NotNull private String role;
    private LocalDateTime creationTime;


    public User(@NotNull @Size(min = 1, max = 30, message = "userName must be between 1 and 30 characters") String username, @NotNull @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters") String firstName, @NotEmpty @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters") String secondName, @Email @NotNull String email, @NotNull String address, @NotNull String city, @NotNull String country, @NotNull String cellphone, @NotNull String role) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.cellphone = cellphone;
        this.role = role;
        this.creationTime = LocalDateTime.now();
    }
}
