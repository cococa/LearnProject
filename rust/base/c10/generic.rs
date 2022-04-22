
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

// 只有在 Point 为i32 时，才能调用 Point::x1
impl Point<i32>{
    fn x1(&self) -> &i32{
        &self.x
    }
}


enum Result<T, E> {
    Ok(T),
    Err(E)
}


fn main(){
    let v = vec![1,2,3,4,5];
    let result  = largest(&v);
    println!("the largest = {}", result);

    let integer = Point{x : 1, y : 2};
    // let float = Point{x : 1.0, y : 2};   // expected floating-point number, found integer
    println!("{}", integer.x());
    println!("{}", integer.x1());


}