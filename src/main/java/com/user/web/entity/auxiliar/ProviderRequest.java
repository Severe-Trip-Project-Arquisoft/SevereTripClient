package com.user.web.entity.auxiliar;

import com.user.web.entity.Provider;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
public class ProviderRequest {
    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Size(min = 1, max = 30, message = "Username must be between 1 and 30 characters")
    @NotNull private String username;
    @Size(min = 1, max = 128, message = "First name must be between 1 and 128 characters")
    @NotNull private String firstName;
    @Size(min = 1, max = 128, message = "Second name must be between 1 and 128 characters")
    @NotEmpty private String secondName;
    @Email
    @NotNull private String email;
    @NotNull private String address;
    @NotNull private String city;
    @NotNull private String country;
    @NotNull private String cellphone;
    @Min(value = 0, message = "Years of experience must be greater than 0")
    @NotNull private Double yearsExperience;
    @NotBlank private String bankAccount;
    @NotNull  private String password;


    public Provider createProvider(ProviderRequest this) {
        return new Provider(
                username,
                firstName,
                secondName,
                email,
                address,
                city,
                country,
                cellphone,
                "PROVIDER",
                passwordEncoder.encode(password),
                yearsExperience,
                bankAccount
            );

    }
}
