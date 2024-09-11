
interface Person {
  name ?: string;
  age ?: number;
}



function test0x2(config: Person) {
  console.log(config);

}
// Excess Property Checks
// 如果一个对象字面量存在任何“目标类型”不包含的属性时，你会得到一个错误。
// test0x2({aaa: 123});
// 你可以绕开这些检查
test0x2({aaa: 123} as Person);


// 接口多次声明会被合并
interface Person {
  address ?: string
}


const p: Person = {
  name: 'cocoa',
  age: 18,
  //address: 'shanghai'
}




