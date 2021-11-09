<template>  
  <div class="flex flex-1 flex-col ">
    <button @click="test1">对象的拷贝</button>
    <div>
    <div>
    <button @click="test2">自定义对象的拷贝</button>
  </div>
</template>

<script lang='ts'>
import VueMarkdownIt from 'vue3-markdown-it';

function _deepClone(rest){
    let result  = {}
    for(let key  in rest){
      console.log((typeof rest[key]));
      if((typeof rest[key]) == 'object'){
        result[key] = _deepClone(rest[key]);  
      }else{
        result[key] = rest[key]
      }
    }

    return result;
}



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
      test1(){
          let user = {
            name:'123',
            address:{
              msg:"zhejianghangzhou",
              code:3100
            }
          }
          let newUser ={}
          Object.assign(newUser, user);
          user.address.msg = "changed";
          user.name = "changed"

          //object.vue:38 {"name":"123","address":{"msg":"changed","code":3100}}
          // Object.assign 并不能进行深层次的拷贝，比如这个address 对象，在newUser 中和 在user 中是一个引用
          console.log(JSON.stringify(newUser));

      },
      test2(){
          let user = {
            name:'123',
            address:{
              msg:"zhejianghangzhou",
              code:3100,
              info:{
                status : "404"
              }
            }
          }
         
         const newUser = _deepClone(user);
         
          user.address.msg = "changed";
          user.address.info.status = "200"
          user.name = "changed"
        console.log(JSON.stringify(newUser));

      }
  },
  setup(props) {
    
  }
};
</script>


<style >

</style>

