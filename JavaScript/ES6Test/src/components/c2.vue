<template>
  <span>1. let 变量只在代码块中有效！</span>
  <div>
      <button @click="testLet">testLet</button>
  </div>

  <span>2. 变量提升问题</span>
  <div>
      <button @click="testLet1">testLet1</button>
  </div>

   <span>3. 暂时性死区</span>
  <div>
      <button @click="testLet2">testLet2</button>
  </div>

  <span>4. 重复命名问题</span>
  <div>
      <button @click="testLet3">testLet3</button>
  </div>

  <span>5. 测试let 赋值问题</span>
  <div>
      <button @click="testLet4">testLet4</button>
  </div>


  <span>6. 测试const 赋值问题 const 不能分开赋值</span>
  <div>
      <button @click="testLet5">testLet5</button>
  </div>
  
  

</template>

<script lang="ts">
import { ref, defineComponent } from 'vue'
export default defineComponent({
  name: 'HelloWorld',
  props: {
    msg: {
      type: String,
      required: true
    }
  },
  setup: () => {
    const count = ref(0)
    return { count }
  },
  methods:{
      testLet(){
          {
            var a = 10;
            let b = 10;
          }
          console.log("a = "+ a);
          console.log("b = "+ b);

      },
      testLet1(){

          console.log("a = "+ a);
          console.log("b = "+ b);

          var a = 10;
          let b  = 10;

      },
      testLet2(){

          var temp = "123";
          if(1==1){
              temp = "223";
              let temp = "xxx";
          }

      },
      testLet3(){
          var a = 10;
          // let a = 22;
          // var s  = function(a){
          //     let a ;
          // }

      },
      testLet4(){
          let a ;
          a = 10;
          a = "123";
          alert(a);
      },
      testLet5(){
          const a = 10;
          // a = 1;
          
      }

  }
})
</script>

<style scoped>


span{
  color: red;
  padding: 20px 0px;
}

div{
  margin-bottom: 30px;
}

</style>
