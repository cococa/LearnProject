#include <stdio.h>


int main(){
    int a[5] = {1,2,3,4,5};
    int *p1 = &a[0];
    int *p2 = a;

    printf("p1 = %p, p2 = %p\n", p1, p2);
    printf("p1 = %p, p2 = %p\n", &p1, &p2);
    printf("p1 = %d, p2 = %d\n", *p1, *p2);

    printf("p1 = %d \n", *(p1 + 2));
    printf("p1 = %d \n", *(++p1));
    return 0;
}