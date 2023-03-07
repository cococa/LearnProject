// use crate::TestClion::vegetables::Asparagus;
// pub mod lib;


mod vegetables;
mod util;
mod bean;

use crate::vegetables::Asparagus;
use crate::util::str;
use crate::bean::person::Person;


/**
1. 从 crate 根节点开始: 当编译一个 crate, 编译器首先在 crate 根文件（通常，对于一个库 crate 而言是src/lib.rs，对于一个二进制 crate 而言是src/main.rs）中寻找需要被编译的代码。
这条的理解大概就是：
-多个bin类型的crate（main.rs）
-0个或1个lib类型的crate (lib.rs)


声明模块: 在 crate 根文件中，你可以声明一个新模块；比如，你用mod garden声明了一个叫做garden的模块。编译器会在下列路径中寻找模块代码：
-内联，在大括号中，当mod garden后方不是一个分号而是一个大括号
-在文件 src/garden.rs  （bean/person.rs bean.rs 就是参考了这个写法）
-在文件 src/garden/mod.rs  （util/str.rs  就是参考了这个写法）


*/
fn main() {
    let plant = Asparagus {};
    println!("I'm growing {:?}!", plant);
    str::hello();
    println!("Im person {:?}", Person {});

    say::hello();
    // 绝对路径调用
    crate::say::hello();

    say::hi::hi_1();
    say::hi::hi_2();
}

mod say {
    pub fn hello() {
        println!("Hello, world!");
    }

    fn hello_2() {
        println!("hello")
    }

    pub mod hi {
        pub fn hi_1() {
            super::hello_2();
        }

        pub fn hi_2() {
            println!("hi there");
        }
    }
}




// #[cfg(test)]
// mod tests {
//
//     use crate::util::str;
//
//     #[test]
//     fn it_works() {
//         let result = 2 + 2;
//         assert_eq!(result, 5);
//     }
//
//     #[test]
//     fn getstr(){
//         assert_eq!(str::getstr(),"hello");
//     }
//
//
// }