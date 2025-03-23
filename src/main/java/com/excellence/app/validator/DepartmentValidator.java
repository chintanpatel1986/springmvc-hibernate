package com.excellence.app.validator;

import com.excellence.app.model.Department;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DepartmentValidator implements ConstraintValidator<ValidDepartment, Department> {

    @Override
    public boolean isValid(Department department, ConstraintValidatorContext constraintValidatorContext) {
        return department != null && department.getDepartmentId() > 0;
    }
}
