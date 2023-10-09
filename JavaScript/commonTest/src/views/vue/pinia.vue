<template>
  <div class="flex justify-center flex-col">
    <div>直接使用store count:{{ countStore.count }}</div>
    <div>doubleCount:{{ doubleCount }}</div>
    <div>storeToRefs解构后的 count:{{ count }}</div>
    <button @click="addCount">addCount</button>
    <button @click="reset">reset</button>

    <div
      style="
        background-color: rgba(255, 0, 0, 0.5);
        color: #fff;
        margin-top: 20px;
        padding: 20px;
      "
    >
      <div>userStore.name:{{ user }}</div>
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
const { count, doubleCount } = storeToRefs(countStore);

function addCount() {
  countStore.increment();
}

const reset = () => {
  countStore.$reset();
};
countStore.$subscribe((mutation, state) => {
 
  console.log("mutation", mutation);
  console.log("state", state.count);
})



//------useUserStore---start------
const userStore = useUserStore();

const { user } = storeToRefs(userStore);

const changeUserName = () => {
  let _age = 1;
  if (user && user.value) {
    const { age } = user.value;
    _age = age ? age + 1 : 1;
  }
  userStore.changeUser({ name: "cocoa", age: _age });
};

const resetUserName = () => {
  // 只有 Option API 才能使用 $reset 方法
  userStore.$reset();
};

//------useUserStore---end------
</script>
