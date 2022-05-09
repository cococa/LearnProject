<template>
  <div class="flex flex-1 flex-col">
    

    <vue3-markdown-it :source="source" />
    <vue3-markdown-it :source="source" />
    <div>
        <button @click="test1">test1</button>
        <div id="container"></div>
    </div>



  </div>
</template>

<script lang="ts">
// https://juejin.cn/post/6952332420716691486
// http://snabbdom.github.io/snabbdom/examples/reorder-animation/
import VueMarkdownIt from "vue3-markdown-it";

import {
  init,
  classModule,
  propsModule,
  styleModule,
  eventListenersModule,
  h,
} from "snabbdom";

function anotherEventHandler() {
  console.log("anotherEventHandler");
}

function someFn() {
  console.log("someFn");
}

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
  },
  methods: {
    loadFile(fileName) {
      //  更新数据devInfo.txt文件接口
      let xhr = new XMLHttpRequest(),
        okStatus = document.location.protocol === "file:" ? 0 : 200;
      xhr.open("GET", fileName, false); // 文件路径
      xhr.overrideMimeType("text/html;charset=utf-8"); //默认为utf-8
      xhr.send(null);
      this.source = xhr.responseText; //打印文件信息
    },
    test1() {
      const patch = init([
        // Init patch function with chosen modules
        classModule, // makes it easy to toggle classes
        propsModule, // for setting properties on DOM elements
        styleModule, // handles styling on elements with support for animations
        eventListenersModule, // attaches event listeners
      ]);

      const container = document.getElementById("container");

      const vnode = h("div#container.two.classes", { on: { click: someFn } }, [
        h("span", { style: { fontWeight: "bold" } }, "This is bold"),
        " and this is just normal text",
        h("a", { props: { href: "/foo" } }, "I'll take you places!"),
      ]);
      // Patch into empty DOM element – this modifies the DOM as a side effect
      patch(container, vnode);

      const newVnode = h(
        "div#container.two.classes",
        { on: { click: anotherEventHandler } },
        [
          h(
            "span",
            { style: { fontWeight: "normal", fontStyle: "italic" } },
            "This is now italic type"
          ),
          " and this is still just normal text",
          h("a", { props: { href: "/bar" } }, "I'll take you places!"),
        ]
      );
      // Second `patch` invocation
      const vvnode = patch(vnode, newVnode); // Snabbdom efficiently updates the old view to the new state
      console.log(vvnode);

    },
  },
  setup(props) {},
};
</script>

<style></style>
