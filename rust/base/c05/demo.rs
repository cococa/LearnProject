struct Reactangle {
    width : i64,
    height: i64
}

impl Reactangle{
    fn area(&self) -> i64{
        self.height * self. width
    }
    fn can_hold(&self, other : &Reactangle) -> bool {
        self.width > other.width && self.height > other.height
    }
}


fn main(){
        let main  = Reactangle{ width : 100 , height :100};
        let child = Reactangle {width : 20 , height: 20 };

        let result = main.can_hold(&child);
        println!("main can hold child ? {}", result);
}

