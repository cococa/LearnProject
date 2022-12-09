package com.cocoa.dangan;


import lombok.Data;

import java.io.Serializable;

public class Words implements Serializable {

    private String words;

    public Words(String words) {
        this.words = words;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
