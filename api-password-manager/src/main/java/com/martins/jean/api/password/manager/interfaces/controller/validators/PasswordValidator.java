package com.martins.jean.api.password.manager.interfaces.controller.validators;

import com.martins.jean.api.password.manager.interfaces.controller.validators.validation.constraint.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String password = value == null ? "" : value;

        return password.length() > 3 &&
                containsNumbers(password) &&
                containsUppercase(password) &&
                containsLowercase(password) &&
                hasWhiteSpace(password) &&
                hasRepeatCharacter(password) &&
                hasUnderscoreCharacter(password);
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
        //return password.matches(".*.[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+].*.");
        return password.matches(
                "(?=.*[}{,.^?~=+\\-!\\-@\\-#\\-$\\-%\\-&\\-)(\\/*\\-\\-/\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{9,}");
    }

    private boolean hasRepeatCharacter(String password) {
        for (int i = 0; i < password.length(); i++) {
            for (int j = i + 1; j < password.length(); j++) {
                if (password.charAt(i) == password.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasWhiteSpace(String password) {
        return !password.matches(".*.[\\s].*.");
    }

}
