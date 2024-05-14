interface IKeyTest{
  name : string;
  age: string;
}


type Keys = keyof IKeyTest;
// 相当于 type Keys = "name" | "age"

function keys(keys : Keys){
  console.log(keys);
}



keys('name');
keys('age');
// keys('address');//error