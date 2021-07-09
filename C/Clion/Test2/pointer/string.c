//
// Created by hj on 2021/6/21.
//

#include "string.h"

// 删除字符串空格
void my_trim(char *c) {
    char *t1 = c;
    char *t2 = c;
    while (*t1) {
        if (*t1 != 32) {  // 这里也用' ' 来判断，注意要区分'\0'
            *t2 = *t1;
            t2++;
        }
        t1++;
    }
    *t2 = 0;
}

void test_trim() {
    char str[] = " H eh  ah sj da ";
    my_trim(str);
    printf("%s", str);
}

void test_str() {
    //
    char ch[] = "HELLO";  // 栈区字符串
    char *p1 = "HELLO";    // 数据区常量字符串
    char *p2 = "HELLO";    // 数据区常量字符串

    // 修改ch 的字符是可以的
    // 修改p1 的字符会报错

    ch[2] = 'h';
//    p1[2] = 'h';  //error!!!

    printf("%s\n", ch);
    printf("%s\n", p1);

    printf("打印下p1 和 p2 的地址!!\n");
    // 发现打印的地址是一样的
    printf("the p1 address = %p\n", p1);
    printf("the p2 address = %p\n", p2);

}

// 计算字符长度
int my_strlen(const char *p) {
    char *header = p;
    while (*p != '\0') {
        p++;
    };
    int len = p - header;
    printf("the length = %d\n", len);
    return len;
}

void test_len() {
    char ch[] = "Hello";
    my_strlen(ch);
}

// 计算字符串出现次数
// 写的不好，还需要改改！！！！
int my_contain_count(char *src, char *dest) {
    char *tDset = dest;
    int count = 0;
    while (*src != '\0') {
        if (*src == *dest) {
            // 判断是否到了dest 的末尾
            if (*(dest + 1) == '\0') {
                dest = tDset;
                count++;
            }
            dest++;
        } else {
            dest = tDset;
        }
        src++;
    }
    return count;
}


test_my_contain_count() {
    char str1[] = "HelloHelloHelo";
    char str2[] = "llo";
    int count = my_contain_count(str1, str2);
    printf("test_my_contain_count %d\n", count);
}

//课后作业，统计字符出现次数  hello  h=1 e=1 l=2 o=1
void my_char_count() {

}


// 检测回文字符串
int check_huiwen(char *p) {
    char *header = p;
    char *ender = p + my_strlen(p) - 1;
    int result = 1;
    while (header < ender) {
        if (*header != *ender) {
            result = -1;
            break;
        }
        header++;
        ender--;
    }
    return result;
}

void test_check_huiwen() {
    char str[] = "abcavcba";
    int result = check_huiwen(str);
    printf("1= true -1 = false  the result = %d", result);
}

//课后作业，字符串拷贝到新的字符串
// 这里没考虑src 超过dest
void my_copy_str(char *dest, const char *src, size_t n) {
    while (*src != '\0' && n > 0) {
        *dest = *src;
        dest++;
        src++;
        n--;
    }
}

void test_copy_str() {
    char dest[] = "Hello1";
    char src[] = "TTTT";
    my_copy_str(dest, src, 2);
    printf("the dest = %s\n", dest);  //123lo1

}


void test_p5() {
    test_copy_str();
}