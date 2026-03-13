<template>
  <div>
    <h1>TestPackagingComponent</h1>

    <div>{{ msg }}</div>

    <MyElmInput placeholder="12312312" v-model="msg">

      <template #append>append</template>

    </MyElmInput>

    <!-- @update:modelValue='onUpdateModelValue' -->
    <!-- 
    :model-value="msg"
     @input="onInput"
      @update:modelValue="onUpdateModelValue" 
          
-->

    <!-- <div>-----</div> -->
    <!-- <el-input v-model="msg"></el-input> -->
  </div>
</template>

<script setup>
import { ref } from "vue";
import MyElmInput from "@/components/MyElmInput.vue";

const msg = ref("ccooca");

// const onInput = (e) => {
//   // console.log("parent input", e);
// };

// const onUpdateModelValue = (e) => {
//   console.log("parent onUpdateModelValue", e);
//   msg.value = e;
// };
</script>
