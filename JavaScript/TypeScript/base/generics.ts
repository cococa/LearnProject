//定义一个identity函数。 这个函数会返回任何传入它的值。 你可以把这个函数当成是 echo命令。

function identity(arg :any) : any{
    return arg
}

//使用any类型会导致这个函数可以接收任何类型的arg参数，这样就丢失了一些信息：传入的类型与返回的类型应该是相同的。如果我们传入一个数字，我们只知道任何类型的值都有可能被返回。

function identityUseGeneric<T>(arg: T):T{
    return arg;
}


let out1 = identityUseGeneric("123");
console.log(typeof out1);

let out2 = identityUseGeneric(123);
console.log(typeof out2);

let out3 = identityUseGeneric({});
console.log(typeof out3);



// interface Logger{
//     name : string
// }

// function doLog<T extends Logger>( log : T ) : T{
//     console.log(log.name);
//     return log;
// }

// doLog({name:'cocoa',age:123});


//在泛型里使用类类型  没看懂啊！！！


function test<T>(t: T):T{
    return t
}


let t1: <T>(t: T) => T = test;

let myIdentity: <T>(arg: T) => T = test;


// 泛型接口

interface ITest{
    <T>(arg: T): T
}


var t2 : ITest = test



// 泛型类

class GenericNumber<T>{

    test(t: T){
        console.log(t);
    }

}

let g1 = new GenericNumber<Number>()
g1.test(1123)
// g1.test("12312312")   //error




//在泛型约束中使用类型参数
function gerericsTypeParams<T,K>(obj : T ,key : K){
        
}









