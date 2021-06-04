// // 接口初步认识
function printLabel(labelObj) {
    console.log(labelObj.label);
}
var myObj = { size: 10, label: "size of 10 object" };
printLabel(myObj);
printLabel({ label: "cocoa" }); // 这样的写法不能再增加新的属性
function testOption(labelObj) {
    if (labelObj.age) {
        console.log("testOption=" + labelObj.age);
    }
    else {
        console.log("sorry age prop not found");
    }
}
testOption(myObj);
var p1 = { x: 1, y: 1 };
// p1.x = 10   //error!! readonly 
var readonlyArray = [1, 2, 3];
function test0x2(config) {
    console.log(config);
}
// test0x2({age12312:12, name:"cocoa"})  // 这样的写法，即使age 是可选的，也不能没有这个属性
// 可以绕开这样的检测
test0x2({ age12312: 123, name: "cocoa" });
var search1;
search1 = function (name, age) {
    var str = "the name = " + name + " the age = " + age;
    console.log(str);
    return str;
};
search1("cocoa", 18);
var sa;
sa = ["1", "2", "3"];
var Clock = /** @class */ (function () {
    function Clock() {
    }
    Clock.prototype.setTime = function (date) {
        this.date = date;
    };
    return Clock;
}());
var sp = {};
sp.color = "red";
sp.name = "sp";
// class Control {
//     private state: any;
// }
// interface SelectableControl extends Control {
//     select(): void;
// }
// class Button extends Control implements SelectableControl {
//     select() { }
// }
// class TextBox extends Control {
//     select() { }
// }
// // 错误：“Image”类型缺少“state”属性。
// class Image implements SelectableControl {
//     select() { }
// }
// class Location {
// }
