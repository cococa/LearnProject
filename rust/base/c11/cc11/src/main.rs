
use cc11::aaa::Person;
use rand::prelude::*;



fn main() {
    // let p = Person{
    //     width:12
    // };
    // println!("{}", p.width);

    if rand::random() { // generates a boolean
        // Try printing a random unicode code point (probably a bad idea)!
        println!("char: {}", rand::random::<bool>());
    }

}

fn getNum() -> u32 {
    return 1;
}


#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn tes1() {
        assert_eq!(2 + 2, 4);
    }


    #[test]
    fn testGet(){
        assert_eq!(1, getNum())
    }

}