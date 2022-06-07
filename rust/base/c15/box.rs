use std::ops::Deref;

fn main(){
    //这里定义了变量 b，其值是一个指向被分配在堆上的值 5 的 Box
    let b  = Box::new(4);
    println!("b = {}", b );
    //像引用一样使用 Box<T>
    println!("b==4 {}", *b==4);


    let mb = MyBox::new(4);
    println!("mb == 4 {}", *mb  ==4);


}

// 自定义只能智能指针


struct MyBox<T>(T); 

impl<T> MyBox<T>{
    fn new(x : T) -> MyBox<T>{
        MyBox(x)
    }
}

impl<T> Deref for MyBox<T>{
    
    type Target = T;
    
    fn deref(&self) -> &Self::Target{
        &self.0
    }
}