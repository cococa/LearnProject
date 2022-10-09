
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

    let c = CustomSmartPointer{
        data: String::from("c123")
    };

    drop(c);

    println!("CustomSmartPointers created.");
}