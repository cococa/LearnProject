<template>
  <div class="flex justify-center flex-col">
    <div style="background-color: bisque;margin:20px 0px;">
      <div>测试 script setup , 当使用 script setup 的时候，任何在 script setup 声明的顶层的绑定 (包括变量，函数声明，以及 import 引入的内容) 都能在模板中直接使用：</div>
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

<script setup>
import InjectComponent from "../../components/InjectComponent.vue";
import { ref } from "vue";
const setupCount = ref(0);
function countPlus() {
  setupCount.value += 1;
}
</script>

<script>
import { onMounted, ref, watch } from "vue";
import userCompose from "../../composables/UserCompose";
import { useStore } from "vuex";

export default {
  name: "xx",
  data() {
    return {};
  },
  components: {},
  created() {},
  methods: {
    clickFromSetup() {
      console.log(this.getName());
    },
  },
  setup(props) {
    const store = useStore();
    console.log("the count is  = " + store.state.count);

    let name = "cocoa";
    function getName() {
      return name;
    }
    const count = ref(11);

    function countPlus() {
      count.value++;
    }

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
    const userInfo = {
      name: "cocoa",
      age: 33,
    };
    const complexUserInfo = ref(userInfo);
    function changeCpxUserInfo() {
      this.complexUserInfo.age += 1;
    }
    return {
      getName,
      name,
      count,
      countPlus,
      user,
      getUser,
      changeDept,
      complexUserInfo,
      changeCpxUserInfo,
    };
  },
};
</script>
