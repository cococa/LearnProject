fn main(){
    let v = vec![1,2,3];
    println!("{:?}",v);


    match v.get(1){
        Some(num) => println!("{}",num),
        None => println!("none!")
    }    

    // 获取一个不存在的下标
    match v.get(111){
        Some(num) => println!("{}",num),
        None => println!("none!")
    }  
    
    // 遍历
    for i in &v {
        println!("{}",i);
    }
    
    test1();
    test2();
    test3();

}


fn test1(){
    let mut s1 = String::from("123");
    let s2 = "s2";
    s1.push_str(s2);
    println!("{}",s2);
}

fn test2(){
    let s1 = String::from("Hello");
    let s2 = String::from("Hello");
    let s3 = s1 + &s2;  // 不能 &1 + &2  因为 + 本身是一个add 方法
    // can not use s1 ,moved s3
    // println!("s1 = {}",s1);
    println!("s3 = {}",s3);
}


fn test3(){
    let s1 = String::from("Hello");
    let s2 = String::from("Hello"); 
    let s3 = String::from("Hello"); 
    let result = format!("{}-{}-{}", s1,s2,s3);
    println!("{}",result);
}



