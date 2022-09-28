use std::env;
use std::process;
use minigrep::QueryConfig;
use minigrep::run;

fn main(){
    let args : Vec<String> = env::args().collect();
    let config = QueryConfig::new(&args).unwrap_or_else(|err|{
        println!("Problem parsing arguments: {}", err);
        process::exit(1);
    });
    if let Err(e) = run(config){
        println!("Application error: {}", e);
        process::exit(1);
    }

    // match config{
    //     Ok(config) =>{
    //         let contents = fs::read_to_string(config.filename);
    //         match contents{
    //             Ok(str)=> println!("{}",str),
    //             Err(err) => println!("{}",err)
    //         }
    //     },
    //     Err(err) => println!("{}",err)    
    // }

    // println!("{:?}", contents);
}




// fn parse_config (args : &[String]) -> QueryConfig{
//     QueryConfig{
//         query : args[0].clone(),
//         filename : args[1].clone()
//     } 
// }