import { createRouter, createWebHistory } from "vue-router";

import Home from "@/views/Home.vue";

//js
import JsIndex from "@/views/js/index.vue";
import JsObject from "@/views/js/object.vue";
import arrowFunction from "@/views/js/arrowFunction.vue";
import optional from "@/views/js/optional.vue";
import objObserver from "@/views/js/objObserver.vue";
import closure from "@/views/js/closure.vue";

//ts
import TsIndex from "@/views/ts/index.vue";
import BasicType from "@/views/ts/BasicType.vue";
import Variable from "@/views/ts/Variable.vue";
import Interfaces from "@/views/ts/Interfaces.vue";
import TestSnabbdom from "@/views/ts/TestSnabbdom.vue";
import TestModule from "@/views/ts/TestModule.vue";
import TestTypeInference from "@/views/ts/TestTypeInference.vue";
import MyPromise from "@/views/ts/promise.vue";

//vue
import VueIndex from "@/views/vue/index.vue";
import Pinia from "@/views/vue/pinia.vue";
import TestSetup from "@/views/vue/TestSetup.vue";
import TestProvideInject from "@/views/vue/TestProvideInject.vue";
import TestRenderFunction from "@/views/vue/TestRenderFunction.vue";
import TestReactive from "@/views/vue/TestReactive.vue";
import TestComposables from "@/views/vue/TestComposables.vue";
import HookArray from "@/views/vue/HookArray.vue";

import Es6Index from "@/views/es6/index.vue";
import Promise from "@/views/es6/Promise.vue";

//css
import CssIndex from "@/views/css/index.vue";
import VariableCalc from "@/views/css/VariableCalc.vue";

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
    path: "/vue/Pinia",
    name: "/Pinia",
    component: Pinia,
    meta: {
      title: "Pinia",
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
    path: "/vue/TestReactive",
    name: "TestReactive",
    component: TestReactive,
    meta: {
      title: "TestReactive",
      keepAlive: true,
    },
  },
  {
    path: "/vue/TestComposables",
    name: "TestComposables",
    component: TestComposables,
    meta: {
      title: "TestComposables",
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
    path: "/vue/HookArray",
    name: "HookArray",
    component: HookArray,
    meta: {
      title: "HookArray",
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
    path: "/ts/MyPromise",
    name: "MyPromise",
    component: MyPromise,
    meta: {
      title: "ts MyPromise",
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
    path: "/ts/TestTypeInference",
    name: "TestTypeInference",
    component: TestTypeInference,
    meta: {
      title: "ts TestTypeInference",
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
  {
    path: "/es6/index",
    name: "es6",
    component: Es6Index,
    meta: {
      title: "Es6Index",
      keepAlive: true,
    },
  },
  {
    path: "/es6/promise",
    name: "promise",
    component: Promise,
    meta: {
      title: "promise",
      keepAlive: true,
    },
  },
];

const router = createRouter({
  // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
  history: createWebHistory(import.meta.env.BASE_URL),
  routes, // `routes: routes` 的缩写
});

export default router;
