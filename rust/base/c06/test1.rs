use std::collections::HashMap;

fn main(){
    let mut map =  HashMap::new();
    map.insert("one",1);
    let value = map.get("one");
    println!("{:?}", value);
}
