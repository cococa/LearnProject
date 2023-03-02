package com.cocoa;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * uk_common_period_ly
 * @author 
 */
@Data
public class UkCommonPeriodLyDo implements Serializable {
    private static final long serialVersionUID = -2099032737444190710L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 力洋ID
     */
    @JSONField(name="LevelId")
    private String lyId;

    /**
     * 机油里程
     * ly=小保养机油间隔里程(公里)
     */
    @JSONField(name="EngineOilChangeIntervalsKm")
    private String oilApartMile;

    /**
     * 机油公里
     * ly=小保养机油间隔时间(个月)
     */
    @JSONField(name="EngineOilChangeIntervalsMonth")
    private String oilApartTime;


    /**
     * 机油滤清器里程
     * ly=小保养机油滤清间隔里程(公里)
     */
    @JSONField(name="OilFilterReplaceIntervalsKm")
    private String oilFilterApartMile;

    /**
     * 机油滤清器公里
     * ly= 小保养机油滤清间隔时间(个月)
     */
    @JSONField(name="OilFilterReplaceIntervalsMonth")
    private String oilFilterApartTime;

    /**
     * 空气滤清器里程
     * ly= 空气滤清器间隔里程(公里)
     */
    @JSONField(name="AirCleanerElementReplaceIntervalsKm")
    private String airApartMile;

    /**
     * 空气滤清器公里
     * ly= 空气滤清器间隔时间(个月)
     */
    @JSONField(name="AirCleanerElementReplaceIntervalsMonth")
    private String airApartTime;


    /**
     * 燃油滤清器里程
     * ly= 燃油滤清器间隔里程(公里)
     */
    @JSONField(name="FuelFilterReplaceIntervalsKm")
    private String fuelApartMile;

    /**
     * 燃油滤清器公里
     * ly= 燃油滤清器间隔时间(个月)
     */
    @JSONField(name="FuelFilterReplaceIntervalsMonth")
    private String fuelApartTime;

    /**
     * 火花塞里程
     * ly = 全部火花塞间隔里程(公里)
     */
    @JSONField(name="SparkPlugsReplaceIntervalsKm")
    private String sparkingApartMile;

    /**
     * 火花塞公里
     * ly= 全部火花塞间隔时间(个月)
     */
    @JSONField(name="SparkPlugsReplaceIntervalsMonth")
    private String sparkingApartTime;

    /**
     * 空调滤清器里程
     * ly= 空调滤清器间隔里程(公里)
     */
    @JSONField(name="PollenFilterReplaceIntervalsKm")
    private String airConditionApartMile;

    /**
     * 空调滤清器公里
     * ly= 空调滤清器间隔时间(个月)
     */
    @JSONField(name="PollenFilterReplaceIntervalsMonth")
    private String airConditionApartTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createPerson;

    /**
     * 更新人
     */
    private String updatePerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLyId() {
        return lyId;
    }

    public void setLyId(String lyId) {
        this.lyId = lyId;
    }

    public String getOilApartMile() {
        return oilApartMile;
    }

    public void setOilApartMile(String oilApartMile) {
        this.oilApartMile = oilApartMile;
    }

    public String getOilApartTime() {
        return oilApartTime;
    }

    public void setOilApartTime(String oilApartTime) {
        this.oilApartTime = oilApartTime;
    }

    public String getOilFilterApartMile() {
        return oilFilterApartMile;
    }

    public void setOilFilterApartMile(String oilFilterApartMile) {
        this.oilFilterApartMile = oilFilterApartMile;
    }

    public String getOilFilterApartTime() {
        return oilFilterApartTime;
    }

    public void setOilFilterApartTime(String oilFilterApartTime) {
        this.oilFilterApartTime = oilFilterApartTime;
    }

    public String getAirApartMile() {
        return airApartMile;
    }

    public void setAirApartMile(String airApartMile) {
        this.airApartMile = airApartMile;
    }

    public String getAirApartTime() {
        return airApartTime;
    }

    public void setAirApartTime(String airApartTime) {
        this.airApartTime = airApartTime;
    }

    public String getFuelApartMile() {
        return fuelApartMile;
    }

    public void setFuelApartMile(String fuelApartMile) {
        this.fuelApartMile = fuelApartMile;
    }

    public String getFuelApartTime() {
        return fuelApartTime;
    }

    public void setFuelApartTime(String fuelApartTime) {
        this.fuelApartTime = fuelApartTime;
    }

    public String getSparkingApartMile() {
        return sparkingApartMile;
    }

    public void setSparkingApartMile(String sparkingApartMile) {
        this.sparkingApartMile = sparkingApartMile;
    }

    public String getSparkingApartTime() {
        return sparkingApartTime;
    }

    public void setSparkingApartTime(String sparkingApartTime) {
        this.sparkingApartTime = sparkingApartTime;
    }

    public String getAirConditionApartMile() {
        return airConditionApartMile;
    }

    public void setAirConditionApartMile(String airConditionApartMile) {
        this.airConditionApartMile = airConditionApartMile;
    }

