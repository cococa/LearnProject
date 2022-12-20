mkdir (make directories) 命令是用来创建目录的。它这样工作：


```
mkdir directory...
```

当有三个圆点跟在一个命令的参数后面， 这意味着那个参数可以重复，就像这样：

```
mkdir dir1 dir2 dir3
```

嵌套创建目录

```
# 在dir1 下创建 dir2
mkdir -p dir1/dir2

# 在a 目录下创建 a1 a2 文件夹
mkdir a/{a1,a2} 

```