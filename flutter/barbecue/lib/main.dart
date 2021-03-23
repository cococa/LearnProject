import 'package:barbecue/Hero1Demo.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

List<VItem> _list = [
  VItem(
    tag: "阿国请的烤肉tag1",
    src:
        "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
  ),
  VItem(
    tag: "阿国请的烤肉tag2",
    src:
        "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
  ),
  VItem(
    tag: "阿国请的烤肉tag3",
    src:
        "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
  ),
  VItem(
    tag: "阿国请的烤肉tag4",
    src:
        "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
  ),
  VItem(
    tag: "阿国请的烤肉tag5",
    src:
        "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
  ),
  VItem(
    tag: "阿国请的烤肉tag6",
    src:
        "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
  ),
  VItem(
    tag: "阿国请的烤肉tag7",
    src:
        "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
  ),
  VItem(
    tag: "阿国请的烤肉tag8",
    src:
        "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
  ),
  VItem(
    tag: "阿国请的烤肉tag9",
    src:
        "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
  ),
];

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: ''),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

ListView buildHItem(Size size) {
  var listView = ListView.builder(
      itemCount: _list.length,
      scrollDirection: Axis.horizontal,
      itemBuilder: (BuildContext context, int index) {
        var item = _list[index];

        return Container(
            width: size.width * 0.6,
            height: size.width * 0.4,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Container(
                    margin: EdgeInsets.only(top: 10, left: 10),
                    child: ClipRRect(
                        borderRadius: BorderRadius.circular(12),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Image(
                                width: size.width * 0.6,
                                height: size.width * 0.4,
                                fit: BoxFit.cover,
                                image: NetworkImage(item.src)),
                            Padding(
                              padding:
                                  EdgeInsets.only(top: 6, left: 10, bottom: 6),
                              child: Text("阿国请的烤肉！"),
                            )
                          ],
                        )),
                    decoration: BoxDecoration(
                        color: Colors.white,
                        boxShadow: [
                          BoxShadow(
                              color: Colors.black12,
                              blurRadius: 10,
                              offset: Offset(1, 5))
                        ],
                        borderRadius: BorderRadius.all(Radius.circular(12)))),
              ],
            ));
      });

  return listView;

  // List<Widget> result = [];
  // list.forEach((element) {
  //   var image = Padding(
  //       padding: EdgeInsets.all(0),
  //       child: Column(
  //         crossAxisAlignment: CrossAxisAlignment.start,
  //         children: [
  //           Container(
  //               margin: EdgeInsets.only(top: 10, left: 10),
  //               child: ClipRRect(
  //                   borderRadius: BorderRadius.circular(12),
  //                   child: Column(
  //                     crossAxisAlignment: CrossAxisAlignment.start,
  //                     children: [
  //                       Image(
  //                           width: size.width * 0.6,
  //                           height: size.width * 0.4,
  //                           fit: BoxFit.cover,
  //                           image: NetworkImage(element)),
  //                       Padding(
  //                         padding: EdgeInsets.only(top: 6, left: 10, bottom: 6),
  //                         child: Text("阿国请的烤肉！"),
  //                       )
  //                     ],
  //                   )),
  //               decoration: BoxDecoration(
  //                   color: Colors.white,
  //                   boxShadow: [
  //                     BoxShadow(
  //                         color: Colors.black12,
  //                         blurRadius: 10,
  //                         offset: Offset(1, 5))
  //                   ],
  //                   borderRadius: BorderRadius.all(Radius.circular(12)))),
  //         ],
  //       ));
  //
  //   result.add(image);
  // });
  // return result;
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;
    var c = Colors.green;

    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
        backgroundColor: Colors.green,
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            Container(
              width: double.infinity,
              height: 150,
              child: Stack(
                alignment: AlignmentDirectional.center,
                children: [
                  Container(
                      margin: EdgeInsets.only(bottom: 30),
                      decoration: BoxDecoration(
                          color: Colors.green,
                          borderRadius: BorderRadius.only(
                            bottomLeft: Radius.circular((20.0)),
                            bottomRight: Radius.circular((20.0)),
                          ))),
                  Positioned(
                      bottom: 10,
                      child: Container(
                          height: 50,
                          width: size.width * 0.8,
                          padding: EdgeInsets.only(left: 10, right: 10),
                          child: Row(children: [
                            Expanded(
                                child: TextField(
                              decoration: InputDecoration(
                                  hintText: "search", border: InputBorder.none),
                            ))
                          ]),
                          decoration: BoxDecoration(
                              color: Colors.white,
                              boxShadow: [
                                BoxShadow(
                                    color: Colors.black45,
                                    blurRadius: 50,
                                    offset: Offset(1, 10))
                              ],
                              borderRadius:
                                  BorderRadius.all(Radius.circular((15.0)))))),
                ],
              ),
            ),
            Padding(
                padding: EdgeInsets.only(top: 20, left: 10, right: 10),
                child: Row(
                  children: [
                    Stack(
                      children: [
                        Positioned(
                            left: 1,
                            bottom: 2,
                            child: Container(
                                height: 7,
                                width: 110,
                                decoration: BoxDecoration(
                                    color: c,
                                    borderRadius: BorderRadius.all(
                                        Radius.circular((15.0)))))),
                        Text(
                          "Recommand",
                          style: TextStyle(fontSize: 20),
                        )
                      ],
                    )
                  ],
                )),
            Container(
              width: size.width,
              height: size.width * 0.58,
              child: buildHItem(size),
            ),
            GridView(
              physics: new NeverScrollableScrollPhysics(),
              shrinkWrap: true,
              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 2, //横轴三个子widget
                  childAspectRatio: 0.8),
              children: buildVItem(size, context),
            ),
          ],
        ),
      ),
    );
  }
}

