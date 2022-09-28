use std::thread;
use std::time::Duration;

fn main(){


    // ----version1----    
    let a = 11;
    test1(a);    

    // -----version2-------     
    // let a = 1;
    // test2(a);    

}

struct Cacher<T>
where T: Fn(u32) -> u32 {
    calculation: T,
    value :Option<u32>
}

impl<T> Cacher<T> 
where T : Fn(u32) -> u32 {

    fn new(calculation : T) -> Cacher<T> {
        Cacher {
            calculation,
            value: None
        }
    }

    fn value(&mut self, num : u32) -> u32{
        match self.value{
            Some(v) => v,
            None => {
                let v = (self.calculation)(num);
                self.value = Some(v);
                v
            }
        }
    }

}

fn test2(num : u32){
    let mut closures_a = Cacher::new (|x| {
        thread::sleep(Duration::from_secs(3));
        x+ 1    
    });

    if num < 10 {
        println!("{}", closures_a.value(num));
        println!("{}", closures_a.value(num));
    }else{
        println!("{}", "123");
    }
}




fn test1( num : u32){
    // 闭包的类型自动推断。如果第一次调用closures_a 传u32 类型，第2次调用传u32以外的类型，则会报错
    // let closures_a = | x | {    // 简写
    let closures_a = | x : u32 | -> u32{
        thread::sleep(Duration::from_secs(2));
        x + 1
    };
    if num < 10 {
        println!("{}", closures_a(num));
        println!("{}", closures_a(num));
    }else{
        println!("{}", "123");
    }
}