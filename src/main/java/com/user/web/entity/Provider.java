package com.user.web.entity;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@TypeAlias("provider")
@Document(collection = "user")
public class Provider extends User{


    @NotNull
    @DecimalMin(value = "0.0", message = "yearsExperience must be greater than 0")
    private Double yearsExperience;
    @NotBlank
    private String bankAccount;


}