class VItem {
  String tag;
  String src;
  VItem({this.tag, this.src});
}
//
// List<Widget> buildVItem(Size size, BuildContext context) {
//   List<VItem> list = [
//     VItem(
//       tag: "tag1",
//       src:
//           "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
//     ),
//     VItem(
//       tag: "tag2",
//       src:
//           "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
//     ),
//     VItem(
//       tag: "tag3",
//       src:
//           "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
//     ),
//     VItem(
//       tag: "tag4",
//       src:
//           "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
//     ),
//     VItem(
//       tag: "tag5",
//       src:
//           "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
//     ),
//     VItem(
//       tag: "tag6",
//       src:
//           "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
//     ),
//     VItem(
//       tag: "tag7",
//       src:
//           "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
//     ),
//     VItem(
//       tag: "tag8",
//       src:
//           "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
//     ),
//     VItem(
//       tag: "tag9",
//       src:
//           "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
//     ),
//   ];
//   List<Widget> result = [];
//   var index = 0;
//   list.forEach((element) {
//     var image = Container(
//         child: InkWell(
//           onTap: () {
//             Navigator.push(
//                 context,
//                 new MaterialPageRoute(
//                     builder: (context) => Hero1Demo(tag: element.tag)));
//           },
//           child: Hero(
//             tag: element.tag,
//             child: ClipRRect(
//                 borderRadius: BorderRadius.circular(12),
//                 child: Image(
//                     width: size.width * 0.46,
//                     height: size.width * 0.46,
//                     fit: BoxFit.cover,
//                     image: NetworkImage(element.src)),),
//           ),
//         ),
//         decoration: BoxDecoration(
//             color: Colors.white,
//             boxShadow: [
//               BoxShadow(
//                   color: Colors.black12, blurRadius: 10, offset: Offset(1, 5))
//             ],
//             borderRadius: BorderRadius.all(Radius.circular(12))));
//
//     result.add(image);
//     index++;
//   });
//   return result;
// }

List<Widget> buildVItem(Size size, BuildContext context) {
  List<VItem> list = [
    VItem(
      tag: "阿国请的烤肉tag1",
      src:
          "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
    ),
    VItem(
      tag: "阿国请的烤肉tag2",
      src:
          "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
    ),
    VItem(
      tag: "阿国请的烤肉tag3",
      src:
          "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
    ),
    VItem(
      tag: "阿国请的烤肉tag4",
      src:
          "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
    ),
    VItem(
      tag: "阿国请的烤肉tag5",
      src:
          "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
    ),
    VItem(
      tag: "阿国请的烤肉tag6",
      src:
          "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
    ),
    VItem(
      tag: "阿国请的烤肉tag7",
      src:
          "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
    ),
    VItem(
      tag: "阿国请的烤肉tag8",
      src:
          "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
    ),
    VItem(
      tag: "阿国请的烤肉tag9",
      src:
          "https://img.meituan.net/msmerchant/7f01bfcd62f4b61da675c536b085e3d3444561.jpg%40340w_255h_1e_1c_1l%7Cwatermark%3D0",
    ),
  ];
  List<Widget> result = [];
  var index = 0;
  list.forEach((element) {
    var image = Padding(
        padding: EdgeInsets.all(0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
                margin: EdgeInsets.only(top: 10, left: size.width * 0.03),
                width: size.width * 0.46,
                child: InkWell(
                  onTap: () {
                    Navigator.push(
                        context,
                        new MaterialPageRoute(
                            builder: (context) => Hero1Demo(tag: element.tag)));
                  },
                  child: Hero(
                    tag: element.tag,
                    child: ClipRRect(
                        borderRadius: BorderRadius.circular(12),
                        child: Column(
                          children: [
                            Image(
                                width: size.width * 0.46,
                                height: size.width * 0.46,
                                fit: BoxFit.cover,
                                image: NetworkImage(element.src)),
                            Container(
                              height: 32,
                              padding:
                                  EdgeInsets.only(top: 6, left: 10, bottom: 6),
                              child: Text(
                                "阿国请的烤肉！tag${index}",
                                style: TextStyle(
                                    color: Colors.black26, fontSize: 14),
                              ),
                            )
                          ],
                        )),
                  ),
                ),
                decoration: BoxDecoration(
                    color: Colors.white,
                    boxShadow: [
                      BoxShadow(
                          color: Colors.black12,
                          blurRadius: 10,
                          offset: Offset(1, 5))
                    ],
                    borderRadius: BorderRadius.all(Radius.circular(12)))),
          ],
        ));

    result.add(image);
    index++;
  });
  return result;
}
