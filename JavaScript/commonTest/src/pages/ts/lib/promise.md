```
参考文档：

1.  Promist A+ 规范    https://promisesaplus.com/
2.  掘金文档   https://juejin.cn/post/7222310732293570619

```


## 基础知识

### 状态
A promise must be in one of three states: pending, fulfilled, or rejected. (promise必须处于以下三种状态之一：待定、已履行或已拒绝。)

1.  pending 可以转变为fulfilled  或 rejected 状态
2.  已履行 不能转换为任何状态，必须返回一个不可变的值
3.  已拒绝 不能转换为任何状态，必须返回一个reson（被拒绝的原因）


### then 方法
promise.then(onFulfilled, onRejected)  then方法接收两个参数 ，这两个参数都是可选的
