
use employees;

SELECT *
from dept_manager;

SELECT *
from departments;

## 由于employees 数据库的原因，可能无法区分 inner left right join 的区别
## 可以使用后面的参考文章的数据，后期考虑自己造数据
## example1
SELECT dpm.emp_no, dp.dept_name, dp.dept_no
from dept_manager as dpm
         join departments as dp on dpm.dept_no = dp.dept_no;

SELECT dpm.emp_no, dp.dept_name, dp.dept_no
from dept_manager as dpm ,departments as dp where  dpm.dept_no = dp.dept_no;

SELECT *
from dept_manager as dpm
inner join departments as dp on dpm.dept_no = dp.dept_no;


## 参考文章  https://www.cnblogs.com/fudashi/p/7491039.html

## leetcode  https://leetcode-cn.com/problems/combine-two-tables/
#  select p.FirstName, p.LastName,a.City,a.State from Person as p left join Address as a on p.personId = a.personId;



create table ds_test
(
    id            bigint auto_increment
        primary key,
    user_id       bigint       default 0   comment '用户id',
    avatar        varchar(150) default ''  comment '头像'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户(C端展示)扩展表';



INSERT INTO ds_test (id) VALUES (null);


# ALTER TABLE ds_test
# 	ADD COLUMN `contact_user_id` bigint(100)  DEFAULT 0 COMMENT '门店企微联系人id'
# ;
create table market_gift_material
(
    id            int(11) unsigned auto_increment comment '主键'
        primary key,
    gift_name     varchar(30)                           not null comment '素材名',
    gift_img      varchar(128)                          null comment '素材图',
    is_top        tinyint(1)  default 0                 null comment '是否置顶（0：正常，1：置顶）',
    publish_time  datetime    default CURRENT_TIMESTAMP not null comment '发布时间',
    create_time   datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    create_person varchar(20) default 'system'          not null comment '创建人',
    update_time   datetime    default CURRENT_TIMESTAMP not null comment '修改时间',
    update_person varchar(20) default 'system'          not null comment '更新人',
    is_delete     tinyint(1)  default 0                 null comment '操作类型（0：正常，1：删除）',
    top_time      datetime    default null              null comment '置顶时间'
)
    comment '赠送素材资源表' charset = utf8mb4;


