# js 原型继承

参考 https://zh.javascript.info/prototype-inheritance  



## 1. Prototype 
在 JavaScript 中，对象有一个特殊的隐藏属性 [[Prototype]]（如规范中所命名的），它要么为 null，要么就是对另一个对象的引用。该对象被称为“原型”：

从 object 中读取一个缺失的属性时，JavaScript 会自动从原型中获取该属性。




```javascript 

let animal = {
  eats: true
};
let rabbit = {
  jumps: true
};

rabbit.__proto__ = animal; // (*)

// 现在这两个属性我们都能在 rabbit 中找到：
alert( rabbit.eats ); // true (**)
alert( rabbit.jumps ); // true

// 在这儿我们可以说 “animal 是 rabbit 的原型”，
// 或者说 “rabbit 的原型是从 animal 继承而来的”。


```

原型链可以很长：  A -> B -> C  

### 原型链继承的限制：

1. 引用不能形成闭环。如果我们试图给 __proto__ 赋值但会导致引用形成闭环时，JavaScript 会抛出错误。
2. __proto__ 的值可以是对象，也可以是 null。而其他的类型都会被忽略。


### this 指向问题

如果我们调用 obj.method()，而且 method 是从原型中获取的，this 仍然会引用 obj。因此，方法始终与当前对象一起使用，即使方法是继承的。