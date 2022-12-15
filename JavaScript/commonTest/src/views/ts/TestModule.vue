<template>
  <div class="flex flex-1 flex-col">
    <div style="width:800px"></div>
    <div class="my-editor">
      <prism-editor
        v-model="editorCode"
        :highlight="highlighter"
        line-numbers
      ></prism-editor>
    </div>
    <button class="bg-indigo-500" @click="test1">test1</button>
    <button class="bg-indigo-500" @click="test2">test2</button>
  </div>
</template>

<script lang="ts">
import VueMarkdownIt from "vue3-markdown-it";
import * as shapes from "./lib/test-module";
// import { Person } from "./lib/test-module";
import mixinCode from "../../mixins/mixinCode";
import { ref } from "vue";
import prism from "prismjs";

export default {
  name: "xx",
  components: {
    VueMarkdownIt,
    Prism,
  },
  mixins: [mixinCode],
  data() {
    return {
      source1: `test1() {
      const t = new shapes.Shapes.Triangle();
      console.log(t);
      console.log(shapes.Shapes.age);
    },`,
      code1: "",
    };
  },
  mounted() {},
  methods: {
    test1() {
      const t = new shapes.Shapes.Triangle();
      console.log(t);
      console.log(shapes.Shapes.age);
    },
    test2() {
      // const p = new Person();
      // p.name = "123";
      // console.log(p);
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
  setup(props) {
    const a = function () {
      return function (){
        //asdas
        let aaa  = 10;
        console.log(aaa);
      }
    };
    const editorCode = ref(a.toString());
    
    const highlighter = (code) => {
      return prism.highlight(code, prism.languages.js, "javascript");
    };

    return {
      editorCode,
      highlighter,
    };
  },
};
</script>

<style></style>
