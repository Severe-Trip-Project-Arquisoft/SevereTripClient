package com.user.web.entity;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;



@Data
@TypeAlias("client")
@Document(collection = "user")
public class Client extends User{

    @NotNull
    private String localAirport;
    @NotNull
    private  String stateProvinceRegion;
    @NotNull
    private  String postalCode;


}
