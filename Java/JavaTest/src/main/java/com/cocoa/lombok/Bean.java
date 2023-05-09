package com.cocoa.lombok;


import lombok.Data;

import java.io.Serializable;


@Data
public class Bean implements Serializable {
    private static final long serialVersionUID = 1008485589889837571L;
    private String name;
    private Integer age;
    private String address;


}
