<template>  
  <div class="flex flex-1 flex-col ">
          <div class="flex flex-row flex-1 p-6 bg-gray-200" v-for="(item ,index) in routerList" :key="index" @click="push(item.path)">
              <div class="flex-1">
                  <div>{{index}} This is test Pages</div>
                  <div>the path is {{item.path}}</div>
              </div>
              <img style="width: 90px; height: 60px;" src="https://t7.baidu.com/it/u=963301259,1982396977&fm=193&f=GIF"/>
          </div>
       <button>123</button> 
  </div>
</template>

<script>


export default {
  name: 'xx',
  data() {
    return {
      routerList:[]
    };
  },
  components: {
  },
  created() {
        this.routerList = this.$router.getRoutes();
  },  
  methods: {
        push(path){
          this.$router.push(path)
        }
  },
  setup(props) {

  }
};
</script>
