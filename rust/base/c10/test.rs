

// fn  longest(s1 : &String , s2: &String)-> &String{
fn  longest<'a>(s1 : &'a String , s2: & String)-> &'a String{
    // if s1.len()> s2.len() {
    //     s1
    // }else{
    //     s2
    // }
    s1
}


fn main(){
    let s1 = String::from("1223");
    let result;
    {
        let s2 = String::from("123");
        result = longest(&s1, &s2);
    }
    println!("{}",result);
}