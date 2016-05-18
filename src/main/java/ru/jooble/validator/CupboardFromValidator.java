package ru.jooble.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.jooble.domain.Cupboard;

@Component
public class CupboardFromValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Cupboard.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.cupboardName.empty");
    }
}