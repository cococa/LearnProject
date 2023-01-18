<template>
  <div class="flex inject-bg justify-center items-center flex-col">
    <div>红色区域为子控件（InjectComponent）</div>
    <div>username: {{ username }}</div>
    <div>userInfo: {{ userInfo }}</div>
    <div></div>
    <button @click="change">测试孙子控件修改Inject内容</button>
  </div>
</template>

<script setup>
import { inject } from "vue";
// const count = ref(0);
const username = inject("username", "the default username");
const userInfo = inject("userInfo");

let change = (()=>{
  const date =new Date()
  username.value = date;
  userInfo.name = date;
})
</script>

<style scoped>
.inject-bg {
  background-color: rosybrown;
  padding: 5px;
}
</style>
