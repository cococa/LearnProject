import "dart:collection";

void main() {
  var hashMap = HashMap<String, String>();
  hashMap["1"] = "one";
  print("--${hashMap}-");

  hashMap.entries.forEach((element) {
    print("--${element}--${element.key}");
  });

  hashMap.forEach((key, value) {
    print("--${key}--${value}");
  });
}
