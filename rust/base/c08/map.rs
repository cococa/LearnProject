use std::collections::HashMap;

fn main(){

    let mut map : HashMap<String,i32> = HashMap::new();



    let a = String::from("a");
    map.insert(a, 1);
    map.insert(String::from("b"), 2);

    // println!("a = {}",a);

    println!("{:?}",map);


    // 访问hashmap 
    let key = String::from("a");
    // Option<&i32>
    let  value =  map.get(&key);
    println!("{:?}",value);


    for (k, v) in &map{
        println!("{}-{}", k ,v);
    }

}