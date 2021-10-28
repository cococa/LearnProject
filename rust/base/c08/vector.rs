
fn main(){
    let mut v1 : Vec<i32> = Vec::new();
    let mut v2 = vec![1,2,3];

    //必须要把 v1 声明为 mut 可变
    v1.push(4);

    println!("{:?}", v1);
    println!("{:?}", v2);


    let item1 : &i32  = &v2[1];
    println!("the item1 in vec2 = {:?}", item1);


    match v2.get(1) {
        // 这里有意思，传递进去的参数得的 &i32 类型
        Some(item1) => println!(" match 2!"),
        None => println!("not matched!")   
    }

    // get 方法取值 并不会引发 panic  ，而是返回一个Optional<&i32>  或者None
    let some_not_exist = v2.get(199);  // 这里下标199 不存在，所以是None
    println!("{:?}" , some_not_exist); 


    //--------演示借用后无法，试图操作vec，无法通过编译，类似java 中的扩容---------------
    let mut v = vec![1, 2, 3, 4, 5];
    let first = &v[0];
    // v.push(6);
    println!("The first element is: {}", first);
    //-----------------------



    
    // 遍历 vec
    // 遍历操作 vec的元素， 注意v2 得是 mut，
    for i in &mut v2 {
        *i *= *i;  // * 解引用
    }

    // 遍历 vec    
    for i in &v2 {
        println!("the item in v2 {}", i );
    }

    



}