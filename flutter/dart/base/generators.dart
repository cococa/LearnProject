import 'dart:io';

// Future<int> doSomeLongTask() async {
//   await Future.delayed(const Duration(seconds: 1));
//   return 42;
// }

Iterable<int> test1(int n) sync* {
  print("start");
  int a = 0;
  while (a < n) {
    sleep(Duration(seconds: 1));
    yield a++;
  }
  print("end");
}

Stream<int> test2(int n) async* {
  print("start");
  int a = 0;
  while (a < n) {
    sleep(Duration(seconds: 1));
    yield a++;
  }
  print("end");
}

void testSync() {
  Iterable<int> iterable = test1(3);
  for (var item in iterable) {
    print("--${item}--");
  }
  print("======the end=!!!===");
}

void testAsync() {
  test2(3).listen((item) {
    print("---${item}---");
  });
  print("======the end=!!!===");
}

// 同步生成器
// 使用sync*，返回的是Iterable对象。


// 异步生成器
// 使用async*，返回的是Stream对象。



// async gives you a Future
// async* gives you a Stream.

void main() {
  // 观察这两个方法的输出顺序
  //
  // testSync();
//   start
// --0--
// --1--
// --2--
// end
// ======the end=!!!===

  testAsync();
//   ======the end=!!!===
// start
// ---0---
// ---1---
// ---2---
// end
}
