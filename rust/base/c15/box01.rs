
#[derive(Debug)]
enum List{
    Cons(i32, Box<List>),
    None,
}

fn main(){
    let a = List::Cons(1, Box::new(List::Cons(2, Box::new(List::None))));
    println!("{:?}",a);
}