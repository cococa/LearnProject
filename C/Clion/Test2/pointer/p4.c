//
// Created by Administrator on 2021/4/23.
//

#include "p4.h"


struct Student {
    int age;
    char name[];
};


void test_p4() {

//    int num1 = 10;
//    int num2 = 20;
//    int num3 = 30;
//
//
//    int *array[] = {&num1, &num2, &num3};
//
//
//    printf("----%d---%d-----\n", sizeof(double *), sizeof(&num1));
//
//
//    for (int i = 0; i < 3; i++) {
//        printf("---%d--\n", *array[i]);
//    }


    struct Student ss;
    struct Student *p1;
    p1 = &ss;

    p1->age = 10;

    printf("--the p1 age = %d--\n", ss.age);


    struct Student *p2 = NULL;
    p2 = (struct Student *) malloc(sizeof(struct Student));
    p2->age = 1111;

    printf("--the p2 age = %d--\n", p2->age);


}

struct Student * createSdu(int age, char name[]){

    struct Student * p = (struct Stduent *) malloc(sizeof(struct Student));
    p-> age = age;
//    p-> name = name;
    strcpy(p->name ,name);
    return p;

}

void freeStu(struct Student *student) {
    if (student == NULL) {
        return;
    }
    free(student);
    student = NULL;
}