import { createApp } from "vue";
// import { createApp } from 'vue/dist/vue.esm-bundler';
import App from "./App.vue";

import VueMarkdownIt from "vue3-markdown-it";
import "highlight.js/styles/monokai.css";
import "./index.css";
import router from './router/index.js';

import { createStore } from "vuex";

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
app.mount("#app");
