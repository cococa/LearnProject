

// trait 是私有的，别的包使用要加上 pub
trait I {
    fn f(&self){
       println!("I function f "); 
    }
}


struct Weibo{
    title: String,
    content : String,
    auther : String
}

trait Summary {
    fn summarize(&self) -> String{   // trait 的方法可以实现也可以不实现
        String::from("default impl")  // 默认实现
    }
}

impl Summary for Weibo{
    // 自定义实现
    // fn summarize(&self) -> String{
    //     format!("{}-{}-{}",self.title,self.content,self.auther)
    // }
}


impl I for Weibo{

}


// trait 做为参数

fn print(item : &impl Summary){
    println!("{}",item.summarize());
}

// 多个trait  可以用 + 相连
fn print1<T : Summary  > (item : &T){
    println!("{}",item.summarize());
}

// trait 作为返回值
// fn print() -> impl Summary  // 还可以这么写
fn print3<T : Summary>(item: &T) -> &T{
    item 
}

fn test1()-> impl I {
    Weibo{
        title: String::from("this is title"),
        content : String::from("this is content"),
        auther: String::from("lily")
    } 
}


fn main(){
    let wb = Weibo{
        title: String::from("this is title"),
        content : String::from("this is content"),
        auther: String::from("lily")
    };

    println!("{}",wb.summarize());
    
    wb.f();    // 使用trait 默认实现

    print(&wb);

    print1(&wb);

    print3(&wb);

    let t  = test1();
    t.f();

}

