import Cocoa

let names = ["Chris", "Alex", "Ewa", "Barry", "Daniella"]

func backward(_ s1 : String , _ s2 : String ) -> Bool {
    return s1 > s2
}


var reversedNames = names.sorted(by: backward)

reversedNames = names.sorted(by: { (s1 : String, s2 : String) -> Bool in
    return s1 > s2
})


reversedNames = names.sorted(by: {s1, s2 in return s1 > s2})

reversedNames = names.sorted(by: { $0 > $1 })


reversedNames = names.sorted(){
    $0 > $1
}

reversedNames = names.sorted{  $0 > $1 }


func makeIncrementer(forIncrement amount : Int) -> ()->Int{
    var runningTotal = 0
    
    func incrementer() -> Int{
        runningTotal += amount
        return runningTotal
        
    }
    return incrementer
}


var m1 = makeIncrementer(forIncrement: 10);


var tt = 0

tt = m1();
tt = m1();
tt = m1();

print("\(tt)")

let incrementByTen = m1
incrementByTen()


