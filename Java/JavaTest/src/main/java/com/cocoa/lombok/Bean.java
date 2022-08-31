package com.cocoa.lombok;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
public class Bean implements Serializable {
    private static final long serialVersionUID = 1008485589889837571L;
    private String name;
    private Integer age;
    private String address;


}
