#[cfg(test)]
mod tests {
    #[test]
    fn it_works() {
        assert_eq!(2 + 2, 4);
    }
}
mod front_of_house{

    pub mod hosting{
        pub fn add_to_waitlist(){}
        fn seat_at_table(){}
    }

    mod serving{
        fn take_order(){}
    }    

}


pub fn eat_at_restaurant(){
    crate::front_of_house::hosting::add_to_waitlist();
}

