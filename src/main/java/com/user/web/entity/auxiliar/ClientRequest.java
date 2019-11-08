package com.user.web.entity.auxiliar;

import com.user.web.entity.Client;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;

@Data
public class ClientRequest {

    @Size(min = 1, max = 30, message = "Username must be between 1 and 30 characters")
    @NotNull private String username;
    @Size(min = 1, max = 128, message = "First name must be between 1 and 128 characters")
    @NotNull private String firstName;
    @Size(min = 1, max = 128, message = "Second name must be between 1 and 128 characters")
    @NotEmpty private String secondName;
    @Email @NotNull private String email;
    @NotNull private String address;
    @NotNull private String city;
    @NotNull private String country;
    @NotNull private String cellphone;
    @NotNull private String localAirport;
    @NotNull private String stateProvinceRegion;
    @NotNull private String postalCode;
    @NonNull private String password;
    public Client createClient() {
        return new Client(
            this.getUsername(),
            this.getFirstName(), this.getSecondName(), this.getEmail(), this.getAddress(), this.getCity(), this.getCountry(), this.getCellphone(), this.getPassword(), "client",
            this.getLocalAirport(),
            this.getStateProvinceRegion(),
            this.getPostalCode(),
            new HashSet<>());
    }
}
