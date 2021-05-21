<template>
    <div>ES6</div>
    <div class="flex-row">
        <div class="flex2">
            <div>
              <router-link to="/c2">第2章 ：let和const命令</router-link>
            </div>
            <div>
              <router-link to="/about">Go to About</router-link>
            </div>
        </div>
        <div class="flex4">
          <router-view ></router-view>
        </div>
    </div>
    
</template>

<script lang="ts">
import { defineComponent } from 'vue';
export default defineComponent({
  name: 'App',
  components: {
    
  },
  methods: {
    test1() {
      var [a, b, c] = [1, 2, 3];
      let { cname } = { cname: 'cocoa' };
      console.log(cname);
      console.log(a, b, c);
    },
  },
});
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.flex-row{
    display: flex;
    flex-direction: row;
}

.flex2{
    flex:1
}
.flex4{
    flex:4
}




</style>
