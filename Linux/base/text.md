# 查看文件内容命令


## cat
cat 命令读取一个或多个文件，然后复制它们到标准输出

参数：
* -n 或 --number：由 1 开始对所有输出的行数编号。
* -b 或 --number-nonblank：和 -n 相似，只不过对于空白行不编号。
* -s 或 --squeeze-blank：当遇到有连续两行以上的空白行，就代换为一行的空白行。
* -v 或 --show-nonprinting：使用 ^ 和 M- 符号，除了 LFD 和 TAB 之外。
* -E 或 --show-ends : 在每行结束处显示 $。
* -T 或 --show-tabs: 将 TAB 字符显示为 ^I。
* -A, --show-all：等价于 -vET。
* -e：等价于"-vE"选项；
* -t：等价于"-vT"选项；


```shell

# 打印 test.txt 的文件内容
cat test.txt

# 可以和重定向的命令结合使用
cat test.txt > out.txt

# 加上行号 ( 但是前面会有空格 )
cat -n test.txt > out.txt

# 清空test.txt 的文件内容( /dev/null可以查看redirection.md )
cat /dev/null > test.txt


```


##  head/tail 
有时候你不需要一个命令的所有输出。可能你只想要前几行或者后几行的输出内容。 head 命令打印文件的前十行，而 tail 命令打印文件的后十行。默认情况下，两个命令 都打印十行文本，但是可以通过”-n”选项来调整命令打印的行数。

head 和 tail 的参数基本没什么用，一般只会用到-n


```shell

# 输出前 10 行
head -n 100 test.txt

```