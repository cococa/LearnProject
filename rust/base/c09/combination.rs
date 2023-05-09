
fn main(){


    let vec = vec![1,2,3,4,5,6,7,8,9,10];

    let incVec = vec.iter().map(|x| x+1);

    for i in incVec{
        println!("{}",i);
    }

    println!("\n---------use option map---------\n");

    let option = Some(2);
    match option.map(|x| x*x){
        Some(x) => println!("{}",x),
        None => println!("none")
    }






}
