<template>  
  <div class="flex flex-1 flex-col">
      <div>TestRenderFunction</div>
      <RenderComponent>123</RenderComponent>
  </div>
</template>

<script>
import RenderComponent from '../components/RenderComponent.js'
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
    
  }
};
</script>
