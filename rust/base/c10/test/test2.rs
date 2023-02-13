use std::cmp::PartialOrd;
use std::fmt::Display;

fn print_type_of<T>(_: &T) {
    println!("{}", std::any::type_name::<T>())
}


fn largest<T: PartialOrd + Display + Copy>(vec: Vec<T>) -> T {
    let mut result = vec[0];
    print_type_of(&result);
    for &item in vec.iter(){
        println!("{}",item);
        result = item
    }
    result
}

fn main(){
    let t = vec![1,2,3,4,5];
    // let mut t : Vec<i32> = Vec::new();
    largest(t);
}