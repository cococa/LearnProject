
import Home from "../pages/Home.vue";

//js
import JsIndex from "../pages/js/index.vue";
import JsObject from "../pages/js/object.vue";
import arrowFunction from "../pages/js/arrowFunction.vue";
import optional from "../pages/js/optional.vue";

//ts
import TsIndex from "../pages/ts/index.vue";
import BasicType from "../pages/ts/BasicType.vue";
import Variable from "../pages/ts/Variable.vue";

//vue
import TestSetup from "../pages/vue/TestSetup.vue";
import TestProvideInject from "../pages/vue/TestProvideInject.vue";
import TestRenderFunction from "../pages/vue/TestRenderFunction.vue";


import { createRouter, createWebHashHistory } from "vue-router";

// 2. 定义一些路由
// 每个路由都需要映射到一个组件。
// 我们后面再讨论嵌套路由。
const routes = [
  { path: "/", name: "/", component: Home },
  { path: "/TestSetup", name: "TestSetup", component: TestSetup },
  {
    path: "/TestProvideInject",
    name: "TestProvideInject",
    component: TestProvideInject,
  },
  {
    path: "/TestRenderFunction",
    name: "TestRenderFunction",
    component: TestRenderFunction,
  },
  {
    path: "/ts/index",
    name: "ts",
    component: TsIndex,
    meta: {
      title: "TypeScript",
      keepAlive: true,
    },
  },
  {
    path: "/ts/BasicType",
    name: "BasicType",
    component: BasicType,
    meta: {
      title: "ts BasicType",
      keepAlive: true,
    },
  },
  {
    path: "/ts/Variable",
    name: "Variable",
    component: Variable,
    meta: {
      title: "ts Variable",
      keepAlive: true,
    },
  },
  {
    path: "/js/index",
    name: "js",
    component: JsIndex,
    meta: {
      title: "JavaScript",
      keepAlive: true,
    },
  },
  {
    path: "/js/object",
    name: "JsObject",
    component: JsObject,
    meta: {
      title: "jsObject 相关",
      keepAlive: true,
    },
  },

  {
    path: "/js/arrowFunction",
    name: "arrowFunction",
    component: arrowFunction,
    meta: {
      title: "js 箭头函数",
      keepAlive: true,
    },
  },
  {
    path: "/js/optional",
    name: "optional",
    component: optional,
    meta: {
      title: "js optional",
      keepAlive: true,
    },
  },
];

const router = createRouter({
  // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
  history: createWebHashHistory(),
  routes, // `routes: routes` 的缩写
});

export default router;
