
#[derive(Debug)]
struct Person{
    name: String,
    active: bool,
    age : u64    
}

#[derive(Debug)]
struct Area{
    width: u64,
    height: u64
}

impl Area{

    fn calc(&self)-> u64{
        self.height * self.width
    }

    fn square(size : u64) ->Self {
        Self{
            width: size,
            height: size
        }
    }

    fn compare(&self, area : &Area) -> u64{
        let selfSize = self.calc();
        let otherSize = area.calc();
        return  selfSize - otherSize;
    }
}



fn calcArea(area: &Area)-> u64{
    area.width * area.height
}


fn main(){
    let p1 = Person{
        active: true,
        name: String::from("cocoa"),
        age :88
    };
    println!("p1.name = {}", p1.name);

    let p2 = buildPerson1(String::from("123123"), 18);
    println!("p2.name = {}", p2.name);

    let p3 = buildPerson2(p2);
    println!("p3.name = {}", p3.name);
    // 这里会报错 value borrowed here after move
    // println!("p2.name = {}", p2.name);


    let a1 = Area{
        width:100,
        height:100
    };
    let a2 = Area{
        width:10,
        height:10
    };
    let area2 = a1.calc();
    let area1 = calcArea(&a1);
    println!("the area1 = {} area2= {}", area1,area2);

    println!("a1 compare a2 = {} ", a1.compare(&a2));


}


fn buildPerson1(name : String , age: u64)-> Person{
    Person{
        name,
        age,
        active: false    
    }

}


fn buildPerson2(p: Person)->Person{
    Person{
        name: String::from("AAAA"),
        ..p
    }
}


