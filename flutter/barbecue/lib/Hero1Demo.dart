import 'package:flutter/material.dart';

class Hero1Demo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Container(
          alignment: Alignment.topCenter,
          child: Hero(
            tag: 'hero',
            child: Container(

            ),
          )),
    );
  }
}
