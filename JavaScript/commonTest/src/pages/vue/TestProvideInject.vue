<template>
  <div class="flex flex-1 flex-col">
    <div>这里测试的是父组件provide, 孙子组件 Inject</div>
    <button @click="changeName">change name</button>
    <div>父控件的username：{{ username }}</div>
    <div style="height: 30px"></div>
    <div>点击上面的按钮，修改父控件和子控件的username</div>
    <div>--------</div>
    <InjectMiddleComponent></InjectMiddleComponent>
    <div style="height: 100px"></div>
    <h6>
      参考文档：<a
        href="https://v3.cn.vuejs.org/guide/composition-api-provide-inject.html"
        target="_blank"
        >链接</a
      >
    </h6>
  </div>
</template>

<script setup>
// import InjectComponent from "../../components/InjectComponent.vue";
import InjectMiddleComponent from "../../components/InjectMiddleComponent.vue";
import { ref, provide, reactive } from "vue";

const userInfo = reactive({
  name: "123",
  age: 12,
});
function changeName() {
  const date = new Date();
  username.value = date;
  userInfo.name = date;
}
const username = ref("cocoa");
provide("username", username);
provide("userInfo", userInfo);
</script>
