use std::env;
use std::fs;

fn main() {
    println!("Hello, world!");
    let args: Vec<String> = env::args().collect();
    println!("{:?}", args);

    let config : Config = Config::new(&args);
    println!("{:?}", config.query);

    let content  =  fs::read_to_string(config.filename).expect("Could not read file");
    println!("{}", content);

}

struct Config{
    query: String ,
    filename: String 
}

impl Config{
    fn new(args:&[String]) -> Config{
        if args.len() < 3 {
            panic!("Not enough arguments");
        }    
        let query = args[1].clone();
        let filename = args[2].clone();
        Config{ query, filename }    
    }
}



fn parse_config(args: &[String]) -> Config{
    let query = &args[1];
    let filename = &args[2];//.clone();
    Config{query: query.to_string(), filename:filename.to_string()}
}


