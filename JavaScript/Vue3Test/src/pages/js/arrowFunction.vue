<template>
  <div class="flex flex-1 flex-col">
    <vue3-markdown-it :source="source" />
    <button @click="base1">base1</button>
    <button @click="base2">base2</button>
    <button @click="test1">test1</button>
  </div>
</template>

<script lang="ts">
import VueMarkdownIt from "vue3-markdown-it";

function test(){
  return `
  # 
  \`\`\`javascript
      console.log('123123');
  \`\`\`
  ## 

  `
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
      list: [1, 2, 3, 4],
    };
  },
  mounted() {},
  methods: {
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
