<template>
  <div class="flex inject-middle-bg justify-center items-center flex-col">
    <div style="color:azure">蓝色区域为InjectMiddleComponent</div>
    <InjectComponent></InjectComponent>
  </div>
</template>

<script setup>
import InjectComponent from "./InjectComponent.vue";
</script>
<style scoped>
.inject-middle-bg {
  background-color: blue;
  padding: 10px;
}
</style>
