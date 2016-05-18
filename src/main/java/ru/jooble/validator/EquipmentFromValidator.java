package ru.jooble.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.jooble.domain.Equipment;
import ru.jooble.form.EquipmentForm;

@Component
public class EquipmentFromValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Equipment.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "valid.equipmentModel.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inventoryNumber", "valid.equipmentInventoryNumber.empty");
        EquipmentForm message = (EquipmentForm) target;
        try {
            Integer.parseInt(message.getInventoryNumber());
        } catch (Exception e) {
            errors.rejectValue("inventoryNumber", "valid.equipmentInventoryNumber.notNumber");
        }
    }
}

