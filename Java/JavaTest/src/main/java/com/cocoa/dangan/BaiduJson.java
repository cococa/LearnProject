package com.cocoa.dangan;


import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;


public class BaiduJson implements Serializable {

    @JSONField(name = "words_result")
    private Map<String, Words> wordsResult;

    public Map<String, Words> getWordsResult() {
        return wordsResult;
    }

    public void setWordsResult(Map<String, Words> wordsResult) {
        this.wordsResult = wordsResult;
    }
}
