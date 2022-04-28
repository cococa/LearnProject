var isDone = false;
var num1 = 123;
var cocoaname = "cocoa ${num1}";
console.log(cocoaname);
var list1 = [1, 2, 3];
var list2 = ["12", "22"];
// 定义  Tuple
var x;
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
var c = Color.Red;
var State;
(function (State) {
    State[State["Close"] = 0] = "Close";
    State[State["Open"] = 1] = "Open";
})(State || (State = {}));
var mState1 = State[1]; // 字符类型 mState1
console.log("the mState1 = ", mState1);
var mState2 = State.Close; // 字符类型 mState
console.log("the mState2 = ", mState2);
// void
function log() {
    console.log("this s my warning log");
}
var unusable = undefined;
// null and undefined
var n = null;
var u = undefined;
function fail() {
    return new Error("something failed");
}
function create(o) { }
create({ name: "cocoa" });
//  类型判断
//
var msg = "this is sample msg";
var msgLength = msg.length;
// error Argument of type 'number' is not assignable to parameter of type 'string'.
// let a : any  = parseInt(msg as number)
