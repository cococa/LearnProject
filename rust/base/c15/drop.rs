
struct CustomSmartPointer{
    data: String
}

impl Drop for CustomSmartPointer{

    fn drop(&mut self){
        println!("Dropping CustomSmartPointer with data `{}`!", self.data);
    }
}

fn main(){
    let _d = CustomSmartPointer{
        data: String::from("d123")
    };
    // 后调用的先释放！
    let c = CustomSmartPointer{
        data: String::from("c123")
    };


    // 不能直接调用 c.drop()方法，会产生 double free 的错误（双重释放？）
    // 但是可以手动调用  std::mem::drop 的 drop 方法。不同于 Drop trait 中的 drop 方法，此方法可以提早强制释放资源
    drop(c);

    println!("CustomSmartPointers created.");
}