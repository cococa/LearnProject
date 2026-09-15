#!/usr/bin/python3
import numpy as np
import matplotlib.pyplot as plt

# 画 L2 = 2 的圆
theta = np.linspace(0, 2 * np.pi, 400)
r = 2
x = r * np.cos(theta)
y = r * np.sin(theta)

# 你给的点
points = np.array([
    [2, 0],
    [0, 2],
    [-2, 0],
    [1, np.sqrt(3)],
    [-1, -np.sqrt(3)]
])

# 开始画图
plt.figure(figsize=(6, 6))
plt.plot(x, y, label='L2 norm = 2')
plt.scatter(points[:, 0], points[:, 1], color='red', s=60, label='Given points')

# 给点加标签
labels = [
    "(2,0)",
    "(0,2)",
    "(-2,0)",
    "(1,√3)",
    "(-1,-√3)"
]

for i, label in enumerate(labels):
    plt.text(points[i, 0] + 0.08, points[i, 1] + 0.08, label)

# 坐标轴
plt.axhline(0)
plt.axvline(0)
plt.scatter(0, 0, label='Origin')

plt.axis('equal')
plt.xlim(-3, 3)
plt.ylim(-3, 3)
plt.grid(True)
plt.legend()
plt.title('Points with L2 Norm = 2')
plt.xlabel('x')
plt.ylabel('y')

plt.show()