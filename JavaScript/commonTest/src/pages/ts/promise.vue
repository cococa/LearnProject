<template>
  <div class="flex flex-1 flex-col">
    <!-- <vue3-markdown-it :source="source" />
    <vue3-markdown-it :source="source" /> -->
    <div>
      <button @click="testMyPromise">测试简单的MyPromise</button>
      <button @click="testPromise">测试简单的Promise</button>
    </div>

    <div>
      <button @click="testMyPromise1">测试Promise组合，MyPromise</button>
      <button @click="testPromise1">测试Promise组合，Promise</button>
    </div>
  </div>
</template>

<script lang="ts" setup>
// import VueMarkdownIt from "vue3-markdown-it";
import MyPromise from "./lib/promise";

function testPromise() {
  console.log("testPromise start");
  new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("aaaaaaaa");
    }, 3000);
  }).then((res) => {
    console.log("res", res);
  });
}
function testMyPromise() {
  console.log("testMyPromise start");
  new MyPromise((resolve, reject) => {
    setTimeout(() => {
      resolve("aaaaaaaa");
    }, 3000);
  }).then((res) => {
    console.log("res", res);
  });
}

// 测试Promise 组合
function testPromise1() {
  const time = new Date().getTime();
  console.log("testPromise start");
  new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("aaaaaaaa");
    }, 3000);
  })
    .then((res) => {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve("bbbb");
        }, 3000);
      });
    })
    .then((res) => {
      console.log("res", res , new Date().getTime() - time);
    });
}

//暂时还有问题
function testMyPromise1() {
  const time = new Date().getTime();
  console.log("testMyPromise start");
  new MyPromise((resolve, reject) => {
    setTimeout(() => {
      resolve("aaaaaaaa");
    }, 3000);
  })
    .then((res) => {
      //Promise组合时，出现问题，返回的是 MyPromise，等待解决
      return new MyPromise((resolve, reject) => {
        setTimeout(() => {
          resolve("bbbb");
        }, 3000);
      });
    })
    .then((res) => {
      console.log("res", res, new Date().getTime() - time);
    });
}

// export default {
//   name: "xx",
//   components: {
//     VueMarkdownIt,
//   },
//   data() {
//     return {
//       source: "",
//       aa: "",
//     };
//   },
//   mounted() {
//     // this.loadFile("./ts/02variable.md");
//     // new Promise((resolve, reject) => {
//     //   setTimeout(() => {
//     //     reject("123");
//     //   }, 1000);
//     // }).then(
//     //   (res) => {
//     //     console.log("res", res);
//     //   },
//     //   (err) => {
//     //     console.log("err", err);
//     //   }
//     // );
//   },
//   methods: {
//     testPromise() {
//       console.log("testPromise start");
//       new Promise((resolve, reject) => {
//         setTimeout(() => {
//           resolve("aaaaaaaa");
//         }, 3000);
//       })
//         .then(
//           (res) =>
//             new Promise((resolve, reject) => {
//               setTimeout(() => {
//                 resolve("bbbb");
//               }, 3000);
//             })
//         )
//         .then((res) => {
//           console.log("res", res);
//         });
//     },
//     testMyPromise() {
//       console.log("testMyPromise start");
//       new MyPromise((resolve, reject) => {
//         setTimeout(() => {
//           resolve("aaaaaaaa");
//         }, 3000);
//       })
//         .then(
//           (res) =>
//             new Promise((resolve, reject) => {
//               setTimeout(() => {
//                 resolve("bbbb");
//               }, 3000);
//             })
//         )
//         .then((res) => {
//           console.log("res", res);
//         });
//     },
//     loadFile(fileName) {
//       //  更新数据devInfo.txt文件接口
//       // let xhr = new XMLHttpRequest(),
//       //   okStatus = document.location.protocol === "file:" ? 0 : 200;
//       // xhr.open("GET", fileName, false); // 文件路径
//       // xhr.overrideMimeType("text/html;charset=utf-8"); //默认为utf-8
//       // xhr.send(null);
//       // this.source = xhr.responseText; //打印文件信息
//     },
//   },
//   setup(props) {},
// };
</script>

<style></style>
