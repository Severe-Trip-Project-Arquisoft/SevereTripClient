package com.user.web.entity;

import com.user.web.entity.auxiliar.ClientResponse;
import com.user.web.entity.auxiliar.UserResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;


@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "user")
public class Client extends User{

    @NotNull
    private String localAirport;
    @NotNull
    private  String stateProvinceRegion;
    @NotNull
    private  String postalCode;
    private HashSet<String> favorites;

    /*public Client(@NotNull @Size(min = 1, max = 30, message = "userName must be between 1 and 30 characters") String username, @NotNull @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters") String firstName, @NotEmpty @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters") String secondName, @Email @NotNull String email, @NotNull String address, @NotNull String city, @NotNull String country, @NotNull String cellphone, @NonNull String pass, @NotNull String rol, @NotNull String localAirport, @NotNull String stateProvinceRegion, @NotNull String postalCode, HashSet<String> favorites) {
        super(username, firstName, secondName, email, address, city, country, cellphone, pass, rol);
        this.localAirport = localAirport;
        this.stateProvinceRegion = stateProvinceRegion;
        this.postalCode = postalCode;
        this.favorites = favorites;
    }*/

    public Client(@NotNull @Size(min = 1, max = 30, message = "userName must be between 1 and 30 characters") String username, @NotNull @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters") String firstName, @NotEmpty @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters") String secondName, @Email @NotNull String email, @NotNull String address, @NotNull String city, @NotNull String country, @NotNull String cellphone, @NotNull String rol, @NonNull String password, @NotNull String localAirport, @NotNull String stateProvinceRegion, @NotNull String postalCode, HashSet<String> favorites) {
        super(username, firstName, secondName, email, address, city, country, cellphone, rol, password);
        this.localAirport = localAirport;
        this.stateProvinceRegion = stateProvinceRegion;
        this.postalCode = postalCode;
        this.favorites = favorites;
    }

    public boolean addFavorite(String postId) {
        return favorites.add(postId);
    }

    public boolean removeFavorite(String postId) {
        return favorites.remove(postId);
    }

    @Override
    public UserResponse response() {
        return new ClientResponse(this);
    }
}
