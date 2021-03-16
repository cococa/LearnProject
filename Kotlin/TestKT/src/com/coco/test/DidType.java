package com.coco.test;



public enum DidType {

    // 命令数据标识编码表
    注册请求("C001" , true, true,  ""),
    通信结束("C002" , false, true, ""),
    上传数据("C003" , true, false, ""),
    设置底数("C021" , false, true, "m^3"),
    阀门控制("C022" , false, true, ""),
    密钥更新("C023" , false, true, ""),
    月冻结数据记录("C031" , true, false, ""),  // MonthFrozenAction
    日冻结数据记录("C032" , true, false, ""),
    定时冻结数据记录("C033" , true, false, ""), //  FixedFrozenAction
    数据透传("C0F0" , true, true, ""),  //暂时写了 有个实现类 没具体的协议文档 没法做

    // 水量数据标识编码表
    累计流量("9010" , true, false, "m^3"),
    正向累计流量("9011" , true, false, "m^3"),
    反向累计流量("9012" , true, false, "m^3"),
    水量数据块("90FF" , true, false, "m^3"),

    // 变量数据标识编码表
    瞬时流量("1000" , true, false, "m^3/h"),
    传感器信息("1100" , true, false, ""),
    表内温度("1200" , true, false, "℃"),
    电池电压("1201" , true, false, "V"),
    表内电池运行时间("1202" , true, false, "分"),
    信号强度RSRP("1300" , true, false, ""),
    累计成功上传数据次数("1400" , true, false, "次"),
    累计失败上传数据次数("1401" , true, false, "次"),
    失败上传数据次数("1402" , true, false, "次"),
    表计状态字1("1501" , true, false, ""),
    表计状态字2("1502" , true, false, ""),
    表计状态字3("1503" , true, false, ""),
    表计状态字数据块("15FF" , true, false, ""),
    电池低压总天数("1600" , true, false, "天"),
    累计流量超上限持续时间("1601" , true, false, "分"),
    累计反向计量持续时间("1602" , true, false, "分"),
    累计漏水持续时间("1603" , true, false, "时"),

    // 参变量数据标识编码表
    日期时间("2000" , true, true, ""),
    硬件版本号("2010" , true, true, ""),  // 要求要能写 修改为 true
    固件版本号("2011" , true, true, ""),  // 要求要能写 修改为 true
    设备识别码IMEI("2020" , true, false, ""),
    用户识别码IMSI("2021" , true, false, ""),
    SIM卡标识ICCID("2022" , true, false, ""),
    厂商编码("2030" , true, true, ""),
    通信地址("2031" , true, true, ""),
    表计参数("2032" , true, true, ""),
    脉冲常数("2033" , true, true, "imp"),
    生产日期("2034" , true, true, ""),
    表计型号("2035" , true, true, ""),
    密钥("2050" , true, false, ""),
    密钥版本和加密序号("2051" , true, false, ""),
    服务器域名("2100" , true, true, ""),
    备用服务器域名("2101" , true, true, ""),//SpareRealmNameAction.class
    运营商APN("2108" , true, true, ""),
    流量超上限报警值("2200" , true, true, "m^3/h"),
    流量超上限持续时间("2201" , true, true, "分"),
    反向流量报警最小流量("2202" , true, true, "m^3/h"),
    反向流量持续时间("2203" , true, true, "分"),
    漏水侦测报警最小流量("2204" , true, true, "m^3/h"),
    漏水侦测持续时间("2205" , true, true, "时"),
    一级低电压报警值("2206" , true, true, "V"),
    二级低电压报警值("2207" , true, true, "V"),
    月冻结日期("2300" , true, true, ""),
    日冻结时间("2301" , true, true, ""),
    定时冻结时间间隔("2302" , true, true, "分"),
    周期上传时间间隔("2311" , true, true, "分"),
    周期上传离散起始时间("2313" , true, true, ""),  //协议没错水表开始结束时间反了
    周期上传离散结束时间("2312" , true, true, ""),   //暂时 后台吧两个did反过来写
    离散时间间隔("2314" , true, true, "秒"),
    在线窗口期开始时间("2401" , true, true, ""),
    在线窗口期结束时间("2402" , true, true, ""),  // OnlineWindowEndAction
    第1定点上传时间("2411" , true, true, ""),
    第2定点上传时间("2412" , true, true, ""), //PointUpTimeSecondAction
    第3定点上传时间("2413" , true, true, ""),  //PointUpTimeThirdAction
    第4定点上传时间("2414" , true, true, ""), //PointUpTimeFourthAction
    解除通信链路时间("2514" , true, true, "秒"),
    重发机制次数("2515" , true, true, "次"),
    重发机制间隔时间("2516" , true, true, "分"),
    阀门动作超时时间("2600" , true, true, "秒"),
    阀门自检周期("2601" , true, true, "日"),
    阀门自检时间("2602" , true, true, ""),
    按键每日允许使用次数("2700" , true, true, ""),
    报警上传配置字("2800" , true, true, ""),

    // 冻结数据标识编码表
    // ......
    月冻结数据("3000" , true, false, ""),
    // ......
    日冻结数据("3100" , true, false, ""),
    // ......
    定时冻结数据("4000" , true, false, ""),

    // 事件记录数据标识编码表
    掉电总次数("A000" , true, false, "次"),
    掉电最后发生时刻("A001" , true, false, ""),
    表计设置底数总次数("A010" , true, false, "次"),
    设置底数最后发生时刻("A011" , true, false, ""),
    拆卸总次数("A020" , true, false, "次"),
    拆卸最后发生时刻("A021" , true, false, ""),
    磁干扰总次数("A030" , true, false, "次"),
    磁干扰最后发生时刻("A031" , true, false, ""),
    固件升级总次数("A040" , true, false, "次"),
    固件升级最后发生时刻("A041" , true, false, ""),
    参数编程总次数("A050" , true, false, "次"),
    参数编程最后发生时刻("A051" , true, false, ""),
    事件记录数据块("A0FF" , true, false, ""),
    ;

    private String did;
    private Boolean read;
    private Boolean write;
    private String unit;
    DidType(String did, Boolean read, Boolean write, String unit) {
        this.did = did;
        this.read = read;
        this.write = write;
        this.unit = unit;
    }




//    public static DidType get(String did) {
//        DidType[] values = DidType.values();
//        for (DidType type : values) {
//            if (type.did.equals(did)) {
//                System.out.println(type);
//            }
//        }
//    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Boolean getWrite() {
        return write;
    }

    public void setWrite(Boolean write) {
        this.write = write;
    }

   
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
