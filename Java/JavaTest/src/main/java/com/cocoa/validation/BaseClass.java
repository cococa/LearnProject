package com.cocoa.validation;

import javax.validation.constraints.NotBlank;

public class BaseClass {

    @NotBlank(message = "xx is null!")
    private String xx;

}
