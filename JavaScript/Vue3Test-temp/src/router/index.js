import Home from "../pages/Home.vue";

//js
import JsIndex from "../pages/js/index.vue";
import JsObject from "../pages/js/object.vue";
import arrowFunction from "../pages/js/arrowFunction.vue";
import optional from "../pages/js/optional.vue";
import objObserver from "../pages/js/objObserver.vue";
import closure from "../pages/js/closure.vue";

//ts
import TsIndex from "../pages/ts/index.vue";
import BasicType from "../pages/ts/BasicType.vue";
import Variable from "../pages/ts/Variable.vue";
import Interfaces from "../pages/ts/Interfaces.vue";
import TestSnabbdom from "../pages/ts/TestSnabbdom.vue";
import TestModule from "../pages/ts/TestModule.vue";

//vue
import VueIndex from "../pages/vue/index.vue";
import TestSetup from "../pages/vue/TestSetup.vue";
import TestProvideInject from "../pages/vue/TestProvideInject.vue";
import TestRenderFunction from "../pages/vue/TestRenderFunction.vue";

//css
import CssIndex from "../pages/css/index.vue";
import VariableCalc from "../pages/css/VariableCalc.vue";

import { createRouter, createWebHashHistory } from "vue-router";

// 2. 定义一些路由
// 每个路由都需要映射到一个组件。
// 我们后面再讨论嵌套路由。
const routes = [
  { path: "/", name: "/", component: Home },
  { path: "/TestSetup", name: "TestSetup", component: TestSetup },
  {
    path: "/vue/index",
    name: "vue",
    component: VueIndex,
    meta: {
      title: "Vue3",
      keepAlive: true,
    },
  },
  {
    path: "/vue/TestProvideInject",
    name: "/TestProvideInject",
    component: TestProvideInject,
    meta: {
      title: "TestProvideInject",
      keepAlive: true,
    },
  },
  {
    path: "/vue/TestRenderFunction",
    name: "TestRenderFunction",
    component: TestRenderFunction,
    meta: {
      title: "TestRenderFunction",
      keepAlive: true,
    },
  },
  {
    path: "/vue/TestSetup",
    name: "TestSetup",
    component: TestSetup,
    meta: {
      title: "TestSetup",
      keepAlive: true,
    },
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
    path: "/ts/Interfaces",
    name: "Interfaces",
    component: Interfaces,
    meta: {
      title: "ts Interfaces",
      keepAlive: true,
    },
  },
  {
    path: "/ts/TestSnabbdom",
    name: "TestSnabbdom",
    component: TestSnabbdom,
    meta: {
      title: "ts TestSnabbdom",
      keepAlive: true,
    },
  },
  {
    path: "/ts/TestModule",
    name: "TestModule",
    component: TestModule,
    meta: {
      title: "ts TestModule",
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
  {
    path: "/js/objObserver",
    name: "objObserver",
    component: objObserver,
    meta: {
      title: "js objObserver",
      keepAlive: true,
    },
  },
  {
    path: "/js/closure",
    name: "closure",
    component: closure,
    meta: {
      title: "js closure",
      keepAlive: true,
    },
  },
  {
    path: "/css/index",
    name: "css",
    component: CssIndex,
    meta: {
      title: "css",
      keepAlive: true,
    },
  },
  {
    path: "/css/variable-calc",
    name: "variable-calc",
    component: VariableCalc,
    meta: {
      title: "css variable-calc",
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
