<template>  
  <div class="flex flex-1 flex-col ">
    <vue3-markdown-it :source='source' />
    <button>object</button>
  </div>
</template>

<script lang='ts'>
import VueMarkdownIt from 'vue3-markdown-it';

export default {
  name: 'xx',
  components: {
    VueMarkdownIt
  },
  data() {
    return {
      source: '',
      aa: "",
    }
  },
  mounted() {
    
  },
  methods: {
   
  },
  setup(props) {
    
  }
};
</script>


<style >

</style>

