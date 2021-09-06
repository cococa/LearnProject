
struct Weibo{
    title: String,
    content : String,
    auther : String
}

trait Summary {
    fn summarize(&self) -> String{
        String::from("default impl")  // 默认实现
    }
}

impl Summary for Weibo{
    // 自定义实现
    // fn summarize(&self) -> String{
    //     format!("{}-{}-{}",self.title,self.content,self.auther)
    // }
}


// trait 做为参数

fn print(item : &impl Summary){
    println!("{}",item.summarize());
}

fn print1<T : Summary> (item : &T){
    println!("{}",item.summarize());
}



fn main(){
    let wb = Weibo{
        title: String::from("this is title"),
        content : String::from("this is content"),
        auther: String::from("lily")
    };

    println!("{}",wb.summarize());
    print(&wb);

    print1(&wb);

}

