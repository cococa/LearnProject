cmake_minimum_required(VERSION 3.15)
project(Test2 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)
include_directories(advanced)
include_directories(const01)
include_directories(memory)
include_directories(pretreatment)
include_directories(variable)

#//C:\Users\hj\Desktop\libevent-master
set(INC_DIR C:/Users/hj/Desktop/libevent-master/include)
set(LINK_DIR C:/Users/hj/Desktop/libevent-master)

add_executable(Test2
    advanced/string01.c
    advanced/string01.h
    const01/const01.c
    const01/const01.h
    memory/memory.c
    memory/memory.h
    pretreatment/pretreatment.c
    pretreatment/pretreatment.h
    variable/test1.c
    variable/test1.h
    ex16.c
    ex16.h
    main.c
        string1.c
        string1.h jiqiao/jiqiao.c jiqiao/jiqiao.h memory/test.h memory/test.c pointer/p1.c pointer/p1.h pointer/p2.c pointer/p2.h pointer/p3.c pointer/p3.h pointer/p4.c pointer/p4.h pointer/string.c pointer/string.h pointer/_const.c pointer/_const.h)
