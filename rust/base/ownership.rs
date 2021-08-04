


fn main(){



    println!("-------所有权与函数的demo---------");
    let mut x  = String::new();
    x.push_str("123");
    make_string(x);  //value moved here
    
    // println!("the end of x = {}",x);  // 这句话会报错，因为  make_string(x)

    // 下面的3行代码可以正常运行，
    // 返回值也可以转移所有权  x1 的所有权没了，但是可以通过x2 得到所有权
    let x1 = String::from("123");
    let x2 = make_string1(x1);
    println!("{}",x2);




}


fn make_string(str :String ) {
    println!("{}",str);
}

fn make_string1(str :String ) -> String {
    str
}