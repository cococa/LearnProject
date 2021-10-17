
#[derive(Debug)]
enum IpAddressKind {
    V4,
    V6,
}

#[derive(Debug)]
enum IpAddressKindV1{
    V4(u8,u8,u8,u8),
    V6(String),
}

impl IpAddressKindV1 {
    fn call(&self){
         println!("call function ==>{:?}",self);  
    }
}


fn main(){

    println!("{:?}", IpAddressKind::V4);

    let localhost = IpAddressKindV1::V4(127,0,0,1);    
    localhost.call();
    
    println!("{:?}", localhost);

}