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
import mixinCode from "../../mixins/mixinCode";
// 参考文档
// https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty
// https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Proxy

export default {
  name: "asd",
  components: {
    // VueMarkdownIt,
  },
  mixins: [mixinCode],
  data() {
    return {
      name: "shencocoa",
      msg_base1: "base1 方法的意图是：<br/> ",
    };
  },
  mounted() {},
  methods: {
    base1() {
      {
        let msg = "hello";
        console.log(msg);
      }
      // console.log(msg)   // 报错
    },
    sayHiBye(firstName, lastName) {
      function getFullName() {
        return firstName + " " + lastName;
      }
      alert("Hello" + getFullName());
    },
    base2() {
      this.sayHiBye("shen", "jun");
    },
    makeCount() {
      let count = 0;
      return function () {
        return count++;
      };
    },
    base3() {
      let count = this.makeCount();
      console.log(count());
      console.log(count());
      console.log(count());
    },

  },
  setup(props) {
    return {
    };
  },
};
</script>

<style scoped>
.item {
  margin-bottom: 10px;
}
</style>
