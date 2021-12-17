package com.cocoa;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * // 客户导入
 * https://qccr.yuque.com/zuiniubi/ierp/nhi0gz
 */

public class ExcelDataOldCustomer {


    static final String IMPORT_TYPE = "OLDCUSTOMER";

    static final String[] EXCEL_TEML_HEADER_NAMES = {"手机号", "客户名称", "性别", "地址", "服务顾问", "车牌号", "车架号", "发动机号", "注册日期",
            "商业险投保公司", "商业险到期日期", "交强险投保公司", "交强险到期日期", "车主", "车主证件号", "车险管家"};

    @ExcelProperty(value = "手机号", index = 0)
    private String clientPhone;

    @ExcelProperty(value = "客户名称", index = 1)
    private String clientName;

    //0女  1男  2无
    @ExcelProperty(value = "性别", index = 2)
    private String gender;

    @ExcelProperty(value = "地址", index = 3)
    private String address;

    @ExcelProperty(value = "服务顾问", index = 4)
    private String sa;

    @ExcelProperty(value = "车牌号", index = 5)
    private String plateNumber;

    @ExcelProperty(value = "车架号", index = 6)
    private String vcode;

    @ExcelProperty(value = "发动机号", index = 7)
    private String ecode;

    // java.util.Date
//    @DateTimeFormat("yyyy/MM/dd")
    @ExcelProperty(value = "注册日期", index = 8 )
    private String registerTime;

    @ExcelProperty(value = "商业险投保公司", index = 9)
    private String vehicleInsurance;

    // java.util.Date 类型
//    @DateTimeFormat("yyyy/MM/dd")
    @ExcelProperty(value = "商业险到期日期", index = 10)
    private String vehicleInsuranceTime;

    @ExcelProperty(value = "交强险投保公司", index = 11)
    private String compulsoryInsurance;

    // java.util.Date 类型
//    @DateTimeFormat("yyyy/MM/dd")
    @ExcelProperty(value = "交强险到期日期", index = 12)
    private String compulsoryInsuranceTime;

    @ExcelProperty(value = "车主", index = 13)
    private String ownerName;

    //xxxx
    @ExcelProperty(value = "车主证件号", index = 14)
    private String ownerNumber;

    @ExcelProperty(value = "车险管家", index = 15)
    private String insuranceManager;

    @ExcelProperty(value = "操作结果", index = 16)
    private String optResult;


    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getVehicleInsurance() {
        return vehicleInsurance;
    }

    public void setVehicleInsurance(String vehicleInsurance) {
        this.vehicleInsurance = vehicleInsurance;
    }

    public String getVehicleInsuranceTime() {
        return vehicleInsuranceTime;
    }

    public void setVehicleInsuranceTime(String vehicleInsuranceTime) {
        this.vehicleInsuranceTime = vehicleInsuranceTime;
    }

    public String getCompulsoryInsurance() {
        return compulsoryInsurance;
    }

    public void setCompulsoryInsurance(String compulsoryInsurance) {
        this.compulsoryInsurance = compulsoryInsurance;
    }

    public String getCompulsoryInsuranceTime() {
        return compulsoryInsuranceTime;
    }

    public void setCompulsoryInsuranceTime(String compulsoryInsuranceTime) {
        this.compulsoryInsuranceTime = compulsoryInsuranceTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public String getInsuranceManager() {
        return insuranceManager;
    }

    public void setInsuranceManager(String insuranceManager) {
        this.insuranceManager = insuranceManager;
    }

    public String getOptResult() {
        return optResult;
    }

    public void setOptResult(String optResult) {
        this.optResult = optResult;
    }
}
