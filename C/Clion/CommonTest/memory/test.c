//
// Created by Administrator on 2020/7/30.
//

#include <stdio.h>

// 如果在其他文件中使用全局变量，需要用extern申明
extern int grobalA;

void testGrobal(){
    printf("the a %d\n", grobalA );

}