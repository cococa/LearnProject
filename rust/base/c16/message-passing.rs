use std::thread;
use std::sync::mpsc;
use std::time::Duration;


fn main(){
    test3();
}


fn test3(){
    let (tx, rx) = mpsc::channel();
    let tx1 = tx.clone();
    
    thread::spawn(move || {
        let vec= vec![
            String::from("123"),
            String::from("223"),
            String::from("323")
        ];
        for item in vec{
            tx1.send(item).unwrap();
            thread::sleep(Duration::from_secs(1));
        }
    });
    thread::spawn(move || {
        let vec= vec![
            String::from("Hello"),
            String::from("rust"),
            String::from("heihei")
        ];
        for item in vec{
            tx.send(item).unwrap();
            thread::sleep(Duration::from_secs(1));
        }
    });
    //recv 会阻塞主线程
    for received in rx {
        println!("Got: {}", received);
    }
}


fn test2(){
    let (tx, rx) = mpsc::channel();
    let handle = thread::spawn(move || {
        let vec= vec![
            String::from("123"),
            String::from("223"),
            String::from("323")
        ];
        for item in vec{
            tx.send(item).unwrap();
            thread::sleep(Duration::from_secs(1));
        }
    });
    //recv 会阻塞主线程
    for received in rx {
        println!("Got: {}", received);
    }
}


fn test1(){
    let (tx, rx) = mpsc::channel();
    let handle = thread::spawn(move || {
        let v = String::from("123");
        tx.send(v).unwrap();
        //  cannot find value `val` in this scope
        // println!("val is {}", val);   
    });
    //recv 会阻塞主线程
    let received = rx.recv().unwrap();
    println!("Got: {}",received);
}