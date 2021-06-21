//
// Created by hj on 2021/6/21.
//

#include "p5.h"

void trim(char* c){
    char* t1 = c;
    char* t2 =c;
    while(*t1){
        if(*t1 != 32){  // 这里也用' ' 来判断，注意要区分'\0'
            *t2 = *t1;
            t2++;
        }
        t1++;
    }
    *t2 = 0;
}

void test_p5(){
     char str[]  = " H eh  ah sj da ";
     trim(str);
     printf("%s" ,str);
}