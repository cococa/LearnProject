package com.cocoa.testjetpack.storage.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 *

实体可以具有空的构造函数（如果相应的 DAO 类可以访问保留的每个字段），
也可以具有其参数包含的类型和名称与该实体中字段的类型和名称匹配的构造函数。Room 还可以使用完整或部分构造函数，例如仅接收部分字段的构造函数。



 */

//如果实体具有复合主键，您可以使用 @Entity 注释的 primaryKeys 属性，如以下代码段所示：
//@Entity(tableName = "user" ,primaryKeys = arrayOf("id","uid"))
// 默认情况下, 类名就是数据库表明，当然你也可以修改tableName 来自定义表名
@Entity(tableName = "user")
data class User(

    // 必须显式的定义主键，即使这个类只有一个属性，也要申明@PrimaryKey;
    @PrimaryKey(autoGenerate = true) var uid: Int?,  // autoGenerate 自动分配id
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "age") var age: Int,
    // 如果要忽略某个字段，可以用@Ignore ，当然也可以在@Entity 中设置 ignoredColumns
    @Ignore var msg: String?

) {

    constructor() : this(10, "", 10, null)

}