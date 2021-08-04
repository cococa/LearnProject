<template>  
  <div class="flex justify-center items-center flex-col">
     <div>name from setup  : {{name}}</div>
     <button @click="clickFromSetup" >click from setup</button>
     <div class="p-5">
     </div>   
     <div>count from setup  : {{count}}</div>
     <button class="" @click="countPlus" >click from setup use countPlus</button>

    <div class="p-5">
     </div>   
     <div>get user from setup & composable, 
         这里已经完全拆分功能，然后再setup 中使用user 和dept 相关的函数和属性</div>
     <div>user  : {{user}}</div>
     <button class=""  @click="getUser" >getUser</button>
     <button class=""  @click="changeDept" >changeDept</button>
  </div>
</template>

<script>
import {onMounted, ref, watch}  from 'vue';
import userCompose from '../composables/UserCompose'
export default {
  name: 'xx',
  data() {
    return {
      
    };
  },
  components: {
  },
  created() {
        
  },  
  methods: {
        clickFromSetup(){
            console.log(this.getName());
        }
  },
  setup(props) {
      let name  = "cocoa";
      function getName(){
          return name;
      }
      const count  = ref(0);  
      
      function countPlus(){
          count.value ++;
      }
      
      // 使用watch 函数
      watch(count ,(newValue,oldValue)=>{
          console.log(`the newValue ${newValue} and the oldValue ${oldValue}`);
      });

      onMounted(countPlus);  // 在 `mounted` 时调用 `countPlus`


      const deptID  = ref(11);  
      const { user , getUser}  = userCompose(deptID);  

      function changeDept(){
        deptID.value++;
      }  

      return {
        count,
        countPlus,  
        getName,
        name,
        user,
        getUser,
        changeDept
      }
  }
};
</script>
