import 'dart:io';

import 'dart:math';

void readFileAsString() async {
  var file = File("./test.md");
  file.readAsString().then((value) => print("${value}"));
}

void readFileAsLines() async {
  var file = File("./test.md");

  file.rename("test.md").then((value) => print("${value}"));

  file.exists().then((fileExists) {
    if (fileExists) {
      file.readAsLines().then((value) {
        print("lines ==>${value} \n");
        print("runtimeType \n${value.runtimeType}");
      });
    }
  });
}

void listDir() {
  var dir = Directory(".");
  dir.exists().then((ext) {
    if (ext) {
      dir.list().forEach((element) {
        print("--runtimeTypes--${element.runtimeType}---${element}");
      });
    }
  });
}

void writeFileAsString({required String content}) async {
  var file = File("./test.md");
  var sink = file.openWrite();
  sink.writeln(content);
  await sink.flush();
  await sink.close();
}

void main() {
  // readFileAsString();
  //
  // readFileAsLines();
  //
  // listDir();
  writeFileAsString(content: "add new msg!!");
}
