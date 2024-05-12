package com.example.SpringValidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidationCodeConstraintValidator implements ConstraintValidator<ValidationCode,String> {

    private String maSoSinhVien;

    private String hoTen;

    @Override
    public void initialize(ValidationCode constraintAnnotation) {
        maSoSinhVien=constraintAnnotation.value();
        hoTen=constraintAnnotation.value();
    }


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(s!=null){
            result =s.startsWith(maSoSinhVien) && s.startsWith(hoTen);
        }else{
            result =true;
        }
        return result;
    }
}
