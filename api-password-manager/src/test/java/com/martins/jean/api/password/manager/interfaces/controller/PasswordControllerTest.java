package com.martins.jean.api.password.manager.interfaces.controller;

import com.martins.jean.api.password.manager.interfaces.json.request.PasswordRequest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PasswordControllerTest {

    private PasswordRequest getRequestPasswordEmpty(){
        return PasswordRequest.builder()
                .password("")
                .build();
    }

}