#
# # 高级联结
# use employees;
#
#
# select * from dept_manager;
#
# #有一个这样的需求，找到dept_manager下 emp_no 为 110022 的数据A，找到A 所在的dept_no 下的所有数据
#
# #按照一般的操作，可以使用子查询
# select * from dept_manager where dept_no = (select dept_no from dept_manager where  emp_no = 110022 );
#
# # 使用联结和表别名的查询
# select dm1.emp_no, dm1.dept_no
# from dept_manager as dm1 , dept_manager as dm2
# where dm1.dept_no = dm2.dept_no and dm2.emp_no = 110022;
#
#
# # SELECT IFNULL( select * from dept_manager , NULL) as dept_no
#
#
#
# show binlog events;
#
#
# show binlog events in 'mysql-bin.000988';
# show binary logs;
# show master status

create table `auth_user_ext`
(
    id bigint auto_increment  primary key,
    user_id  bigint(20)    default 0    not null comment '用户id',
    avatar  varchar(150)  default '' not null comment '头像',
    job_title  varchar(50)  default '' not null comment '职位',
    sort  int   default 0  not null comment '排序',
	rate  int   default 5  not null comment '评分',
	start_year  int   default 0  not null comment '从业年限',
	skill  varchar(150)  default '' not null comment '技能，擅长',
    intro  varchar(250)  default '' not null comment '简介',
    show_c   tinyint default 0  not null comment '是否C端展示：1展示，0不展示',
    is_deleted    tinyint     default 0     not null comment '是否已删除：1已删除，0正常',
    create_time   datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    create_person varchar(20) default 'system'          not null comment '创建人',
    update_time   datetime    default CURRENT_TIMESTAMP not null comment '修改时间',
    update_person varchar(20) default 'system'          not null comment '更新人'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户(C端展示)扩展表';


create table `auth_user_img`
(
    id bigint auto_increment  primary key,
    user_id  bigint(20)    default 0    not null comment '用户id',
    src  varchar(150)  default '' not null comment '照片',
    type  int   default 0  not null comment '类型（ 1 证书）',
    type_desc  varchar(50)  default '' not null comment '照片类型描述',
    is_deleted    tinyint     default 0     not null comment '是否已删除：1已删除，0正常',
    create_time   datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    create_person varchar(20) default 'system'          not null comment '创建人',
    update_time   datetime    default CURRENT_TIMESTAMP not null comment '修改时间',
    update_person varchar(20) default 'system'          not null comment '更新人'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户(C端展示)照片扩展表';


create table `auth_user_store_rela`
(
    id bigint auto_increment  primary key,
    user_id  bigint(20)    default 0    not null comment '用户id',
    store_id  bigint(20)    default 0    not null comment '门店id',
    is_deleted    tinyint     default 0     not null comment '是否已删除：1已删除，0正常',
    create_time   datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    create_person varchar(20) default 'system'          not null comment '创建人',
    update_time   datetime    default CURRENT_TIMESTAMP not null comment '修改时间',
    update_person varchar(20) default 'system'          not null comment '更新人'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户(C端展示)和门店的关联';