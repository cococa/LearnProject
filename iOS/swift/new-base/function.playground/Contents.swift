import Cocoa

func great(person : String) -> String{
    "Hello \(person)!"
}


great(person: "cocoa")


// return type use optional tuple
func minMax(array : [Int]) -> (min: Int , max : Int)?{
    return nil
}


func someFunction(argmentLable parameterName : Int){
//    Cannot assign to value: 'parameterName' is a 'let' constant
//    parameterName = 11
}


func swap(a : inout  Int , b : inout Int){
    let t = a
    a  = b
    b = t
}

var a = 10
var b = 20
print("the a = \(a) and b = \(b)")
swap(&a, &b)
print("the a = \(a) and b = \(b)")




// function type as return type

func stepForwatd(_ input: Int) -> Int{
    return input + 1
}



func chooseFunction() -> (Int) -> Int {
    return stepForwatd
}







