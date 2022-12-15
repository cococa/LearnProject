<template>  
  <div class="flex flex-1 flex-col">
        <button @click="changeName">change name</button> 
        <div>父控件的username：{{username}}</div>
        <div style="height:30px">
        </div>
        <div>点击上面的按钮，修改父控件和子控件的username</div>  
        <div>--------</div>
        <InjectComponent></InjectComponent>
        <div style="height:300px">
        </div>

        <h6>参考文档：https://v3.cn.vuejs.org/guide/composition-api-provide-inject.html#%E4%BF%AE%E6%94%B9%E5%93%8D%E5%BA%94%E5%BC%8F-property</h6>
  </div>
</template>

<script>
import InjectComponent from '../../components/InjectComponent.vue'

export default {
  name: 'xx',
  // provide(){
  //     return {
  //           username: 'cocoa',
  //           userInfo : this.userInfo
  //     }
  // },
  data() {
    return {
        userInfo: {
            name: "123",
            age: 12
        },
    };
  },
  components: {
      InjectComponent
  },
  created() {
  },  
  methods: {
      changeName(){
          this.username = "changed username"
      }
  },
  setup(props) {
    const username = ref('cocoa');
    provide('username',username)
    provide('userInfo',{
      username:'123',
      age:123 
    })
    return {
      username
    }
  }
};
</script>
