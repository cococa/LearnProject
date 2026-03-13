<template>
  <div>
    <!-- <h1>MyElmInput vue3 组件二次封装{{ $attrs }}</h1> -->
    <!-- <el-input v-bind="{...$attrs, ...props}" > </el-input> -->

    <component :is="h(ElInput, { ...$attrs, ...props }, { ...$slots })" />
  </div>
</template>
<script lang="ts" setup>
import { type InputProps, ElInput } from "element-plus";

import { defineProps, h } from "vue";

const props = defineProps<InputProps>();

// const emit = defineEmits<Partial<InputEmits>>(["input"]);
// const listeners = {
//   input: (e) => {
//     emit("input", e);
//   },
//   change: (e) => {
//     console.log("change", e);
//   },
//   blur: (e) => {
//     console.log("blur", e);
//   },
// };
</script>
