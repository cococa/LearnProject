#[derive(Debug)]
struct User {
    username : String,
    email: String,
    active: bool,
    age : i32
}


fn build_user(email : String , username : String ) -> User{
    User{
        email,
        username,
        active: false,
        age: 111
    }
}

fn main(){
    // 实例化结构体时属性必须全部都赋值，不能漏属性
    let mut user1 = User{
        username: String::from("123"),
        email: String::from("123@qqc.com"),
        active: true,
        age : 33
    };
    println!("{:?}", user1);
    
    // 不存在某个属性能修改，某个属性不能修改 ，解构体申明为 mut 才能修改属性， 
    user1.username = String::from("cocoa");

    let user2  = User{
        age: 111,
        ..user1   // .. 语法必须放在最后
    };  
    println!("{:?}", user2);

    let user3 = build_user(String::from("222@qq.com"), String::from("lily"));
    println!("{:?}", user3);

}