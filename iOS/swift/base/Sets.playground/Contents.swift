//: Playground - noun: a place where people can play

import UIKit

// 集合（Sets）

// Set 用来存储相同类型并且没有顺序的值
// 当集合元素顺序不重要时或者希望确保每个元素只出现一次时可以使用集合而不是数组。
// Swift的Set类型被桥接到Foundation中的NSSet类。

// Set 无序，并且元素不允许重复


// 元素不允许重复主要是依靠了哈希值
/**
 1.一个类型存储在集合中，这个类型就是可哈希化的，
 2.Swift 的所有基本类型(比如String,Int,Double和Bool)默认都是可哈希化的，可以作为集合的值的类型或者字典的键的类型。没有关联值的枚举成员值(在枚举有讲述)默认也是可哈希化的。
 3.你可以使用你自定义的类型作为集合的值的类型或者是字典的键的类型，但你需要使你的自定义类型符合 Swift 标准库中的Hashable协议。符合Hashable协议的类型需要提供一个类型为Int的可读属性hashValue。由类型的hashValue属性返回的值不需要在同一程序的不同执行周期或者不同程序之间保持相同。
 4.因为Hashable协议符合Equatable协议，所以遵循该协议的类型也必须提供一个"是否相等"运算符(==)的实现。这个Equatable协议要求任何符合==实现的实例间都是一种相等的关系。也就是说，对于a,b,c三个值来说，==的实现必须满足下面三种情况：
 * a == a (自反性)
 * a == b 等于  b == a  (对称性)
 * a == b && b == c 等于 a == c  (传递性)
 
 */


// 创建和构造空的集合

var letters = Set<Character>()

letters.count  // 集合元素的个数

letters.insert("A")


// 用字面量创建集合

var mSet : Set<String> = ["11","22"]

// 注意，上面的Set必须显示申明，不然无法推断出是数组还是Set，后面的的泛型String 可以不用显示申明



// 访问和修改一个集合

mSet.count   // 元素的个数
mSet.isEmpty   // 和数组一样

mSet.remove("11")    //删除元素，成功后并但会删除的值

mSet.remove("333")   // 如果删除一个不存在的元素，返回nil


mSet.insert("123")
mSet

mSet.contains("123")   // 返回Set 中是否包含这个元素


// 遍历Set

for item in mSet{
    print(item)
}

for (index,value) in mSet.enumerated(){
    print("index is \(index) and value is \(value)")
}


//集合基本操作
//使用intersection(_:)方法根据两个集合中都包含的值创建的一个新的集合。
//使用symmetricDifference(_:)方法根据在一个集合中但不在两个集合中的值创建一个新的集合。
//使用union(_:)方法根据两个集合的值创建一个新的集合。
//使用subtracting(_:)方法根据不在该集合中的值创建一个新的集合。


let oddDigits: Set = [1, 3, 5, 7, 9]
let evenDigits: Set = [0, 2, 4, 6, 8]
let singleDigitPrimeNumbers: Set = [2, 3, 5, 7]

oddDigits.union(evenDigits).sorted()
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
oddDigits.intersection(evenDigits).sorted()
// []
oddDigits.subtracting(singleDigitPrimeNumbers).sorted()
// [1, 9]
oddDigits.symmetricDifference(singleDigitPrimeNumbers).sorted()
// [1, 2, 9]




//使用“是否相等”运算符(==)来判断两个集合是否包含全部相同的值。
//使用isSubset(of:)方法来判断一个集合中的值是否也被包含在另外一个集合中。
//使用isSuperset(of:)方法来判断一个集合中包含另一个集合中所有的值。
//使用isStrictSubset(of:)或者isStrictSuperset(of:)方法来判断一个集合是否是另外一个集合的子集合或者父集合并且两个集合并不相等。
//使用isDisjoint(with:)方法来判断两个集合是否不含有相同的值(是否没有交集)。
let houseAnimals: Set = ["🐶", "🐱"]
let farmAnimals: Set = ["🐮", "🐔", "🐑", "🐶", "🐱"]
let cityAnimals: Set = ["🐦", "🐭"]

houseAnimals.isSubset(of: farmAnimals)
// true
farmAnimals.isSuperset(of: houseAnimals)
// true
farmAnimals.isDisjoint(with: cityAnimals)
// true





















































