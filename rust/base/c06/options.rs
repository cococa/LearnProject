//使用枚举自定义Option
#[derive(Debug)]
enum Option<T> {
    Some(T),
    None,
}


fn main(){
    
    let intOption = Option::Some(1); 
    // 使用none 时， 必须制定 类型
    let absent_number : Option<i32> = Option::None;
    println!("{:?}", intOption);
    println!("{:?}", absent_number);

}