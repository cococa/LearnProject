
#[derive(Debug)]
enum IpAddrKind{
    V4,
    V6
}


#[derive(Debug)]
enum IpAddrKindV2{
    V4(String),
    V6(String)
}

#[derive(Debug)]
enum IpAddrKindV3{
    V4(u8,u8,u8,u8),
    V6(String)
}


fn route(ip_type : IpAddrKind){

}



fn main(){
    route(IpAddrKind::V4);
    println!("IpAddrKind \r{:?}",IpAddrKind::V4);

    println!("IpAddrKindV2 \r{:?}",IpAddrKindV2::V4(String::from("192.168.0.1")));

    let v4 = IpAddrKindV3::V4(192,168,0,1);
    println!("IpAddrKindV3 \r{:?}", v4 );



}