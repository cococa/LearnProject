import { createApp } from "vue";
import { createPinia } from "pinia";
import WebSocket, { WebSocketServer } from "ws";
import App from "./App.vue";
import router from "./router/index";

import "element-plus/dist/index.css";
import "./assets/main.css";

import ElementPlus from "element-plus";

const app = createApp(App);

// function log(msg) {
//   console.log(msg);
// }
// window.$log = log;

app.use(createPinia());
app.use(router);
app.use(ElementPlus);

app.mount("#app");
