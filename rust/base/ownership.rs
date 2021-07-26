


fn main(){



    println!("-------所有权与函数的demo---------")
    let mut x  = String::new();
    x.push_str("123");
    make_string(x);  //value moved here
    
    // println!("the end of x = {}",x);  // 这句话会报错，因为  make_string(x)


}


fn make_string(str :String ) {
    println!("{}",str);
}