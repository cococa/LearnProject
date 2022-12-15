<template>
  <div>
    <div>TestReactive</div>
    <button @click="changeObj">更新Person</button>
    <div>{{ person }}</div>

    <div>
      <button @click="changeDeepObj">更新deepObj</button>
      <button @click="changeDeepObj2">无效的更新</button>
    </div>
    <div>{{ deepObj }}</div>
  </div>
</template>

<script setup lang="ts">
import { reactive, nextTick } from "vue";

interface Person {
  name: string;
  age: Number;
}

const person: Person = reactive({
  name: "cocoa",
  age: 12,
  address: "hangzhou xihu",
});
//为响应式对象标注类型

const changeObj = () => {
  person.name = "change name";
  nextTick(() => {
    console.log("更新后的回调");
  });
};

const deepObj = reactive({
  address: { cityCode: 12, cityName: "zhejianghangzhou" },
  list:[1,2,3]
});
const changeDeepObj = () => {
  deepObj.address.cityCode = 33;
  deepObj.list[0] = 99
};

const changeDeepObj2 = ()=>{
  //a 是一个局部变量，同 deepObj.list 代理失去连接，无法更新
  let a = deepObj.list;
  a = [99]
}





</script>
