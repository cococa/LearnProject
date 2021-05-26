<template>
  <div class="sub-title">1. 数组的解构</div>
  <div>
    <pre v-highlightjs>
    <code class="javascript">
      {{$options.methods.test1}}
    </code>
  </pre>
  </div>
  <div>
    <button @click="test1">test1</button>
  </div>

  <div class="sub-title">1. 对象的结构 </div>
  <div>
    <pre v-highlightjs>
    <code class="javascript">
      {{$options.methods.test2}}
    </code>
  </pre>
  </div>
  <div>
    <button @click="test1">test2</button>
  </div>


  <div class="sub-title">1. 对象的结构 </div>
  <div>
    <pre v-highlightjs>
    <code class="javascript">
      {{$options.methods.test2}}
    </code>
  </pre>
  </div>
  <div>
    <button @click="test1">test2</button>
  </div>






</template>

<script lang="ts">
import { ref, defineComponent } from 'vue';

export default defineComponent({
  components: {},
  name: 'HelloWorld',
  computed: {
    
  },
  props: {
    msg: {
      type: String,
      required: true,
    },

  },
  setup: () => {
    const count = ref(0);
    return { count };
  },
  methods: {
    test1() {
      var [a, b, c] = [1, 2, 3];
      console.log(a, b, c);
      console.log(a, b, c);


    },
    test2() {
      var { foo, bar } = { foo: 'aaa', bar: 'bbb' };
      console.log(foo, bar);
    },
  },
});
</script>

<style scoped>
code{
  text-align: left;
  font-size: 20px;
}
.sub-title{
  text-align: left;
  font-size: 20px;
}
div {
  margin-bottom: 30px;
}
</style>
