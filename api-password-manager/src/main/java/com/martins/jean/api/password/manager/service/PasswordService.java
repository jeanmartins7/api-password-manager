package com.martins.jean.api.password.manager.service;

import com.martins.jean.api.password.manager.interfaces.json.request.PasswordRequest;

public interface PasswordService {

    void postCreatePassword(PasswordRequest request);
}
