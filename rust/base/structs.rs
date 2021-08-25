fn main(){
    let mut user = User{
        name: String::from("cocoa"),
        age: 44
    };

    // 要修改结构体实例的属性，需要标记user 为可变
    user.age = 2222;    //---- help: consider changing this to be mutable: `mut user`

    println!("the name {} the age {}",user.name,user.age);

    let u2 = build_user(12,String::from("cc"));

    println!("the name {} the age {}",u2.name,u2.age);

    //使用user 创建新的u3 对象
    let u3 = User{
        name: String::from("xxxx"),
        ..user
    };
    println!("the name {} the age {}",u3.name,u3.age);

    println!("u3.log() {}",u3.log());

}



fn build_user(age: u32 ,name : String) -> User{
    User{
        name : name,
        age : age
    }
}


struct User {
    name: String,
    age: u32
}

impl User{
    fn log(&self) -> u32{
        self.age
    }
}