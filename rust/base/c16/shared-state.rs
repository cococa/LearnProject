use std::sync:: {Mutex, Arc};
use std::thread;


fn main(){
    simple2();
}


fn simple2(){
    let m = Arc::new(Mutex::new(0));
    let mut handles = vec![];
    
    for i in 0..10{
        let m = Arc::clone(&m);
        let handle = thread::spawn(move || {
            let mut num = m.lock().unwrap();
            *num  += 1;
        });  
        handles.push(handle);
    }

    for item in handles{
        item.join().unwrap();
    }
    println!("{:?}",m);
    // println!("{:?}",*m.lock().unwrap());
}


fn simple1(){
    let m = Mutex::new(5);
    {
        let mut num = m.lock().unwrap();
        *num = 6;
    }

    println!("{:?}",m);
}