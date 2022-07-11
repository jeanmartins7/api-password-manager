package com.martins.jean.api.password.manager.interfaces.controller;

import com.martins.jean.api.password.manager.interfaces.json.request.PasswordRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/password-manager")
public class PasswordController {

    @PostMapping("/verify")
    public ResponseEntity<Boolean> postVerifyPassword(@RequestBody @Valid PasswordRequest request) {

        return ResponseEntity.ok(true);
    }
}
