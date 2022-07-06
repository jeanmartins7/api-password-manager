package com.martins.jean.api.password.manager.interfaces.controller;

import com.martins.jean.api.password.manager.interfaces.json.request.PasswordRequest;
import com.martins.jean.api.password.manager.service.PasswordService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {

    private PasswordService passwordService;

    @PostMapping("/")
    public ResponseEntity<Void> postDynamicTokenSuspensions(
            @RequestBody @Validated PasswordRequest request) {

        this.passwordService.postCreatePassword(request);

        return ResponseEntity
                .noContent()
                .build();
    }
}
