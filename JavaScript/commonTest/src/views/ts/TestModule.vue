<template>
  <div class="flex flex-1 flex-col">
    <div style="width: 800px"></div>
    <button class="bg-indigo-500" @click="test1">test1</button>
    <button class="bg-indigo-500" @click="test2">test2</button>
    <button class="bg-indigo-500" @click="test3">test3</button>
  </div>
</template>

<script setup>
import * as shapes from "./lib/test-module";
// import { Person } from "./lib/test-module";
import { ref } from "vue";
import deepClone, { test2Fun, PI } from "../../util";
import { union as listunion } from "../../util/CCArrayUtil";
// 导入原型方法
import "../../util/CCArrayExt";

//   source1: `test1() {
//   const t = new shapes.Shapes.Triangle();
//   console.log(t);
//   console.log(shapes.Shapes.age);
// },`,
//   code1: "",
//   data3: {name: "123"}

function test1() {
  const t = new shapes.Shapes.Triangle();
  console.log(t);
  console.log(shapes.Shapes.age);
}
function test2() {
  // const p = new Person();
  // p.name = "123";
  // console.log(p);
}

let data3 = ref({ name: "123" });
function test3() {
  let data = deepClone(data3.value);
  data.name = "456";
  console.log(data);
  console.log(test2Fun());
  console.log(PI);

  let list1 = [1, 2, 3, 4, 5];
  let list2 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  console.log(listunion(list1, list2));

  let removeAllRes = list2.removeAll((item) => {
    return item % 2;
  });
  // console.log("removeAllRes",removeAllRes);
  for (const iterator of removeAllRes) {
    console.log(iterator);
  }
}
</script>

<style></style>
