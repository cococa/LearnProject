<template>
  <div class="flex justify-center flex-col">
    <div>组合式函数测试</div>
    <a href="https://cn.vuejs.org/guide/reusability/composables.html#what-is-a-composable">官方文档</a>
    <div style="background-color: bisque; margin: 20px 0px">
      <div>useMouse</div>
      <div>{{ x }} --- {{ y }}</div>
    </div>

    <div style="background-color: #f1f1f1; margin: 20px 0px">
      <div>userCompose</div>
      <button @click="getUser">{{ user }}</button>
    </div>
    
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useMouse } from "@/composables/mouse.js";
import { userCompose } from "@/composables/UserCompose";
const { x, y } = useMouse();
const deptID = ref(11);
const { user, getUser } = userCompose(deptID);
</script>
