import TestSetup from "../pages/TestSetup.vue";
import TestProvideInject from "../pages/TestProvideInject.vue";
import TestRenderFunction from "../pages/TestRenderFunction.vue";
import Home from '../pages/Home.vue'

//js
import JsIndex from "../pages/js/index.vue";
import JsObject from "../pages/js/object.vue";
import arrowFunction from "../pages/js/arrowFunction.vue";

//ts
import BasicType from "../pages/ts/BasicType.vue";
import Variable from "../pages/ts/Variable.vue";

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
  
    { path: "/ts/BasicType", name: "BasicType", component: BasicType },
    { path: "/ts/Variable", name: "Variable", component: Variable },
  
    {
      path: "/js/index",
      name: "js",
      component: JsIndex,
      meta: {
        title: "js首页",
        keepAlive: true,
      },
    },
    { path: "/js/object", name: "JsObject", component: JsObject ,meta: {
      title: "jsObject 相关",
      keepAlive: true,
    }},
    
    { path: "/js/arrowFunction", name: "arrowFunction", component: arrowFunction ,meta: {
      title: "js 箭头函数",
      keepAlive: true,
    }},

  ];
  
  const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
  });


export default router;
