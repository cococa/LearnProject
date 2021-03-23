import 'dart:io';
import 'dart:convert';

extension StringListener on Stream {
  void printEvent() {
    this.listen((event) {
      print("--${event}--type=${event.runtimeType}");
    }).onDone(() {
      print("stream done!");
    });
  }
}

Future<String> f1() async {
  await Future.delayed(Duration(seconds: 3));
  return "123";
}

void test1() {
  Stream.fromFuture(f1()).printEvent();
}

void test2() {
  var futures = [f1(), f1(), f1()];
  Stream.fromFutures(futures).printEvent();
}

void test3() {
  const iterators = [
    1,
    2,
    true,
    2000.0,
    "this is string!",
    [1, 2, 3]
  ];

  Stream.fromIterable(iterators).printEvent();
}

// take
void test4() {
  Stream.periodic(Duration(seconds: 1), (data) => data).take(3).printEvent();
}

//takeWhile
void test5() {
  Stream.periodic(Duration(seconds: 1), (data) => data)
      .takeWhile((data) => data > 3)
      .printEvent();
}

//where
void test6() {
  Stream.periodic(Duration(seconds: 1), (data) => data)
      .where((data) => data % 2 == 0)
      .take(3)
      .printEvent();
}

//where
void test7() {
  Stream.periodic(Duration(seconds: 1), (data) => data)
      .map((data) => data.toString())
      .take(3)
      .printEvent();
}

//
void test8() async {
  var set = await Stream.periodic(Duration(seconds: 1), (data) => data)
      .map((data) => data.toString())
      .take(3)
      .toSet();
  print("==${set}=");
}

void testReadFile() async {
  var f = File("bool.dart");
  f.exists().then((v) {
    print("--${v}--");
  });

  var exists = await f.exists();
  print("--unasnyc-${exists}--");

  Stream<String> lines =
      utf8.decoder.bind(f.openRead()).transform(LineSplitter());

  await for (var line in lines) {
    print(line);
  }
}

void main() async {
  // test1().then((value) => print(value)).catchError((err) => print("${err}"));

  test8();
}
