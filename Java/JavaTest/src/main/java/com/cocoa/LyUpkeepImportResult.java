package com.cocoa;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * liyang 保养周期导入数据，因为数据量大（25w+），所以直接使用UkCommonPeriodLyDo ，防止对象转换影响性能
 */
@Data
public class LyUpkeepImportResult {

    @JSONField(name = "Result")
    private List<UkCommonPeriodLyDo> result;

    @JSONField(name = "Info")
    private LyUpkeepImportInfo info;

    public List<UkCommonPeriodLyDo> getResult() {
        return result;
    }

    public void setResult(List<UkCommonPeriodLyDo> result) {
        this.result = result;
    }

    public LyUpkeepImportInfo getInfo() {
        return info;
    }

    public void setInfo(LyUpkeepImportInfo info) {
        this.info = info;
    }
}
