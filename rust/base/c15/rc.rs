use std::rc::Rc;


// enum List{
//     Cons(i32, Box<List>),
//     None,
// }



enum List{
    Cons(i32, Rc<List>),
    None,
}




fn main(){
    //  demo1   
    // let a = List::Cons(4, Box::new (List::Cons(10, Box::new(List::None))));
    // let b = List::Cons(10, Box::new(a));
    // let c = List::Cons(11, Box::new(a));


    let a = Rc::new(List::Cons(4, Rc::new (List::Cons(10, Rc::new(List::None)))));
    let b = List::Cons(10, Rc::clone(&a));
    let c = List::Cons(11, Rc::clone(&a));
    println!("count{}", Rc::strong_count(&a));


}