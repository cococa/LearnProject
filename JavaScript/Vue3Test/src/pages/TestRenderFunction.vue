<template>  
  <div class="flex flex-1 flex-col">
      <div>TestRenderFunction</div>
      
      <button @click="changeName()">changeName(通过外部的方法改变子控件的props)</button>


      <div>下面开始是子控件RenderComponent</div>  
      <RenderComponent :name="name" age="123">123</RenderComponent>


  </div>
</template>

<script>
import RenderComponent from '../components/RenderComponent.js'
import { ref} from  'vue'

export default {
  name: 'xx',
  
  data() {
    return {
        
    };
  },
  components: {
    RenderComponent
  },
  created() {
  },  
  methods: {
     
  },
  setup(props) {
      let name = ref("cc");

      function changeName(){
        name.value  = "cocoa"
      }

      return {
        name,
        changeName
      }
  }
};
</script>
