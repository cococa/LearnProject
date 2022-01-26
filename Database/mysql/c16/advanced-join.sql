
# 高级联结
use employees;


select * from dept_manager;

#有一个这样的需求，找到dept_manager下 emp_no 为 110022 的数据A，找到A 所在的dept_no 下的所有数据

#按照一般的操作，可以使用子查询
select * from dept_manager where dept_no = (select dept_no from dept_manager where  emp_no = 110022 );

# 使用联结和表别名的查询
select dm1.emp_no, dm1.dept_no
from dept_manager as dm1 , dept_manager as dm2
where dm1.dept_no = dm2.dept_no and dm2.emp_no = 110022;


SELECT IFNULL( select * from dept_manager , NULL) as dept_no






