<template>  
  <div class="flex flex-1 flex-col">
       
        <button @click="changeName">change name</button> 
        <div>--------</div>
        <InjectComponent></InjectComponent>
  </div>
</template>

<script>
import InjectComponent from '../components/InjectComponent.vue'
// import Vue from 'vue';

export default {
  name: 'xx',
  provide(){
      return {
            username: 'cocoa',
            oname : Vue.computed(()=> this.othername)
      }
  },
  data() {
    return {
        othername: "otherName"
    };
  },
  components: {
      InjectComponent
  },
  created() {
  },  
  methods: {
      changeName(){
          this.othername = "changed othername"
      }
  },
  setup(props) {

  }
};
</script>
