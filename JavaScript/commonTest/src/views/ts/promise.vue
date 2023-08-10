<template>
  <div class="flex flex-1 flex-col">
    <vue3-markdown-it :source="source" />
    <vue3-markdown-it :source="source" />
    <button @click="testMyPromise">testMyPromise</button>
    <button @click="testPromise">testPromise</button>
  </div>
</template>

<script lang="ts">
import VueMarkdownIt from "vue3-markdown-it";
import MyPromise from "./lib/promise";

export default {
  name: "xx",
  components: {
    VueMarkdownIt,
  },
  data() {
    return {
      source: "",
      aa: "",
    };
  },
  mounted() {
    this.loadFile("./ts/02variable.md");

    // new Promise((resolve, reject) => {
    //   setTimeout(() => {
    //     reject("123");
    //   }, 1000);
    // }).then(
    //   (res) => {
    //     console.log("res", res);
    //   },
    //   (err) => {
    //     console.log("err", err);
    //   }
    // );
  },
  methods: {
    testPromise() {
      console.log("testPromise start");
      new Promise((resolve, reject) => {
        resolve("123");
      })
        .then(
          (res) =>
            new Promise((resolve, reject) => {
              resolve("222");
            })
        )
        .then((res) => {
          console.log("res", res);
        });
    },
    testMyPromise() {
      console.log("testMyPromise start");
      new MyPromise((resolve, reject) => {
        setTimeout(() => {
          resolve("111");
        }, 1000);
        // resolve("111");
      })
        .then(
          (v: any) => {
            console.log("then1 f1", v);
            return new MyPromise((resolve, reject) => {
              setTimeout(() => {
                resolve("222");
              }, 2000);
            });
          },
          (err: any) => {
            console.log("then1 f2", err);
          }
        )
        .then(
          (v: any) => {
            console.log("then2 f1", v);
          },
          (err: any) => {
            console.log("then2 f2", err);
          }
        );
    },
    loadFile(fileName) {
      //  更新数据devInfo.txt文件接口
      let xhr = new XMLHttpRequest(),
        okStatus = document.location.protocol === "file:" ? 0 : 200;
      xhr.open("GET", fileName, false); // 文件路径
      xhr.overrideMimeType("text/html;charset=utf-8"); //默认为utf-8
      xhr.send(null);
      this.source = xhr.responseText; //打印文件信息
    },
  },
  setup(props) {},
};
</script>

<style></style>
