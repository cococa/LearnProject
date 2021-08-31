
#[derive(Debug)]
enum OptionLike<T>{
    Some(T),
    None()
}


fn testOption( t: Option<u32>) -> Option<u32> {
    match t {
        Some(i) => Some(i),
        None => None,
    }
}

fn main(){
    let some_number = OptionLike::Some(123);
    println!("{:?}", some_number);

    let some_u8_value = Some(3);
    if let Some(3) = some_u8_value {
        println!("three");
    }    
    
}