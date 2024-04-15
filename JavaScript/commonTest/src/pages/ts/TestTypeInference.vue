<template>
  <div class="flex flex-1 flex-col">
    <button class="bg-indigo-500" @click="test1">test1</button>
    <button class="bg-indigo-500" @click="test2">test2</button>
    <button class="bg-indigo-500" @click="test3">test3</button>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";

onMounted(() => {
  // window.onmousedown = function (mouseEvent) {
  //   console.log(mouseEvent.button); //<- Error
  // };
});

interface Person {
  hello(): void;
}
function test(p: any) {
  // instanceof 只能用于类，不能用于接口
  if (p instanceof Student) {
    (p as Person).hello();
  }
}

class Student implements Person {
  hello() {
    console.log("hello");
  }
}

function test1() {
  const s1 = new Student();
  test(s1);
  test("123");
}
function test2() {
  const res = Boolean("");
  console.log(res);
}
</script>

<style></style>
