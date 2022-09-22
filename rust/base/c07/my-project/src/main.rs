use my_project::front_of_house::hosting;
use std::collections::HashMap;

use std::io::Result as IoResult;

use my_project::front_of_house::Breakfast;


fn main() {
    hosting::add_to_waitlist();

    let s = String::from("123");
    let b = Breakfast::summer(&s);

    println!("{:?}",b);
    println!("{:?}",s);
}
