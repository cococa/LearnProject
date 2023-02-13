use std::fmt::Display;
use std::fmt::Debug;
use std::ops::Add;

struct Test<T> {
    item : T  
}

trait Summary{
    fn summarize(&self);
}

impl<T> Summary for Test<T> {
    fn summarize(&self){
        println!("222");
    }
}


// 注意  impl 后也要带上<T> 
impl<T :Debug> Test<T>{

    fn new(item: T) -> Self{
         Test{ item }   
    }
    fn test(&self){
        println!("{:?}",self.item);
    }

}




fn testTraitParams(t : impl Summary){
    t.summarize();
}

fn add<T : Add >(t1: T , t2 : T) where <T as Add>::Output:  {
    let _  = t1 + t2;
    // println!("{:?}", t);
}



fn main(){
    let t = Test::new(1);  
    testTraitParams(t);
    add(1,2);
}