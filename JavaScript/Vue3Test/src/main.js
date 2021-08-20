import { createApp} from 'vue'
// import { createApp } from 'vue/dist/vue.esm-bundler';
import App from './App.vue'
import Home from './pages/Home.vue'
import TestSetup from './pages/TestSetup.vue'
import TestProvideInject from './pages/TestProvideInject.vue'
import TestRenderFunction  from './pages/TestRenderFunction.vue'
// import  Vue from 'vue';

import './index.css'
import {createRouter,createWebHashHistory} from 'vue-router'

import { createStore } from 'vuex'

// 手动声明 state 类型
const store = createStore({
  state: {
    count: 111
  }
})

// 2. 定义一些路由
// 每个路由都需要映射到一个组件。
// 我们后面再讨论嵌套路由。
const routes = [
  { path: '/', name:"/",component: Home },
  { path: '/TestSetup', name:"TestSetup", component: TestSetup },
  { path:'/TestProvideInject',name:"TestProvideInject",component:TestProvideInject},
  { path:'/TestRenderFunction',name:"TestRenderFunction",component:TestRenderFunction}

]

const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
  })
  

//   router.beforeEach((to, from) => {
//     console.log(to);
//     console.log(from);
//     return true
//   })


  
const app = createApp(App);
app.use(router);
app.use(store)
app.mount('#app');


// createApp(App).mount('#app')



