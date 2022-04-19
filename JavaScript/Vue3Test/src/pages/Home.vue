<template>
  <div class="flex flex-1 flex-col">
    <div
      class="flex flex-row flex-1 p-6 bg-gray-200"
      v-for="(item, index) in routerList"
      :key="index"
      @click="push(item.path)"
    >
      <div class="flex-1 flex-row">
        <div>{{ index+1 }}. </div>
        <div>{{ item.meta.title }}相关</div>
      </div>
      <img
        style="width: 90px; height: 60px"
        src="https://t7.baidu.com/it/u=963301259,1982396977&fm=193&f=GIF"
      />
    </div>
  </div>
</template>

<script>
export default {
  name: "xx",
  data() {
    return {
      routerList: [],
      firstRouterName: ["js", "ts", "vue", "es6"],
    };
  },
  components: {},
  created() {
     this.routerList = this.$router.getRoutes().filter((item) => {
      console.log(item);
      return  this.firstRouterName.some((name) => {
        return name == item.name;
      });
    });
    console.log(this.routerList);
  },
  methods: {
    push(path) {
      this.$router.push(path);
    },
  },
  setup(props) {},
};
</script>
