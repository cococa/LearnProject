package com.cocoa.validation;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(123);
        check(p);
    }

    public static void check(BaseClass p) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<BaseClass>> violations = validator.validate(p);

        for (ConstraintViolation violation : violations) {
            System.out.println(violation.getMessage());
        }
    }

}
