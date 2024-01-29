fn main() {
    /**
     * 查看rust 文档  https://doc.rust-lang.org/std/string/struct.String.html
     *   
     * 发现
     * let str = "Hello"; 创建的是  Module std::string
     * let s1 = String::from("Hello"); 创建是  Struct std::string::String
     *
     *
     *
     */
    let str: &str = "Hello";

    // 两种创建字符串的方法，s1 和 s2
    let s1: String = String::from("Hello");
    let s2: String = str.to_string();

    let mut s3 = String::from("new String");
    s3.push_str(str); // push_
    s3.push('!');
    println!("{}", s3);

    for c in s3.bytes() {
        println!("{}", c);
    }
    for c in s3.chars() {
        println!("{}", c);
    }

    // 使用 + 拼接字符串
    //let s4  = s1 + &s2;
    //注意上面的 s1 和 &s2 ， s1在后面无法使用，因为 -- value moved here，但是s2 可以
    // println!("{}", s1);
    //println!("{}", s2);

    // 使用format 拼接

    let newstr = format!("{}-{}", s1, s2);
    println!("{}", s1);
    println!("{}", s2);
}
