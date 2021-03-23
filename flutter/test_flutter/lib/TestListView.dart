import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:flutter_cache_manager/flutter_cache_manager.dart';

class TestListView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    // throw UnimplementedError();
    return Scaffold(
      appBar: AppBar(
          title: Text("this is title"),
          actions: [FlatButton(onPressed: () {}, child: Text("add"))]),
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
  @override
  Widget build(BuildContext context) {
    // DefaultTextStyle.of(context).
    return Container(
        child: ListView.builder(
            itemCount: 20,
            itemExtent: 65,
            physics: BouncingScrollPhysics(),
            itemBuilder: (context, index) {
              return Container(
                color: Colors.black12,
                padding: EdgeInsets.all(20),
                child: Row(
                  children: [
                    Text(
                      "${index}",
                      style: TextStyle(
                          fontSize: 25, backgroundColor: Colors.green),
                    ),
                    CachedNetworkImage(
                      imageUrl: "http://via.placeholder.com/350x150",
                      placeholder: (context, url) =>
                          CircularProgressIndicator(),
                      errorWidget: (context, url, error) => Icon(Icons.error),
                    ),
                  ],
                ),
              );
            }));
  }
}
