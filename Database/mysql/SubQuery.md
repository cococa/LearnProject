# 子查询

```SQL

// 子查询都是由内向外执的，比如下面语句，先执行（）中的 SQL
select * from dept_emp where dept_no in (
    select dept_no from departments where dept_name ='Sales'
);

```



```SQL

//这里  departments 是部门表   dept_manager 是部门对应的管理员
//下面的SQL 表示查询出部门下管理员的数量   dept_count

select dept_name,
    (SELECT COUNT(*) from dept_manager WHERE
        dept_manager.dept_no=departments.dept_no) as dept_count
from departments;

```

| dept\_name | dept\_count |
| :--- | :--- |
| Customer Service | 4 |
| Development | 2 |
| Finance | 2 |
| Human Resources | 2 |
| Marketing | 2 |
| Production | 4 |
| Quality Management | 4 |
| Research | 2 |
| Sales | 2 |
