package com.jinternals.commons.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = com.jinternals.commons.validators.CheckGenderValidator.class)
@Documented
public @interface CheckGender {

  String message() default "{com.mds.eopd.commons.com.jinternals.commons.validators.CheckGender." + "message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
