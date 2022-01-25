
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




