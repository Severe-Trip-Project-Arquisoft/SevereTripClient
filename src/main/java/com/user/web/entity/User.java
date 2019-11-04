package com.user.web.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;


@Data
@Document(collection = "user")
public abstract class User {

    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 30, message = "firstName must be between 1 and 30 characters")
    private String username;

    @NotNull
    @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters")
    private String firstName;

    @NotEmpty
    @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters")
    private String secondName;

    @Email
    @NotNull
    private String email;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String country;
    @NotNull
    private String cellphone;
    @NotNull
    private String rol;


}
