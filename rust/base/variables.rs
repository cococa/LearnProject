fn main(){
    // let mut ss = String::from("12312");
    // // ss.("123");
    // ss.push_str("Hello");
    // println!("{}",ss);
    // let _s2 = ss.clone();
    // println!("the len of ss = {}",ss.len());



    let mut x = 10;
    x = 12;   


 // （Shadowing）demo  在Shadowing 操作时，不能使用 let mut，切记！！！
    let y  = "this is stirng!";
    let y  = y.len();   // 这里在进行 Shadowing 操作, Shadowing 操作可以进行重新赋值，而且可以改变类型
    println!("y = {}",y);  // y = 15



    

}