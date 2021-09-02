
use std::fs::File;

fn main(){

    let file  = File::open("not_found.txt");
    let f = match file{
        Ok(file) => println!("found file"),
        Err(error) => println!("error = {:?}",error)
    };

}