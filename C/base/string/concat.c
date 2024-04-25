#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char* concat(char* str1, char* str2){
    char*  result = malloc(strlen(str1) + strlen(str2) + 1);
    if(result == NULL){  // 也可以使用 if(!result) 来判断，建议用 NULL 来判断
        return NULL;
    }
    strcpy(result,str1);
    strcat(result,str2);
    return result;
}

int main(){

    char* ss = "123";
    char* s2 = "ssss";
    char* result = concat(ss,s2);
    printf("%s \n",result);
    free(result);
    free(ss);
    free(s2);
    return 0;
}
