
fn longest<'a>(s1: &'a str, s2 : &'a str ) -> &'a str{
    if  s1.len() > s2.len(){
        s1
    }else{
        s2
    }
}

// 这段代码是可以通过编译的
fn test1(){
    // s1 的生命周期是test1 方法
    let s1 = String::from("123");
    {
        // s2 result 生命周期是代码块，所以程序正常编译
        let s2 = "123213";
        let result  = longest(s1.as_str(), s2);
        println!("{}",result);
    }
}

fn test2(){
    // s1 的生命周期是test1 方法
    let s1 = String::from("123");
    let result;
    {
        // s2 result 生命周期是代码块，所以程序正常编译
        let s2 = String::from("22");
        result  = longest(s1.as_str(), s2.as_str());  //  s2 ^^ borrowed value does not live long enough
    }
    println!("{}",result);
}



fn main(){
    test2();
}