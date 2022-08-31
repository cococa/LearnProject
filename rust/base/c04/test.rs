fn main(){
    let  s = String::from("123");
    let x = take_ownership(s);
    println!("{}", x);
}

fn take_ownership(somestr: String) -> String{
    somestr.clone()
}
