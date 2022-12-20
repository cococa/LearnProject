# 输入/输出重定向

## 1.使用命令后存储到一个文件

```shell

#把 ls 的结果输出到 log.txt （没有该文件则创建）
ls -al > log.txt

```

注意以下几点：

- 如果输出的文件不存在，则会自动创建
- 标准输出: 即命令发生错误，是不会把错误信息传递给接受方
- 重新写文件的: 不管执行几次，文件内容是重新写

以上的问题在稍后的章节会得到解决。

---

## 2.追加内容

使用 >> 可以追加内容，而不是每次都重新写

```shell

# 把 ls 的结果输出到 log.txt （没有该文件则创建）
ls -al >> log.txt

```


## 3. 重定向标准错误

一般情况下，每个 Unix/Linux 命令运行时都会打开三个文件：


- 标准输入文件(stdin)：stdin的文件描述符为0，Unix程序默认从stdin读取数据。
- 标准输出文件(stdout)：stdout 的文件描述符为1，Unix程序默认向stdout输出数据。
- 标准错误文件(stderr)：stderr的文件描述符为2，Unix程序会向stderr流中写入错误信息。

默认情况下，command > file 将 stdout 重定向到 file，command < file 将stdin 重定向到 file。

```shell

# 把 stderr 重定向到 file
not_found_command 2> log.txt

# 把 stderr 追加到 file
not_found_command 2>> log.txt

# stdout 和 stderr 合并后重定向到 file
# 即命令存在标准和错误输出，这里暂时没有想到好的例子，就用下面的两个命令替代
# 当然追加就是使用 >>，这里不在赘述
ls /aa/bb > log.txt 2>&1
ls /usr > log.txt 2>&1

# 现在的 bash 版本提供了第二种方法，更精简合理的方法来执行这种联合的重定向。
ls -l /aa/bb &> log.txt


```



## 4. 输入重定向

本来需要从键盘获取输入的命令可以转移到文件读取内容。

```shell

# 暂时没验证过
command1 < file1

```