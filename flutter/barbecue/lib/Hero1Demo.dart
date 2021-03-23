import 'package:flutter/material.dart';

class Hero1Demo extends StatelessWidget {
  Hero1Demo({Key key, this.tag}) : super(key: key);

  final String tag;

  @override
  Widget build(BuildContext context) {
    var size = MediaQuery.of(context).size;
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.green,
          title: Text(tag),
        ),
        body: Container(
            alignment: Alignment.topCenter,
            child: Hero(
                tag: tag,
                child: Container(
                  child: Column(
                    children: [
                      Image(
                          width: size.width,
                          height: 200,
                          fit: BoxFit.cover,
                          image: NetworkImage(
                              "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0"))
                    ],
                  ),
                ))));
  }
}
