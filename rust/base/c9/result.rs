
use std::fs::File;
use std::io::ErrorKind;

fn main(){
    // test1
    // let file  = File::open("not_found.txt");
    // let f = match file{
    //     Ok(file) => println!("found file"),
    //     Err(error) => {
    //         if(error.kind() == ErrorKind::NotFound){
    //             println!("file not found!");    
    //         }else{
    //             panic!(" wa oh!");
    //         }
    //     } 
    //     //println!("error = {:?}",error)
    // };


        // test2
        let f  = File::open("not.txt").unwrap();


}