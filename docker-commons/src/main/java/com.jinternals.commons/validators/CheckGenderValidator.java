package com.jinternals.commons.validators;

import com.jinternals.commons.enums.Gender;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckGenderValidator implements ConstraintValidator<CheckGender, String> {

  @Override
  public void initialize(CheckGender constraintAnnotation) {
    // Need to be override
  }

  @Override
  public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
    if (object == null) {
      return true;
    }

    boolean isValid =
        object.equalsIgnoreCase(Gender.FEMALE.toString())
            || object.equalsIgnoreCase(Gender.MALE.toString());

    if (!isValid) {
      constraintContext.disableDefaultConstraintViolation();
      constraintContext.buildConstraintViolationWithTemplate(
          "{com.mds.eopd.commons.com.jinternals.commons.validators.CheckGender."
              + "constraintvalidatorcontext.CheckCase.message}").addConstraintViolation();
    }

    return isValid;
  }

}
