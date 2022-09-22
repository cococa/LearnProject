
use std::fs::File;
use std::io::ErrorKind;
use std::io::Read;
use std::io::Error;


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

    test5();    

}



fn test1(){
     // test1
     let f  = File::open("not.txt");
     println!("{:?}", f);
     match f{
         Ok(file) => println!("found file"),
         Err(error) => println!("error = {:?}",error)
     };
}


fn test2(){

    let f = File::open("not.txt");
    match f{
        Ok(file) => file,
        Err(err) => match err.kind(){
            ErrorKind::NotFound => match File::create("not.txt"){
                Ok(fc) => fc,
                Err(e) => panic!("{:?}",e),
            }
            other_error => panic!("{:?}",other_error),
        }
    };
}

fn test3(){
    let result = read_username_from_file();
     match result{
        Ok(str) => println!("username = {}",str),
        Err(e) => println!("error = {:?}",e)
    }
}

fn read_username_from_file() -> Result<String, Error> {
    let mut f = File::open("not.txt")?;
    let mut s = String::new();
    f.read_to_string(&mut s)?;
    Ok(s)
}


fn test4(){
   let mut f =  File::open("xxxx.txt").unwrap();
   let mut s = String::new();
   f.read_to_string(&mut s);
    println!("{:?}",s);
}


fn test5(){
    //  ? 运算符只能被用于返回值与 ? 作用的值相兼容的函数。因为 ? 运算符被定义为从函数中提早返回一个值
    // 下面的代码会报错
   let f = File::open("xxxx")?;
}