use std::cell::Cell;

fn main(){

    let c = Cell::new("123");
    let one  = c.get();
    println!("{}",one);
    c.set("222");
    let two  = c.get();
    println!("{}",two);
}