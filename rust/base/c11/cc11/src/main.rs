
use cc11::aaa::Person;

fn main() {
    let p = Person{
        width:12
    };
    println!("{}", p.width);
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