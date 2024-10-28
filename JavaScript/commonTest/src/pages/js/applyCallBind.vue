<template>
  <div class="flex flex-1 flex-col">
    <vue3-markdown-it :source="source" />
  </div>
</template>

<script lang="ts">
import VueMarkdownIt from "vue3-markdown-it";
import { ArrayUtil } from "../../util/index.js";

export default {
  name: "",
  components: {
    VueMarkdownIt,
  },
  data() {
    return {
      
    };
  },
  mounted() {},
  methods: {
    
  },
  setup(props) {},
};
</script>

<style scoped>
.blk {
  margin-bottom: 20px;
  background-color: azure;
  border: 1px solid black;
}
</style>
