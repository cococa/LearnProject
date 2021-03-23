
import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_cache_manager/flutter_cache_manager.dart';

class TestCache extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    // throw UnimplementedError();
    return Scaffold(
      appBar: AppBar(
          title: Text("this is title"),
          actions: [TextButton(onPressed: () {}, child: Text("add"))]),
      body: Content(),
    );
  }
}

class Content extends StatefulWidget {


  @override
  _ContentState createState() => _ContentState();
}

void test() {}

class _ContentState extends State<Content> {

  String file = "";

  void _downloadFile() {
    const url = 'https://blurha.sh/assets/images/img1.jpg';
    DefaultCacheManager().getSingleFile(url).then((value) {
      print(value);
      setState(() {
          file = value.absolute.path.toString();
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        // file != null ? file :
        Image.file(File(file)),
        TextButton(
            onPressed: () {
              _downloadFile();
            },
            child: Text("getImageCached"))
      ],
    );
  }
}
