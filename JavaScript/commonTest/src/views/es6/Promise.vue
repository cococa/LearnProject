<template>
  <div class="flex flex-1 flex-col">
    <div>{{ a }}</div>
    <button @click="btn1Clk">button1</button>
    <button @click="btn2Clk">button2</button>
    <button @click="btn3Clk">button3</button>
    <button @click="btn4Clk">button4</button>
  </div>
</template>

<script lang="ts" setup>
import { ref } from "vue";

function asyncMethod() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const res = true;
      if (res) {
        resolve("asyncMethod resolve");
      } else {
        reject("reject error!");
      }
    }, 1000);
  });
}

const a = ref(1);
const btn1Clk = function () {
  asyncMethod()
    .then((res) => {
      console.log(res);
    })
    .then(() => {
      throw new Error("then2 error");
    })
    .then(() => {
      console.log("then3");
    })
    .catch((err) => {
      console.log(err);
    });
};

function m1() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("m1 resolve");
    }, 1000);
  });
}
function m2() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("m2 resolve");
    }, 1000);
  });
}
function m3() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("m3 resolve");
    }, 1000);
  });
}

const btn2Clk = function () {
  console.log("promise chain 链式调用");
  m1()
    .then((res) => {
      console.log(res);
      return m2();
    })
    .then((res) => {
      console.log(res);
      return m3();
    })
    .then((res) => {
      console.log(res);
    });
};

const btn3Clk = async function () {
  const r1 = await m1();
  console.log(r1);
  const r2 = await m2();
  console.log(r2);
  const r3 = await m3();
  console.log(r3);
};

const btn4Clk = async function () {
  // 并发的一次请求多个promise
  Promise.all([m1(), m2(), m3()]).then((res) => {
    console.log(res);
  });
};
</script>

<style scoped></style>
