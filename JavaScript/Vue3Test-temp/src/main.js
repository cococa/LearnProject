import { createApp } from "vue";
// import { createApp } from 'vue/dist/vue.esm-bundler';
import App from "./App.vue";

import VueMarkdownIt from "vue3-markdown-it";
import "highlight.js/styles/monokai.css";
import "./index.css";
import router from './router/index.js';

import { PrismEditor } from 'vue-prism-editor';
import 'vue-prism-editor/dist/prismeditor.min.css'; // import the styles somewhere

// import highlighting library (you can use any library you want just return html string)
import prism from "prismjs";
import "prismjs/themes/prism-tomorrow.css"; // import syntax highlighting styles


import { createStore } from "vuex";

import './util/CCArrayExt.js'


import VConsole from 'vconsole';
const vConsole = new VConsole();


// 手动声明 state 类型
const store = createStore({
  state: {
    count: 111,
  },
});




//   router.beforeEach((to, from) => {
//     console.log(to);
//     console.log(from);
//     return true
//   })

const app = createApp(App);
app.use(router);
app.use(store);
app.use(VueMarkdownIt);
app.use(prism)
app.component('PrismEditor',PrismEditor)
app.mount("#app");

// app.prototype.$prism = prism




