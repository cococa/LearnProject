use std::env;
use std::fs;
use std::error::Error;
use std::process;

#[derive(Debug)]
pub struct QueryConfig{
    pub query : String,
    pub filename : String,
    pub case_sensitive: bool
}

impl QueryConfig{
    pub fn new(args : &[String]) -> Result<QueryConfig, &'static str>{
        if args.len() < 3 {
            return Err("not enough arguments");
        }
        Ok(QueryConfig{
            query : args[2].clone(),
            filename : args[1].clone(),
            case_sensitive : true
        })
    }
}

pub fn run(config: QueryConfig) -> Result<(), Box<dyn Error>>{
    let contents = fs::read_to_string(config.filename)?;
    // for line in search(&config.query, &contents) {
    //     println!("{}", line);
    // }

    let results = if config.case_sensitive {
        search(&config.query, &contents)
    } else {
        search_case_insensitive(&config.query, &contents)
    };
    println!("{:?}",results);
    Ok(())
}



#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn one_result() {
        let query = "duct";
        let contents = "\
Rust:
safe, fast, productive.
Pick three.";
        assert_eq!(vec!["safe, fast, productive."], search(query, contents));
    }
}


#[test]
fn case_insensitive() {
    let query = "rUsT";
    let contents = "\
Rust:
safe, fast, productive.
Pick three.
Trust me.";

    assert_eq!(
        vec!["Rust:", "Trust me."],
        search_case_insensitive(query, contents)
    );
}


// pub fn search(query: &str, contents: &str) -> Vec<&str> {
pub fn search<'a>(querys: &str, contents: &'a str) -> Vec<&'a str>{
    let mut results = Vec::new();
    for line in contents.lines(){
        if line.contains(querys){
            results.push(line);
        }
    }
    results
}


pub fn search_case_insensitive<'a>(
    query: &str,
    contents: &'a str,
) -> Vec<&'a str> {
    let query = query.to_lowercase();
    let mut results = Vec::new();

    for line in contents.lines() {
        if line.to_lowercase().contains(&query) {
            results.push(line);
        }
    }

    results
}