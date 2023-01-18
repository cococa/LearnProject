use std::rc::Rc;


#[derive(Debug)]
struct List<T> {
    head : Option<Rc<Node<T>>>
}

#[derive(Debug)]
struct Node<T>{
    data: T,
    next: Option<Rc<Node<T>>>
}


impl<T> List<T>{

    // fn new(&self, data : T){
    //     List{head: Some<Rc::new(Node{data: T, next: None})>}      
    // }


    fn new() -> Self{
        List{head: None}
    }


    fn append(&self, data : T)-> Self{
        List{
            head: Some(Rc::new(Node{ data: data, next: self.head.clone() }))
        }
    }
}




fn main(){


    let list = List::new().append(1).append(2);
    println!("{:?}",list);

}

