import {  createApp } from 'vue'
import App from './App.vue'
import {createRouter,createWebHashHistory} from 'vue-router';
import c2 from './components/c2.vue'


const About = { template: '<div>About</div>' }

// 2. 定义一些路由
// 每个路由都需要映射到一个组件。
// 我们后面再讨论嵌套路由。
const routes = [
  { path: '/c2', component: c2 },
  { path: '/about', component: About },
]

const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
  })
  
  // 5. 创建并挂载根实例
  const app = createApp(App)
  //确保 _use_ 路由实例使
  //整个应用支持路由。
  app.use(router)
  
  app.mount('#app')



// createApp(App).mount('#app')
