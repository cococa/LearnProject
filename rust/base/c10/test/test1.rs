use std::fmt::Debug;



struct Test<T> {
    item : T  
}

trait Summary{
    fn summarize(&self);
}

impl<T> Summary for Test<T> {
    fn summarize(&self){
        println!("123");
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


fn main(){
    let t = Test::new(1);  
    testTraitParams(t);
    // let mut v1 : Vec<u8> = Vec::new();
    // v1.push(1);


}