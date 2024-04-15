<template>
  <div class="flex flex-1 flex-col">
    <div>{{ a }}</div>
    <button @click="btn1Clk">button1</button>
    <button @click="btn2Clk">button2</button>
    <button @click="btn3Clk">button3</button>
    <button @click="btn4Clk">button4</button>

    <div>{{ centerX }}</div>

    <button @click="smallCircleCount++">smallCircleCount++</button>
    <button @click="smallCircleCount--">smallCircleCount--</button>

    <LuckyGrid
      ref="myLucky"
      width="400px"
      height="400px"
      :rows="z"
      :cols="z"
      :prizes="prizes"
      :blocks="blocks"
      :buttons="buttons"
      :defaultStyle="defaultStyle"
      @start="startCallback"
      @end="endCallback"
    />
  </div>
</template>

<script lang="ts" setup>
import { ref, watch } from "vue";
const z = 60, // 格子细分数
  s = 12, // 格子大小
  m = 18, // y 轴偏移量
  n = 9, // x 轴偏移量
  k = 2.8; // 按钮放大的倍数
const blocks = [{ padding: "13px", background: "#617df2" }];

const smallCircleCount = ref(2)

function calculateSmallCircleRadius(
  radiusLarge: number,
  smallCircleCount: number
) {
  // 计算每个小圆之间的角度
  var angleBetweenCircles = (2 * Math.PI) / smallCircleCount;

  // 计算每个小圆的半径，以确保小圆之间没有重叠
  var radiusSmall =
    (Math.sin(angleBetweenCircles / 2) * radiusLarge) /
    (1 + Math.sin(angleBetweenCircles / 2));

  return radiusSmall;
}

let prizes = ref([])
  // { x: z / 2 - s / 2, y: 0, col: s, row: s },
  // { x: z - m - s / 2, y: n - s / 2, col: s, row: s },
  // { x: z - n - s / 2, y: m - s / 2, col: s, row: s },
  // { x: z - s, y: z / 2 - s / 2, col: s, row: s },
  // { x: z - n - s / 2, y: z - m - s / 2, col: s, row: s },
  // { x: z - m - s / 2, y: z - n - s / 2, col: s, row: s },
  // { x: z / 2 - s / 2, y: z - s, col: s, row: s },
  // { x: m - s / 2, y: z - n - s / 2, col: s, row: s },
  // { x: n - s / 2, y: z - m - s / 2, col: s, row: s },
  // { x: 0, y: z / 2 - s / 2, col: s, row: s },
  // { x: n - s / 2, y: m - s / 2, col: s, row: s },
  // { x: m - s / 2, y: n - s / 2, col: s, row: s },
// ];
const radiusLarge = ( 400 / 6 / 2) * 0.7;
const centerX = 28;
const centerY = 28;

const radiusSmall =
  calculateSmallCircleRadius(radiusLarge, smallCircleCount.value) * 2;

console.log(radiusSmall);

for (var i = 0; i < smallCircleCount.value; i++) {
  var angle = ((2 * Math.PI) / smallCircleCount.value) * i; // 将360度分为小圆的数量份
  var x = centerX + radiusLarge * Math.cos(angle);
  var y = centerY + radiusLarge * Math.sin(angle);
  prizes.value.push({
    x: x - radiusSmall / 2.5,
    y: y - radiusSmall / 2.5,
    col: radiusSmall,
    row: radiusSmall,
  });
}
prizes.value.push({ x: centerX, y: centerY, col: 2, row: 2 });

watch(smallCircleCount, (newVal, oldVal) => {
  console.log(newVal, oldVal);
  const radiusSmall =
    calculateSmallCircleRadius(radiusLarge, newVal) * 2;

  console.log(radiusSmall);

  prizes.value = []
  for (var i = 0; i < newVal; i++) {
    var angle = ((2 * Math.PI) / newVal) * i; // 将360度分为小圆的数量份
    var x = centerX + radiusLarge * Math.cos(angle);
    var y = centerY + radiusLarge * Math.sin(angle);
    prizes.value.push({
      x: x - radiusSmall / 2.5,
      y: y - radiusSmall / 2.5,
      col: radiusSmall,
      row: radiusSmall,
    });
  }
  prizes.value.push({ x: centerX, y: centerY, col: 2, row: 2 });
});


const buttons = [
  {
    radius: "35%",
    background: "#123123",
    pointer: true,
    fonts: [{ text: "开始", top: "-10px" }],
  },
];

const defaultStyle = {
  borderRadius: Infinity,
  background: "#bac5ee",
};
const activeStyle = {
  background: "#f7cf9f",
};

function startCallback() {
  // 调用抽奖组件的play方法开始游戏
  this.$refs.myLucky.play();
  // 模拟调用接口异步抽奖
  setTimeout(() => {
    // 假设后端返回的中奖索引是0
    const index = 0;
    // 调用stop停止旋转并传递中奖索引
    this.$refs.myLucky.stop(index);
  }, 3000);
}
// 抽奖结束会触发end回调
function endCallback(prize) {
  console.log(prize);
}

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
