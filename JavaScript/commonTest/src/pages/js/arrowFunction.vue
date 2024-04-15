<template>
  <div class="flex flex-1 flex-col">
    <div v-for="(item, index) in codeArray" :key="index" class="item">
      <vue3-markdown-it :source="item.code" />
      <button @click="testClick(item.methodName)">
        testMethod({{ item.methodName }})
            <template #default></template>
      </button>
    </div>
  </div>
</template>

<script lang="ts">
import VueMarkdownIt from "vue3-markdown-it";
import mixinCode from "../../mixins/mixinCode";

export default {
  name: "asd",
  components: {
    VueMarkdownIt,
  },
   mixins: [mixinCode],
  data() {
    return {
      name: "shencocoa",
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
