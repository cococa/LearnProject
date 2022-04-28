<template>
  <div class="flex flex-1 flex-col">
    <div>{{ x }}</div>
    <div v-for="(item, index) in codeArray" :key="index" class="item">
      <p v-if="item.msg">{{ item.msg }}</p>
      <vue3-markdown-it :source="item.code" />
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
// 参考文档
// https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty
// https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Proxy

export default {
  name: "asd",
  
  mixins: [mixinCode],
  data() {
    return {
      name: "shencocoa",
      msg_base8:
        "base8 方法的意图是：<br/> 利用Proxy 实现 AOP 功能，具体是记录了某些方法的调用时间",
    };
  },
  mounted() {},
  methods: {
    base1() {
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
      const dep = new Dep({ name: "cocoa" });
      console.log(dep.id, dep.name);
    },
    xx() {
      location.reload() 
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

    return {
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
