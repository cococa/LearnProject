#[derive(Debug)]
enum List {
    Cons(i32, Box<List>),
    Nil,
}

fn main(){
    let list = List::Cons(1, Box::new(List::Cons(3,Box::new(List::Nil))));
    println!("{:?}",list);
}