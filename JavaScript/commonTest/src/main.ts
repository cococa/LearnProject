import { createApp } from "vue";
import { createPinia } from "pinia";
// import WebSocket, { WebSocketServer } from "ws";
import App from "./App.vue";
import router from "./router/index";
// import VueLuckyCanvas from "@lucky-canvas/vue";
import "element-plus/dist/index.css";
import "./assets/main.css";
import VueMarkdownIt from "vue3-markdown-it";

import ElementPlus from "element-plus";

const app = createApp(App);

// function log(msg) {
//   console.log(msg);
// }
// window.$log = log;

app.use(createPinia());
app.use(router);
app.use(ElementPlus);
// app.use(VueLuckyCanvas);
app.use(VueMarkdownIt);
app.mount("#app");
