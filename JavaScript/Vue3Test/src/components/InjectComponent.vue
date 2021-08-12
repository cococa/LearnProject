<template>
  <div class="flex bg-red-200 justify-center items-center flex-col">
      <div>红色区域为子控件（InjectComponent）</div>
      <div>{{username}}</div>
      <div>{{oname.value}}</div>
  </div>
</template>

<script>
export default {
  inject:['username', 'oname'],
  name: 'HelloWorld',
  props: {
    msg: String,
  },
  data() {
    return {
      count: 0,
    };
  },
};
</script>
