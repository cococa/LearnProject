package com.cocoa;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;


@Data
public class LyUpkeepImportInfo {
    /**
     * 成功
     */
    @JSONField(name = "Success")
    private Boolean success;
    /**
     * 总条数
     */
    @JSONField(name = "Total")
    private Long total;

    /**
     * 下一页的index
     */
    @JSONField(name = "SdmPageIndex")
    private String sdmPageIndex;
//        private int Records;
//        private String Power;
//        private String Details;
//        private int code;
//    private String Desc;
//    private String Error;
//        private Date start;
//        private Date end;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getSdmPageIndex() {
        return sdmPageIndex;
    }

    public void setSdmPageIndex(String sdmPageIndex) {
        this.sdmPageIndex = sdmPageIndex;
    }

    @Override
    public String toString() {
        return "LyUpkeepImportInfo{" +
                "success=" + success +
                ", total=" + total +
                ", sdmPageIndex='" + sdmPageIndex + '\'' +
                '}';
    }
}
