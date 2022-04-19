


fn main(){

    // 1.Rust 中的每一个值都有一个被称为其 所有者（owner）的变量。
    // 2.值在任一时刻有且只有一个所有者。
    // 3.当所有者（变量）离开作用域，这个值将被丢弃。

    println!("-------所有权与函数的demo---------");
    let mut x  = String::new();
    x.push_str("123");
    make_string(x);  //value moved here    
    // println!("the end of x = {}",x);  // 这句话会报错，因为  make_string(x)



    // 获取n1 不会报错，因为i32 类型 实现了 Copy trait，基础类型+元组都实现了
    let n1 = 1;
    make_int(n1);
    println!("{}",n1);


    // 下面的3行代码可以正常运行，
    // 返回值也可以转移所有权  x1 的所有权没了，但是可以通过x2 得到所有权
    let x1 = String::from("123");
    let x2 = make_string1(x1);
    println!("{}",x2);  // 这里如果访问x1 就会报错，因为x1 的所有权已经被转移





}

fn make_int(i : i32){
    println!("i = {}",i);
}

fn make_string(str :String ) {
    println!("{}",str);
}

fn make_string1(str :String ) -> String {
    str
}