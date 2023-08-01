<template>
  <div class="flex justify-center flex-col">
    <div>count:{{ countStore.count }}</div>
    <div>解构后的 count:{{ count }}</div>
    <button @click="addCount">addCount</button>
    <button @click="reset">reset</button>

    <div
      style="
        background-color: rgba(255,0,0,0.5);
        color: #fff;
        margin-top: 20px;
        padding: 20px;
      "
    >
      <div>userStore.name:{{ userStore.name }}</div>
      <button @click="changeUserName">changeUserName</button>
      <button @click="resetUserName">resetUserName</button>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { useCounterStore } from "../../stores/counter";
import { useUserStore } from "../../stores/UserStore";

import { storeToRefs } from "pinia";

const countStore = useCounterStore();
console.log(countStore.doubleCount);
const { count } = storeToRefs(countStore);

function addCount() {
  countStore.increment();
}

const reset = () => {
  countStore.$reset();
};

//------useUserStore---start------
const userStore = useUserStore();
const changeUserName = () => {
  userStore.name = "current time "+ new Date().getTime();
};

const resetUserName = () => {
  // console.log("reset user name");
  userStore.$reset();
};

//------useUserStore---end------
</script>
