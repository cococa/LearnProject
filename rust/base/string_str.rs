
/**
 *  rust 中所有字符串都是 UTF-8 编码的，不能使用索引访问字符串中的字符
 *  rust 希望在数组容量不会变化的时候，用 &str。在数组长度可能发生变化的情况下，使用 String。
 * 
 *  String 和 &str 的区别:
 * 
 *  1. String 来自标准库，分配在堆上的UTF-8 字节序列，底层是一个 Vec<u8>
 *  是包含所有权的字符串
 * 
 *  2. &str 借用字符串
 *  是一种内置类型，不属于标准库，默认使用&str，即引用类型
 *  字符串用作被称为字符串切片的引用
 *  &str类型是将自身传递给函数或其他变量的首选类型
 *  注意，不能创建 str 类型，因为它大小未知
 * 
 * 
 *  两个类型间互转:
 *  
 *  let s: String = "hello".to_string();
 *  let t: String = String::from("hello");
 *  
 *  凡是需要用 &str  的地方，都可以直接用 &String 类型的数据， 不需要转
 * 
 */


fn test_string(){
    // 创建
    let a : String  = "Hello".to_string();
    let b  = String::from("Hello");
    let c =  "hello".to_owned();
}


fn test_str(){
    // 创建
    // let a : str  = "Hello";   // 报错   doesn't have a size known at compile-time
}


fn test_str1(str: &str){
    let ss : String =  str.to_owned();
    println!("{}",ss);
    println!("{}",str);
}



fn main(){
        
    let str = "hello";
    test_str1(str);
    println!("{}",str);

    let string1 = String::from("Heelo");
    // test1(string1);   // 不支持
    test1(&string1);    // 支持 &String 会自动转为 &str


    

}