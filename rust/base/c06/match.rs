
enum Coin {
    Penny,
    Nickel,
    Dime,
    Quarter,
}



fn match_int(i : i32){
    match i {
        1 => println!("one"),
        2 => println!("two"),
        _ => {
            println!("other wise");
        }    
    }
}


fn value_in_cents(coin : Coin) -> u8 {
    match coin {
        Coin:: Penny => {
            // 多行情况可以使用 {} 包括
            println!("match penny!");
            1
        },
        Coin:: Nickel => 5,
        Coin:: Dime => 10,
        Coin:: Quarter => 25,
    }
}


fn main(){

    let penny = Coin:: Penny;

    let result  = value_in_cents(penny);

    println!("{}", result);

    let one  = 11;
    match_int(one);


}