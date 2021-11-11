
use employees;


## example1
SELECT dpm.emp_no, dp.dept_name, dp.dept_no
from dept_manager as dpm
         join departments as dp on dpm.dept_no = dp.dept_no;






