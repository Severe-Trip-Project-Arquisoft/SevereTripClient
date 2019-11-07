package com.user.web.entity;

import com.user.web.entity.auxiliar.ProviderResponse;
import com.user.web.entity.auxiliar.UserResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "user")
public class Provider extends User{
    @Min(value = 0, message = "Years of experience must be greater than 0.")
    @NotNull private Double yearsExperience;
    @NotBlank private String bankAccount;

    public Provider(@NotNull @Size(min = 1, max = 30, message = "userName must be between 1 and 30 characters") String username, @NotNull @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters") String firstName, @NotEmpty @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters") String secondName, @Email @NotNull String email, @NotNull String address, @NotNull String city, @NotNull String country, @NotNull String cellphone, @NotNull String rol, @Min(value = 0, message = "Years of experience must be greater than 0.") @NotNull Double yearsExperience, @NotBlank String bankAccount) {
        super(username, firstName, secondName, email, address, city, country, cellphone, rol);
        this.yearsExperience = yearsExperience;
        this.bankAccount = bankAccount;
    }

    @Override
    public UserResponse response() {
        return new ProviderResponse(this);
    }
}
