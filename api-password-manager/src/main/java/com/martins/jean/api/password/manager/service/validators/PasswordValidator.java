package com.martins.jean.api.password.manager.service.validators;

import com.martins.jean.api.password.manager.service.validators.validation.constraint.Password;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator  implements ConstraintValidator<Password, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String password = value == null ? "" : value;

        return password.length() > 3 &&
                containsNumbers(password) &&
                containsUppercase(password) &&
                containsLowercase(password) &&
                hasUnderscoreCharacter(password) &&
                hasWhiteSpace(password);
    }

    private boolean containsNumbers(String password) {
        return password.matches(".*.\\d.*.");
    }

    private boolean containsLowercase(String password) {
        return password.matches(".*.[a-z].*.");
    }
    private boolean containsUppercase(String password) {
        return password.matches(".*.[A-Z].*.");
    }

    private boolean hasUnderscoreCharacter(String password) {
        return password.matches(".*.[!@#$%^&*()\\-+].*.");
    }

    private boolean hasRepeatCharacter(String password){
        return password.matches(" \\b(\\w+)\\s+\\1\\b ");
    }

    private boolean hasWhiteSpace(String password){
        return password.matches(".*.[\\S].*.");
    }

}
