package com.martins.jean.api.password.manager.service.imp;

import com.martins.jean.api.password.manager.interfaces.json.request.PasswordRequest;
import com.martins.jean.api.password.manager.service.PasswordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Slf4j
public class PasswordServiceImpl implements PasswordService {

    public void postCreatePassword(PasswordRequest request) {

        String password = request.getPassword();
    }
}
