package com.user.web.entity.auxiliar;

import lombok.Data;

@Data
public abstract class UserResponse {

    private String id;
    private String username;
    private String firstName;
    private String secondName;
    private String email;
    private String address;
    private String city;
    private String country;
    private String cellphone;
    private String rol;

    public UserResponse(String id, String username, String firstName, String secondName, String email, String address, String city, String country, String cellphone, String rol) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.cellphone = cellphone;
        this.rol = rol;
    }
}
