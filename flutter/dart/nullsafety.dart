void main() {
  int? a = null;
  var nullWithDefault = a ?? 0;

  print("----${a}-");
  print("----${nullWithDefault}-");

  final t1 = test1(); // 可以被final 和 var 定义，不能被const 定义
  print("--${t1}--");

  //print(t1!); //Null check operator used on a null value

  print("-t1.abs----${t1?.abs()}--"); // print null

  // print("-t1.abs----${t1 as int}--");

  String? msg = null;
  if (msg != null) {
    test2(msg);
  }
  test2(msg ?? "the default mmsg");
  // test2(msg!);  不安全

  print("--this is person----");
  Person p1 = Person(name: "123");

  print("--nullsafety with collection----");
  List<String?> strList = [];
  strList.add("123");
  strList.add(null); // List<Strin> strList  则会报错
  print("--${strList}----");
}

class Person {
  final String name;
  final String? sport;

  Person({required this.name, this.sport}) {}
}

int? test1() {
  return null;
}

void test2(String? msg) {
  print("--${msg}--");
}
