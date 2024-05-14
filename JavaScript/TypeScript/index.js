function error(message) {
    throw new Error(message);
}
function foo(x) {
    if (typeof x === "string") {
        return true;
    }
    if (typeof x === "number") {
        return false;
    }
    //throw new Error('Invalid input');
    error("Invalid input");
}
foo("123");
// foo({})   // 报错
// demo2  never类型的应用, 参数中排出某个类型
/**
 * T extends string ? never : T  表示如果T是string类型，那么返回never，否则返回T
 * 在编译期，如果T是string类型，那么就会报错
 * @param x
 * @returns
 */
function log(x) {
    if (typeof x === "string") {
        // 只会在运行期执行
        return;
    }
    console.log(x);
}
//  log("123")  // 报错
log(123);
log([1, 2, 3]);
function bar(method) {
    switch (method) {
        case "GET":
            return "get";
        case "POST":
            return "post";
        default:
            var n = method;
            return n;
    }
}
bar("PUT");
