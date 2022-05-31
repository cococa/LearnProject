
#[derive(PartialEq, Debug)]
struct Shoe{
    size : u32,
    style: String,
}

fn shoes_in_size(shoes : Vec<Shoe>, size : u32) -> Vec<Shoe>{
    shoes.into_iter().filter(|s| s.size == size).collect()
}


fn main(){

    let v1  = vec![1,2,3,4,5];
    let v1_iter = v1.iter();

    for val in v1_iter {
        println!("{}", val);
    }

    let sum : i32 = v1.iter().sum();
    println!("{}", sum);


    let result1 : Vec<_> =  v1.iter().map(|x|  x * x ).collect();
    println!("{:?}", result1);



    
    let shoes = vec![
        Shoe {
            size: 10,
            style: String::from("sneaker"),
        },
        Shoe {
            size: 13,
            style: String::from("sandal"),
        },
        Shoe {
            size: 10,
            style: String::from("boot"),
        },
    ];

    let in_my_size = shoes_in_size(shoes, 10);
    println!("{:?}", in_my_size);    

}