
#[derive(Debug)]
enum Option<T>{
    None,
    Some(T)
}


fn main(){
        let a1 : Option<i32> = Option::None;
        println!("a1={:?}",a1); 

        let a2  = Some(5);
        println!("a2={:?}",a2); 



}