<template>  
  <div class="flex flex-1 flex-col">
    <div
      class="flex flex-row flex-1 p-6 bg-gray-200"
      v-for="(item, index) in routerList"
      :key="index"
      @click="push(item.path)"
    >
      <div class="flex-1 flex-row item">
        <div class="item-title flex-1">{{index}}. {{item.name || 'item.path'}} </div>
        <div>点击进入</div>
      </div>
    </div>
  </div>
</template>

<script lang='ts'>

export default {
  name: 'xx',
  components: {
    
  },
  data() {
    return {
      routerList:[]
    }
  },
  mounted() {
    const app = this;
    this.routerList = this.$router.getRoutes().filter((item) => {
      return item.path.indexOf('js') > -1 && item.path.indexOf('js/index') == -1;
    });
    console.log(this.routerList);
  },
  methods: {
        push(path) {
      this.$router.push(path);
    },
  },
  setup(props) {
    
  }
};
</script>


<style >
.item-title{
    font-size: 1.3rem;
    color: #333;
    padding: 10px 20px;
}

.item{
  padding: 16px;
  border-top-width: 0px;
  border-left-width:  0px;
  border-right-width:  0px;
  border-bottom-width: 1px;
  border-color: #999;
  border-style: solid;
  align-items: center;
}

</style>

