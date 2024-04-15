<template>
  <h1>对象的新增方法</h1>
  <div class="flex flex-1 flex-col">
    <button @click="btn1Clk">button1</button>
    <VueMarkdownIt :source="objIs" />
  </div>
</template>

<script lang="ts" setup>
import VueMarkdownIt from "vue3-markdown-it";

const mixJsCode = (res) => {
  return `
        #
        \`\`\`javascript
         ${res}
        \`\`\`
        ##
        `;
};

const objIs = mixJsCode(`+0 === -0 //true
NaN === NaN // false

Object.is(+0, -0) // false
Object.is(NaN, NaN) // true`);
</script>

<style scoped></style>
