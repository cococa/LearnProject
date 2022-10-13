
use std::thread;
use std::time::Duration;



fn main(){
    let vec = vec![1,2,3];
    let handle = thread::spawn(move || {
        for i in 0..10 {
            println!("vec {:?}", vec);
            thread::sleep(Duration::from_millis(1));
        }
    }); 
    drop(vec);
    handle.join().unwrap();

}