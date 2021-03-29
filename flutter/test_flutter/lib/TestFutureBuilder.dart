import 'dart:ui';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

class TestFutureBuilder extends StatelessWidget {
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

Future<String> mockRemote() {
  return Future.delayed(
      Duration(seconds: 3), () => "this info from mockRemote server!!");
}

Stream<num> mockStreamRemote() {
  return Stream.periodic(Duration(seconds: 1), (i) => i).take(10).map((event) => event * event);
}

Future<String> getBaiduPage() async{
    try {
      var response = await Dio().get('http://www.baidu.com');
      return response.data.toString();
    } catch (e) {
      return e.toString();
    }
}



class _ContentState extends State<Content> {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: [
          Text("FutureBuilder"),
          FutureBuilder(
              future: mockRemote(),
              builder: (BuildContext context, AsyncSnapshot<String> snapshot) {
                if (snapshot.connectionState == ConnectionState.done) {
                  return Center(
                    child: Text("${snapshot.data}----"),
                  );
                } else if (snapshot.connectionState == ConnectionState.waiting) {
                  return Center(
                    child: Text("waiting"),
                  );
                } else {
                  return Center(
                    child: Text("loading"),
                  );
                }
              }),
          Padding(
            padding: EdgeInsets.only(top: 10),
            child: Column(
              children: [
                Text("StreamBuilder"),
                StreamBuilder(
                    stream: mockStreamRemote(),
                    builder: (BuildContext context, AsyncSnapshot snapshot) {
                      if (snapshot.connectionState == ConnectionState.done) {
                        return Text("complete",style: TextStyle(color: Colors.red),);
                      } else {
                        return Text("mockStreamRemote--${snapshot.data}");
                      }
                    })
              ],
            ),
          ),
          Padding( padding: EdgeInsets.only(top: 30),
            child: Column(
              children: [
                // TextButton(onPressed: ()=> getBaiduPage(), child: Text("GET BAIDU PAGE"))

                FutureBuilder(future: getBaiduPage(),
                  builder: (BuildContext context, AsyncSnapshot<String> snapshot){
                    if (snapshot.connectionState == ConnectionState.done) {
                      return Center(
                        child: Text("${snapshot.data}----",maxLines: 2)
                      );
                    }
                  },

                )
              ],
            ),
          )
        ],
      ),
    );
  }
}
