<template>
  <div id="app">
    <img src="./assets/logo.png" />
    <div>{{ cc_count }}</div>
    <h1>{{ msg }}</h1>
    <button @click="changeCount">changeCount</button>


    <div @click="test1">test1</div>

    <button @click="test2">test2</button>
    <div id="container">
      <span>A</span>
      <span>C</span>
      <span>E</span>
      <span>B</span>
    </div>

    <!-- <ul>
      <li><a href="https://vuejs.org" target="_blank">Core Docs</a></li>
      <li><a href="https://forum.vuejs.org" target="_blank">Forum</a></li>
      <li>
        <a href="https://chat.vuejs.org" target="_blank">Community Chat</a>
      </li>
      <li><a href="https://twitter.com/vuejs" target="_blank">Twitter</a></li>
    </ul> -->
  </div>
</template>

<script>

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
  name: "app",
  data() {
    return {
      cc_count: 1,
      msg: "Welcome to Your Vue.js App"
    };
  },
  watch:{
      // cc_count: function(newValue, oldValue) {
      //   console.log(newValue, oldValue);
      // }
  },
  created() {
    console.log("created");
  },
  methods: {
    changeCount() {
      this.cc_count++;
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

      // const vnode = h("div#container.two.classes", { on: { click: someFn } }, [
      //   h("span", { 
      //     style: { fontWeight: "bold" },
      //     hook :{
      //       insert(vnode) {
      //         console.log("insert"+ JSON.stringify(vnode));
      //       }
      //     }
      //   }, "This is bold"),
      //   " and this is just normal text",
      //   h("a", { props: { href: "/foo" } }, "I'll take you places!"),
      // ]);
      // // Patch into empty DOM element – this modifies the DOM as a side effect
      // patch(container, vnode);

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
    test2() {
      const patch = init([
        // Init patch function with chosen modules
        classModule, // makes it easy to toggle classes
        propsModule, // for setting properties on DOM elements
        styleModule, // handles styling on elements with support for animations
        eventListenersModule, // attaches event listeners
      ]);

      const container = document.getElementById("container");

      // const vnode = h("div#container.two.classes", { on: { click: someFn } }, [
      //   h("span", {}, "A"),
      //   h("span", {}, "B"),
      //   h("span", {}, "C"),
      //   h("span", {}, "D"),
      //   h("span", {}, "E"),
      // ]);
      // // Patch into empty DOM element – this modifies the DOM as a side effect
      // patch(container, vnode);

      const newVnode = h("div#container", { on: { click: someFn } }, [
        h("span", {}, "A"),
        h("span", {}, "C"),
        h("span", {}, "B"),
        h("span", {}, "D"),
        h("span", {}, "E"),
      ]);
      // Second `patch` invocation
      const vvnode = patch(container, newVnode); // Snabbdom efficiently updates the old view to the new state
      console.log(vvnode);

    },
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1,
h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
