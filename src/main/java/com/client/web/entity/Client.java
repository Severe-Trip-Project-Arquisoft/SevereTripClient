package com.client.web.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "client")
@Data

public class Client{
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String clientId;

    @NotBlank
    @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters")
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters")
    private String secondName;

    @NotBlank
    private String localAirport;

    @NotBlank
    private String email;

    @NotBlank
    private  String address;

    @NotBlank
    private  String city;

    @NotBlank
    private  String stateProvinceRegion;

    @NotBlank
    private  String postalCode;

    @NotBlank
    private  String country;

    @NotBlank
    private  String cellphone;

    public Client(long id, @NotBlank String clientId, @NotBlank @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters") String firstName, @NotBlank @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters") String secondName, @NotBlank String localAirport, @NotBlank String email, @NotBlank String address, @NotBlank String city, @NotBlank String stateProvinceRegion, @NotBlank String postalCode, @NotBlank String country, @NotBlank String cellphone) {
        this.id = id;
        this.clientId = clientId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.localAirport = localAirport;
        this.email = email;
        this.address = address;
        this.city = city;
        this.stateProvinceRegion = stateProvinceRegion;
        this.postalCode = postalCode;
        this.country = country;
        this.cellphone = cellphone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLocalAirport() {
        return localAirport;
    }

    public void setLocalAirport(String localAirport) {
        this.localAirport = localAirport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvinceRegion() {
        return stateProvinceRegion;
    }

    public void setStateProvinceRegion(String stateProvinceRegion) {
        this.stateProvinceRegion = stateProvinceRegion;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
