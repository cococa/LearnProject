let isDone: boolean = false;
let num1: number = 123;

let cocoaname: string = "cocoa ${num1}";

console.log(cocoaname);

let list1: number[] = [1, 2, 3];
let list2: Array<string> = ["12", "22"];

// 定义  Tuple
let x: [string, number];
x = ["cocoa", 12];

console.log(x[0]);
console.log(x[1]);
// console.log(x[444]);

enum Color {
  Red,
  Green,
  Blue,
}
let c: Color = Color.Red;

enum State {
  Close = 0,
  Open,
}

let mState1 = State[1]; // 字符类型 mState1
console.log("the mState1 = ", mState1);  // Open

let mState2 = State.Close; // 字符类型 mState
console.log("the mState2 = ", mState2);  // 0



// void

function log(): void {
  console.log("this s my warning log");
}

let unusable: void = undefined;

// null and undefined

let n: null = null;
let u: undefined = undefined;

function fail() {
  return new Error("something failed");
}

function create(o: object | null): void {}

create({ name: "cocoa" });

//  类型判断

//
let msg: any = "this is sample msg";
let msgLength: number = (msg as string).length;

// error Argument of type 'number' is not assignable to parameter of type 'string'.
// let a : any  = parseInt(msg as number)
