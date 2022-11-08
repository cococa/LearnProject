
#[derive(PartialEq, Debug)]
struct Shoe{
    size : u32,
    style: String,
}

fn shoes_in_size(shoes : Vec<Shoe>, size : u32) -> Vec<Shoe>{
    shoes.into_iter().filter(|s| s.size == size).collect()
}


// iter返回的是值的不可变引用，即&T
// iter_mut返回的是可变引用，即&mut T
// into_iter返回的是T类型的值


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

    // test1 
    // let in_my_size = shoes_in_size(shoes, 10);
    // println!("{:?}", in_my_size);    

    // test2 [无法编译]  测试 into_iter 后，打印最老的shoes ，发现 into_iter 发生了值借用
    // 报错原因----------- `shoes` moved due to this method call
    // let myShoes :Vec<Shoe> = shoes.into_iter().filter(|item| 10 == item.size ).collect();
    // println!("{:?}", shoes);    





}