    public String getAirConditionApartTime() {
        return airConditionApartTime;
    }

    public void setAirConditionApartTime(String airConditionApartTime) {
        this.airConditionApartTime = airConditionApartTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    @Override
    public String toString() {
        return "UkCommonPeriodLyDo{" +
                "id=" + id +
                ", lyId='" + lyId + '\'' +
                ", oilApartMile='" + oilApartMile + '\'' +
                ", oilApartTime='" + oilApartTime + '\'' +
                ", oilFilterApartMile='" + oilFilterApartMile + '\'' +
                ", oilFilterApartTime='" + oilFilterApartTime + '\'' +
                ", airApartMile='" + airApartMile + '\'' +
                ", airApartTime='" + airApartTime + '\'' +
                ", fuelApartMile='" + fuelApartMile + '\'' +
                ", fuelApartTime='" + fuelApartTime + '\'' +
                ", sparkingApartMile='" + sparkingApartMile + '\'' +
                ", sparkingApartTime='" + sparkingApartTime + '\'' +
                ", airConditionApartMile='" + airConditionApartMile + '\'' +
                ", airConditionApartTime='" + airConditionApartTime + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createPerson='" + createPerson + '\'' +
                ", updatePerson='" + updatePerson + '\'' +
                '}';
    }
}



//        完整json 数据
//        中英文对照  http://serviceadmin.vin114.net/tools/FieldMap.html

//{
//        "EngineOilChangeAtTheFirstMaintanceKm": "12000",
//        "EngineOilChangeAtTheFirstMaintanceMonth": "6",
//        "EngineOilChangeAtTheSecondMaintanceKm": "24000",
//        "EngineOilChangeAtTheSecondMaintanceMonth": "12",
//        "EngineOilChangeIntervalsKm": "12000",
//        "EngineOilChangeIntervalsMonth": "6",
//        "OilFilterReplaceAtTheFirstMaintanceKm": "12000",
//        "OilFilterReplaceAtTheFirstMaintanceMonth": "6",
//        "OilFilterReplaceIntervalsKm": "12000",
//        "OilFilterReplaceIntervalsMonth": "6",
//        "AirCleanerElementReplaceAtTheFirstMaintanceKm": "48000",
//        "AirCleanerElementReplaceAtTheFirstMaintanceMonth": "24",
//        "AirCleanerElementReplaceIntervalsKm": "48000",
//        "AirCleanerElementReplaceIntervalsMonth": "24",
//        "SparkPlugsReplaceAtTheFirstMaintanceKm": "156000",
//        "SparkPlugsReplaceAtTheFirstMaintanceMonth": "78",
//        "SparkPlugsReplaceIntervalsKm": "156000",
//        "SparkPlugsReplaceIntervalsMonth": "78",
//        "PollenFilterReplaceAtTheFirstMaintanceKm": "24000",
//        "PollenFilterReplaceAtTheFirstMaintanceMonth": "12",
//        "PollenFilterReplaceIntervalsKm": "24000",
//        "PollenFilterReplaceIntervalsMonth": "12",
//        "FrontPadsReplaceAtTheFirstMaintanceKm": "检查厚度及磨损情况，必要时更换",
//        "FrontPadsReplaceAtTheFirstMaintanceMonth": "检查厚度及磨损情况，必要时更换",
//        "FrontPadsReplaceIntervalsKm": "检查厚度及磨损情况，必要时更换",
//        "FrontPadsReplaceIntervalsMonth": "检查厚度及磨损情况，必要时更换",
//        "FrontDiscsReplaceAtTheFirstMaintanceKm": "检查厚度及磨损情况，必要时更换",
//        "FrontDiscsReplaceAtTheFirstMaintanceMonth": "检查厚度及磨损情况，必要时更换",
//        "FrontDiscsReplaceIntervalsKm": "检查厚度及磨损情况，必要时更换",
//        "FrontDiscsReplaceIntervalsMonth": "检查厚度及磨损情况，必要时更换",
//        "RearPadsShoesReplaceAtTheFirstMaintanceKm": "检查厚度及磨损情况，必要时更换",
//        "RearPadsShoesReplaceAtTheFirstMaintanceMonth": "检查厚度及磨损情况，必要时更换",
//        "RearPadsShoesReplaceIntervalsKm": "检查厚度及磨损情况，必要时更换",
//        "RearPadsShoesReplaceIntervalsMonth": "检查厚度及磨损情况，必要时更换",
//        "RearDiscsDrumsReplaceAtTheFirstMaintanceKm": "检查厚度及磨损情况，必要时更换",
//        "RearDiscsDrumsReplaceAtTheFirstMaintanceMonth": "检查厚度及磨损情况，必要时更换",
//        "RearDiscsDrumsReplaceIntervalsKm": "检查厚度及磨损情况，必要时更换",
//        "RearDiscsDrumsReplaceIntervalsMonth": "检查厚度及磨损情况，必要时更换",
//        "LevelId": "ACC0133A0003",
//        "IsForeign": "1",
//        "IsCommercial": "0"
//        }