# 制定cmake 的最低版本号
cmake_minimum_required (VERSION 2.8)
# 项目名称
project (Demo)

# 查找当前目录下的所有源文件
# 并将名称保存到 DIR_SRCS 变量
aux_source_directory(. DIR_SRCS)

# 添加 math 子目录
add_subdirectory(math)

# 指定生成目标
add_executable(Demo main.c)

# 添加链接库
target_link_libraries(Demo MathFunctions)