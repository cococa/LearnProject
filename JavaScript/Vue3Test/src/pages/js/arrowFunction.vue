<template>
  <div class="flex flex-1 flex-col">
    <div v-for="(item, index) in codeArray" :key="index" class="item">
      <vue3-markdown-it :source="item.code" />
      <button @click="testClick(item.methodName)">
        testMethod({{ item.methodName }})
      </button>
    </div>
  </div>
</template>

<script lang="ts">
import VueMarkdownIt from "vue3-markdown-it";

function testCode(res) {
  return `
  # 
  \`\`\`javascript
   ${res}   
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
      codeArray: [],
      name: "shencocoa",
      list: [1, 2, 3, 4],
    };
  },
  mounted() {
    var methods = this.$options.methods;
    Object.keys(methods).forEach((element) => {
      if (element != "testClick") {
        const code = {
          methodName: element,
          code: testCode(this.$options.methods[element]),
        };
        this.codeArray.push(code);
      }
    });
  },
  methods: {
    testClick(mName) {
      if (mName) {
        var vueMethods = this.$options.methods;
        let m = vueMethods[mName];
        m.call(this);
      }
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
    base3() {
      const list = [1, 3, 5, 7];
      console.log("=>", this);
      list.forEach((element) => {
        //箭头函数没有 this。如果访问 this，则会从外部获取。
        console.log("get name from list foreach @arrow function==>", this.name);
      });
      list.forEach(function (item) {
        //Cannot read properties of undefined (reading 'name')
        // console.log('get name from list foreach ==>',this.name);
        console.log(this);
      });
    },
  },
  setup(props) {},
};
</script>

<style scoped>
.item {
  margin-bottom: 10px;
}
</style>
