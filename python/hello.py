#!/usr/bin/python3
import math 


def add(v, w):
    return [v[0] + w[0], v[1] + w[1]]


#创建一个向量
v = [1, 2]

#向量位移[1,3]
# v = add(v, [1, 3])


dino_vectos = [(1, 2), (3, 4)]


v2 = [add(v, w) for w in dino_vectos]

print("Hello, World!", v2)