
// struct Cacher<T>
// where 
//     T : Fn(u32) -> u32
// {
//     calculation: T, 
//     value: Option<u32>
// }


// impl<T> Cacher<T> 
//     where T : Fn(u32) ->u32
// {
//     fn new(calculation : T) -> Cacher<T>{
//             Cacher{
//                 calculation,
//                 value: None
//             }
//     }

//     fn value(&mut self , arg: u32) -> u32{
//         match self.value{
//             Some(v)=> v,
//             None=> {
//                 let v = (self.calculation)(arg);
//                 self.value = Some(v)
//                 v
//             }
//         }
//     }

// }



fn main(){

    let v1 : Vec<i32> = vec![1,2,3];
    let mut v1_iter = v1.iter();
    println!("{:?}",v1_iter.next());

    let v2 : Vec<i32>  = v1.iter().map(|x| x + 1).collect();
    println!("{:?}", v2);


}