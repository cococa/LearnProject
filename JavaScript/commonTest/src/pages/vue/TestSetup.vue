<template>
  <div class="flex justify-center flex-col">
    <div>{{ sref }}</div>
    <button @click="testShallowRef">testShallowRef</button>
    <button @click="testDeepRef">testDeepRef</button>
    <button @click="testShowMsg">testShowMsg</button>
    <div>{{ double }}</div>
    <div style="background-color: bisque; margin: 20px 0px">
      <div>
        测试 script setup , 当使用 script setup 的时候，任何在 script setup
        声明的顶层的绑定 (包括变量，函数声明，以及 import 引入的内容)
        都能在模板中直接使用：
      </div>
      <div>{{ setupCount }}</div>
      <button @click="countPlus">countPlus</button>
      <div>setup 标签中，连组件也可以直接使用，不用注册</div>
      <InjectComponent></InjectComponent>
    </div>

    <div>name from setup : {{ name }}</div>
    <button @click="clickFromSetup">click from setup</button>
    <div class="p-5"></div>
    <div>count from setup : {{ count }}</div>
    <button class="border-gray-10 border-2 border-solid" @click="countPlus">
      click from setup use countPlus
    </button>

    <div class="p-5"></div>
    <div>complexUserInfo : {{ complexUserInfo }}</div>
    <button class="" @click="changeCpxUserInfo">change complexUserInfo</button>

    <div class="p-5"></div>
    <div>
      get user from setup & composable, 这里已经完全拆分功能，然后再setup
      中使用user 和dept 相关的函数和属性
    </div>
    <div>user : {{ user }}</div>
    <button class="" @click="getUser">getUser</button>
    <button class="" @click="changeDept">changeDept</button>
  </div>
</template>

<!-- <script setup>
import InjectComponent from "../../components/InjectComponent.vue";
import { ref } from "vue";

</script> -->

<script lang="ts" setup>
import { showMsg } from "../js/dialog.js";
import {
  computed,
  ref,
  watch,
  render,
  createVNode,
  onMounted,
  shallowRef,
} from "vue";
import type { Ref } from "vue";

import { userCompose } from "@/composables/UserCompose";
// import { useStore } from "vuex";
import InjectComponent from "../../components/InjectComponent.vue";

import { ElMessage, ElMessageBox } from "element-plus";

// $log(reverse("1 2 3"));

// const obj = { name: "cocoa", age: 33 };
const sref = ref([]);
// sref.value.name = "123";
const testShallowRef = () => {
  sref.value = ["123", "2222"];
};

const testDeepRef = () => {
  sref.value[0] = "123";
};

function reverse(s: string): string {
  return s.split(" ").reverse().join("，");
}

// const testShowMsg = () => {
//   ElMessageBox.confirm(
//     'proxy will permanently delete the file. Continue?',
//     'Warning',
//     {
//       confirmButtonText: 'OK',
//       cancelButtonText: 'Cancel',
//       type: 'warning',
//     }
//   )
//     .then(() => {
//       ElMessage({
//         type: 'success',
//         message: 'Delete completed',
//       })
//     })
//     .catch(() => {
//       ElMessage({
//         type: 'info',
//         message: 'Delete canceled',
//       })
//     })
// }

const testShowMsg = () => {
  showMsg("testShowMsg");
};

function testRender() {
  // const v = createVNode("div", { class: "foo" }, "testRender DIV INNDER");
  const v = `<div class="foo">testRender DIV INNDER123</div>`;
  render(v, document.getElementById("aaa") as Element);
}

onMounted(() => {
  testRender();
});

const setupCount = ref(0);

function clickFromSetup() {
  console.log(getName());
}

let name = "cocoa";
function getName() {
  return name;
}
const count = ref(11);

function countPlus() {
  count.value++;
}

const double = computed<string>(() => name + "----computedname");

// 使用watch 函数
watch(
  count,
  (newValue, oldValue) => {
    console.log(`the newValue ${newValue} and the oldValue ${oldValue}`);
  },
  { immediate: true }
);

// onMounted(countPlus);  // 在 `mounted` 时调用 `countPlus`

const deptID = ref(11);
const { user, getUser } = userCompose(deptID);

watch([deptID, count], (nv, ov) => {
  // 监听多个数据，但是如果他们同时改变，只能被回调一次
  console.log("deptid or count has changed!!");
});

function changeDept() {
  deptID.value++;
}

interface UserInfo {
  name: string;
  age: number;
}

const userInfo: UserInfo = {
  name: "cocoa",
  age: 33,
};
const complexUserInfo: Ref<UserInfo> = ref(userInfo);
function changeCpxUserInfo() {
  complexUserInfo.value.age += 1;
}
</script>
