package com.martins.jean.api.password.manager.interfaces.json.request;

import com.martins.jean.api.password.manager.service.validators.validation.constraint.Password;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PasswordRequest {

    @NotBlank
    @Password
    String password;

}
