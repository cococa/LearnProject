
fn  main(){
    test1();
    test2();
    test3();
}



fn test1(){
    let s = String::from("Hello");
    let len = change1(&s);
    println!("{}", len);
}

fn change1(str: &String) -> usize {
    str.len()   
}//因为 str 没有所有权，所以一切正常

fn test2(){
    let s = String::from("Hello");
    change2(&s);   
}

fn change2(str: &String) {
    //^^ `str` is a `&` reference, so the data it refers to cannot be borrowed as mutable
    //借用的变量是不可变的，所以这里会报错
    // str.push_str("123");   //
}

fn test3(){
    println!("-----test3----");
    println!("test3 修复了test2 的问题，使用可变引用，注意mut 关键字出险的地方！");
    let mut s = String::from("Hello");
    change3(&mut s);   
    println!("{}",s);
}

fn change3(str: &mut String) {
    str.push_str("123");   
}

fn  test4(){
    let mut s = String::from("123");
    {
        let ss = &mut s; // 这样是可以的
    }
    let  s1 = &mut s;              
    // let  s2 = &mut s;   //error! // 不能在同一作用域中存在  可变引用
}

fn test5(){
    let s = String::from("123");
    let s1 = s;
    // let s2 = &mut s;   //error！ //  不能在拥有不可变引用的同时拥有可变引用
    // 因为可变引用的改变，会导致不可变的对象发生更改，这是不可变对象不想看到的
    
}