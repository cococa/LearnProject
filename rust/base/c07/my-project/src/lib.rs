
pub mod front_of_house {

    #[derive(Debug)]
    pub struct Breakfast{
        pub toast : String,
        seasonal_fruit: String
    }

    impl Breakfast{
        pub fn summer(toast: &str) -> Breakfast{
            Breakfast{
                toast: String::from(toast),
                seasonal_fruit : String::from("seasonal_fruit")
            }
        }
    }



    pub mod hosting {
        pub fn add_to_waitlist() {
            println!("add_to_waitlist")
        }

        fn seat_at_table() {}
    }

    fn server_order() {}

    mod serving {
        fn take_order() {}

        fn take_payment() {
            //   我们还可以使用 super 开头来构建从父模块开始的相对路径。这么做类似于文件系统中以 .. 开头的语法 
            super::server_order();
        }
    }
}

use crate::front_of_house::hosting;


pub fn eat_at_restaurant() {
    // Absolute path
    crate::front_of_house::hosting::add_to_waitlist();

    // Relative path
    front_of_house::hosting::add_to_waitlist();


    let mut meal = crate::front_of_house:: Breakfast::summer("Cocoa");  


    hosting::add_to_waitlist();

}
