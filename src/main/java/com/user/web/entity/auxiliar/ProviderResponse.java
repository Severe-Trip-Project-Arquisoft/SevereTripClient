package com.user.web.entity.auxiliar;

import com.user.web.entity.Provider;
import lombok.Data;

@Data

public class ProviderResponse extends UserResponse {


    private Double yearsExperience;
    private String bankAccount;

    public ProviderResponse(Provider provider) {
        super(provider.getId(),
        provider.getUsername(),
        provider.getFirstName(),
        provider.getSecondName(),
        provider.getEmail(),
        provider.getAddress(),
        provider.getCity(),
        provider.getCountry(),
        provider.getCellphone(),
        provider.getRol());
        this.yearsExperience = provider.getYearsExperience();
        this.bankAccount = provider.getBankAccount();
    }
}
