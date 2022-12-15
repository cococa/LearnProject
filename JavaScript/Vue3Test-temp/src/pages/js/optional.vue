<template>
  <div class="flex flex-1 flex-col">
    <vue3-markdown-it :source="source" />

    <div v-if="userInfo && userInfo.address">{{ userInfo.address.name }}</div>
    <div>{{ userInfo && userInfo.address && userInfo.address.name }}</div>

    <div style="background-color: red">{{ userInfo?.address?.name }}</div>
    <div style="background-color: green">
      {{ userInfo?.address?.name || "default value" }}
    </div>

    <div>当 age=0 时，测试 ?? 和 ||</div>
    <div style="background-color: green">
      ??===>{{ age ?? "default value" }}
    </div>
    <div style="background-color: red">||===>{{ age || "default value" }}</div>

    <button type="button" @click="testArray">testArray</button>
  </div>
</template>

<script lang="ts">
import VueMarkdownIt from "vue3-markdown-it";
import { ArrayUtil } from "../../util/index.js";

function test() {
  return `
  \`\`\`html

  //假如我们的userInfo 对象是空，尝试在html 中直接使用下面的代码，会报错
  <div>{{userInfo.address.name}}</div>

  // 当然可以用三目运算解决，但是这里有一个更好的解决方案
  <div>{{userInfo && userInfo.address 
        && userInfo.address.name}}</div>

  // 或者这样
  <div v-if="userInfo && userInfo.address">{{userInfo.address.name}}</div>

  // 当然还有一种更加优雅的方案， optional chaining
  <div>{{userInfo?.address?.name}}</div>


      
  \`\`\`
  ## 
  `;
}

export default {
  name: "",
  components: {
    VueMarkdownIt,
  },
  data() {
    return {
      source: test(),
      name: "shencocoa",
      userInfo: {
        // address:{}
      },
      age: 0,
      list: [1, 2, 3, 4],
    };
  },
  mounted() {},
  methods: {
    testArray() {
      ArrayUtil.testArray();
    },
    base1() {
      // 箭头函数的基本使用
      const sum = (a, b) => a + b;
      console.log("base1 sum =>> ", sum(1, 2));
    },
    base2() {
      // 箭头函数的基本使用
      const sum = (a, b) => {
        const result = a + b;
        return result;
      };
      console.log("base2 sum =>> ", sum(1, 2));
    },
    test1() {
      this.list.forEach((element) => {
        //箭头函数没有 this。如果访问 this，则会从外部获取。
        console.log("get name from list foreach @arrow function==>", this.name);
      });
      this.list.forEach(function (item) {
        //Cannot read properties of undefined (reading 'name')
        // console.log('get name from list foreach ==>',this.name);
        console.log(this);
      });
    },
  },
  setup(props) {},
};
</script>

<style></style>
