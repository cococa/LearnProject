let isDone = false;
let num1 = 123;
let cocoaname = "cocoa ${num1}";
console.log(cocoaname);
let list1 = [1, 2, 3];
let list2 = ["12", "22"];
// 定义  Tuple
let x;
x = ["cocoa", 12];
console.log(x[0]);
console.log(x[1]);
// console.log(x[444]);
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
let c = Color.Red;
var State;
(function (State) {
    State[State["Close"] = 0] = "Close";
    State[State["Open"] = 1] = "Open";
})(State || (State = {}));
let mState1 = State[1]; // 字符类型 mState1
console.log("the mState1 = ", mState1); // Open
let mState2 = State.Close; // 字符类型 mState
console.log("the mState2 = ", mState2); // 0
// void
function log() {
    console.log("this s my warning log");
}
let unusable = undefined;
// null and undefined
let n = null;
let u = undefined;
function fail() {
    return new Error("something failed");
}
function create(o) { }
create({ name: "cocoa" });
//  类型判断
//
let msg = "this is sample msg";
let msgLength = msg.length;
// error Argument of type 'number' is not assignable to parameter of type 'string'.
// let a : any  = parseInt(msg as number)
