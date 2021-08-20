<template>
  <div class="flex bg-red-200 justify-center items-center flex-col">
      <div>红色区域为子控件（InjectComponent）</div>
      <div>username: {{username}}</div>
      <div>userInfo: {{userInfo}}</div>
  </div>
</template>

<script>
import { inject } from 'vue'
export default {
  name: 'InjectComponent',
  props: {
    msg: String,
  },
  data() {
    return {
      count: 0,
    };
  },
  setup(props) {
      const username  = inject('username','the default username')
      const userInfo = inject('userInfo')
      return {
        username,
        userInfo
      }
  }
};
</script>
