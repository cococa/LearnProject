<template>
  <div class="flex flex-1 flex-col">
    <vue3-markdown-it :source="code" />

    <div v-for="(item, index) in codeArray" :key="index" class="item">
      <div v-if="item.msg">
        <div v-for="(citem, cindex) in item.msg.split('&&')" :key="cindex">
          {{ citem }}
        </div>
      </div>
      <!-- <vue3-markdown-it :source="item.code" /> -->
      <div class="my-editor">
        <prism-editor
          v-model="item.code"
          :highlight="highlighter"
          line-numbers
        ></prism-editor>
      </div>
      <button @click="testClick(item.methodName)">
        点击测试({{ item.methodName }})
      </button>
    </div>
  </div>
</template>

<script lang="ts">
import { ref } from "vue";
import { reactive } from "vue";
// import VueMarkdownIt from "vue3-markdown-it";
import mixinCode from "../../mixins/mixinCode";
import { Dep } from "./Dep.js";
import prism from "prismjs";

// 参考文档
// https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty
// https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Proxy
// https://blog.csdn.net/weixin_42524603/article/details/124089402



export default {
  name: "asd",
  mixins: [mixinCode],
  data() {
    return {
      code: `
      本章节对 Proxy 进行分析，
      分析了 vue3 为什么放弃 Object.defineProperty 选择了 Proxy （Reactive 用的 Proxy , Ref 用的还是 Object.defineProperty()），部分代码会设计到 vue 的响应式原理 
      并测试了 Proxy 别的强大功能，比如监听构造函数

      `,
      name: "shencocoa",
      msg_base1: "demo1 使用了 Object.defineProperty 方法",
      msg_base2: "demo2 参考了vue2 的源码，对监听对象的全部属性进行了代理",
      msg_base8: `
       base8 方法的意图是：&&
       利用Proxy 实现 AOP 功能，具体是记录了某些方法的调用时间
       `,
      msg_base9: `
       base9 方法的意图是：验证 defineProperty 和 proxy 的 key 的监听 &&
       Object.defineProperty 只能监听指定的 key 所对应的 value 值的变化，而 Proxy 可以直接监听对象的所有key
       `,
      msg_vue3ReactiveV1:
        "模仿 Vue3 响应式 版本v1 && 缺点: 监听不狗精细，回调函数没有对单独的 key 进行绑定",
    };
  },
  mounted() {},
  methods: {
    base1() {
      // let ac
      let p = {};
      let name = "";
      Object.defineProperty(p, "name", {
        enumerable: true,
        configurable: true,
        get() {
          console.log("get name");
          return name;
        },
        set(nv) {
          console.log("set name");
          name = nv;
        },
      });
      p.name = "111";
      console.log(p.name);
    },
    base2() {
      class Observer {
        value = {};
        constructor(value) {
          this.value = value;
          this.walk(this);
        }

        walk(data, value) {
          // Object.keys(data.value).forEach((key) => {
          const keys = Object.keys(data.value);
          for (var i = 0; i < keys.length; i++) {
            const key = keys[i];
            this.defineReactive(this, key);
          }
        }

        defineReactive(data, key, val) {
          console.log("walk key =>> ", key);
          val = this.value[key];
          Object.defineProperty(data, key, {
            enumerable: true,
            configurable: true,
            get() {
              console.log("get" + key);
              return val;
            },
            set(newValue) {
              if (newValue === val) {
                return;
              }
              console.log("set" + key + " " + val + "==>" + newValue);
              val = newValue;
            },
          });
        }
      }

      let ob = new Observer({
        name: "shencocoa",
        age: 18,
        langs: ["swift", "java"],
      });

      ob.name = "123";
      console.log(ob.name);

      console.log(ob.age);
      // 数组的set方法没有触发 , ob.langs = [1,2] , 这样才会触发
      ob.langs.push("python");
      // 数组的get 触发
      console.log(ob.langs);
    },
    base3() {
      const handler = {
        get: function (obj, prop) {
          return prop in obj ? obj[prop] : 37;
        },
      };
      let marker = "定义Proxy 对象";
      const p = new Proxy({}, handler);
      p.a = 1;
      p.b = undefined;

      marker = "";
      console.log(p.a, p.b); // 1, undefined
      console.log("c" in p, p.c); // false, 37
      console.log(p.aaa); // 37
    },
    base4() {
      let target = { a: 1 };
      let p = new Proxy(target, {});
      p.a = 37; // 操作转发到目标
      console.log(target.a); // 37. 操作已经被正确地转发
    },
    base5() {
      //  使用Proxy 实现数据验证
      const dataValidator = {
        set(obj, prop, value) {
          if (prop === "age") {
            if (!Number.isInteger(value)) {
              throw new TypeError("The age is not an integer");
            }
          }
          obj[prop] = value;
          return true;
        },
      };
      const p = new Proxy({}, dataValidator);

      p.age = 12;
      console.log(p.age); // 12
      p.age = "十八"; // TypeError: The age is not an integer
    },
    base6() {
      //handler.construct() 方法用于拦截new 操作符. 为了使new操作符在生成的Proxy对象上生效，用于初始化代理的目标对象自身必须具有[[Construct]]内部方法（即 new target 必须是有效的）。
      const constructorHandler = {
        construct(target, args) {
          console.log("constructorHandler log", target, args);
          return new target(...args);
        },
      };
      const ConstructProxy = new Proxy(function (x, y) {
        this.x = x;
        this.y = y;
      }, constructorHandler);

      new ConstructProxy(); // constructorHandler { x: undefined, y: undefined } [].
    },
    base7() {
      const handler = {
        /**
         * target 指向目标对象  target必须是可被调用的。也就是说，它必须是一个函数对象。
         * thisArg 被调用时的上下文对象。
         * argumentsList 被调用时的参数数组。
         */
        apply(target, thisArg, argumentsList) {
          console.log(`Calculate sum: ${thisArg}  ${argumentsList}`);
          return target.apply(thisArg, argumentsList);
        },
      };

      function sum(a, b) {
        return a + b;
      }
      const p = new Proxy(sum, handler);

      console.log(sum(1, 2)); // 3
      console.log(p(1, 2));

      // 上面的是直接对一个方法进行代理，这里想验证下对一个类的方法进行代理，貌似不行啊
      //  target必须是可被调用的。也就是说，它必须是一个函数对象。
      // class Person {
      //   sum(a, b) {
      //     return a + b;
      //   }
      // }
      // const p1 = new Proxy(new Person(), handler);

      // console.log(p1.sum(1, 2));
    },
    base8() {
      // var propertyNames = Object.getOwnPropertyNames(Person.prototype);
      // console.log(propertyNames);

      // 模拟对方法数组进行代理
      function sum(a, b) {
        for (var i = 0; i < 1e3; i++) {
          console.log(a + b);
        }
        return a + b;
      }

      const list = [sum];

      const calcMethodUseTimehandler = {
        apply(target, thisArg, argumentsList) {
          const currentTime = new Date().getTime();
          const result = target.apply(thisArg, argumentsList);
          console.log(
            `Calculate target use : ${new Date().getTime() - currentTime} ms`
          );
          return result;
        },
      };

      list.forEach((element) => {
        const p = new Proxy(element, calcMethodUseTimehandler);
        console.log(p(1, 2));
      });
    },
    base9() {
      let obj = {};
      let handler = {
        get: function (target, property, receiver) {
          console.log("base9 get", target);
          return Reflect.get(target, property, receiver);
        },
        set: function (target, key, value, receiver) {
          console.log("base9 set", value);
          return Reflect.set(target, key, value, receiver);
        },
      };
      const objProxy = new Proxy(obj, handler);
      objProxy.name = "123";
      console.log(objProxy.name);
    },
    vue3ReactiveV1() {
      let obj = {};
      const fnList = new Set<Function>();
      function reactive() {
        console.log("reactive objProxy name is: ", objProxy.name);
      }
      let handler = {
        get: function (target, property, receiver) {
          // console.log("vue3ReactiveV1 get", target);
          fnList.add(reactive);
          return Reflect.get(target, property, receiver);
        },
        set: function (target, key, value, receiver) {
          const res = Reflect.set(target, key, value, receiver);
          fnList.forEach((fn) => fn());
          // console.log("vue3ReactiveV1 set", value);
          return res;
        },
      };
      const objProxy = new Proxy(obj, handler);
      objProxy.name = "123";
      console.log(objProxy.name);
      setTimeout(() => {
        objProxy.name = "2222"; // 触发 reactive
      }, 2000);
    },
  },

  setup(props) {
    const x = ref(0);
    const y = reactive({
      a: 1,
      b: 2,
    });
    console.log(x);
    console.log(y);
    const highlighter = (code) => {
      return prism.highlight(code, prism.languages.js, "javascript");
    };
    return {
      highlighter,
      x,
    };
  },
};
</script>

<style scoped>
.item {
  margin-bottom: 10px;
}
</style>
