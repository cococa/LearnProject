
// 方法中定义泛型
fn largest<T : Copy + PartialOrd>(list: &[T]) -> T{
    let mut largest  = list[0];
    for &item in list.iter(){
        if  item > largest {
            largest = item;
        }
    }    
    largest
}

// 结构体重定义泛型
struct Point<T>{
    x : T,
    y : T,
}

impl<T> Point<T>{
    fn x(&self) -> &T{
        &self.x
    }
}




fn main(){
    let v = vec![1,2,3,4,5];
    let result  = largest(&v);
    println!("the largest = {}", result);

    let integer = Point{x : 1, y : 2};
    println!("{}", integer.x());


}