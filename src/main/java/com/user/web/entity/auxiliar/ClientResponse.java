package com.user.web.entity.auxiliar;

import com.user.web.entity.Client;
import lombok.Data;

@Data
public class ClientResponse extends UserResponse {


    private String localAirport;
    private  String stateProvinceRegion;
    private  String postalCode;

    public ClientResponse(Client client) {
        super(client.getId(),
                client.getUsername(),
                client.getFirstName(),
                client.getSecondName(),
                client.getEmail(),
                client.getAddress(),
                client.getCity(),
                client.getCountry(),
                client.getCellphone(),
                client.getRol());
        this.localAirport = client.getLocalAirport();
        this.stateProvinceRegion = client.getStateProvinceRegion();
        this.postalCode = client.getPostalCode();
    }

}