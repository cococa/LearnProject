<template>
  <div class="flex flex-1 flex-col">
    <vue3-markdown-it :source="source" />
    <div>
      <button type="button" @click="test1">对象的拷贝</button>
    </div>
    <vue3-markdown-it :source="source1" />

    <div>
      <button type="button" @click="test2">自定义对象的拷贝</button>
    </div>
    <button @click="testClick">
      test
    </button>

  </div>
</template>

<script lang="ts">
import VueMarkdownIt from "vue3-markdown-it";
import { union } from "@/util/CCArrayUtil.js";



function test() {
  return `
  # 
  \`\`\`javascript
  // 对象的比较
    let a = {};
    let b = a;
    a == b  ;   // true 同一个对象
    a === b ;   // true 
  \`\`\`
  
  \`\`\`javascript
    // 当然这里只考虑了 object的类型，没有考虑数组等别的拷贝
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

    function deepClone(obj) {
        if (obj === null) return null;
        let clone = Object.assign({}, obj);
        Object.keys(clone).forEach(
          (key) =>
            (clone[key] =
              typeof obj[key] === "object" ? deepClone(obj[key]) : obj[key])
        );
        if (Array.isArray(obj)) {
          clone.length = obj.length;
          return Array.from(clone);
        }
        return clone;
    }



  \`\`\`
  ## 

  `;
}

function _deepClone(rest) {
  let result = {};
  for (let key in rest) {
    console.log(typeof rest[key]);
    if (typeof rest[key] == "object") {
      result[key] = _deepClone(rest[key]);
    } else {
      result[key] = rest[key];
    }
  }
  return result;
}

function deepClone(obj) {
  if (obj === null) return null;
  let clone = Object.assign({}, obj);
  Object.keys(clone).forEach(
    (key) =>
      (clone[key] =
        typeof obj[key] === "object" ? deepClone(obj[key]) : obj[key])
  );
  if (Array.isArray(obj)) {
    clone.length = obj.length;
    return Array.from(clone);
  }
  return clone;
}

export default {
  name: "xx",
  components: {
    VueMarkdownIt,
  },
  data() {
    return {
      source: test(),
      source1: "",
      aa: "",
    };
  },
  mounted() {},
  methods: {
    testClick(){
      // const array = [{name:'123',ae}];  
      // const re = array.removeAll((item)=>item>1);
      // console.log(re);

      console.log(union([1],[2]));


        // console.log(intersection([1,2,3,4],[-1,3,3]));
    },
    test1() {
      let user = {
        name: "123",
        address: {
          msg: "zhejianghangzhou",
          code: 3100,
        },
      };
      let newUser = {};
      Object.assign(newUser, user);
      user.address.msg = "changed";
      user.name = "changed";

      //object.vue:38 {"name":"123","address":{"msg":"changed","code":3100}}
      // Object.assign 并不能进行深层次的拷贝，比如这个address 对象，在newUser 中和 在user 中是一个引用
      console.log(JSON.stringify(newUser));
      this.source1 = `
          Object.assign 并不能进行深层次的拷贝，比如这个address 对象，在newUser 中和 在user 中是一个引用
          \`\`\`
            ${JSON.stringify(newUser)}
          \`\`\`
          `;
    },
    test2() {
      let user = {
        name: "123",
        address: {
          msg: "zhejianghangzhou",
          code: 3100,
          info: {
            status: "404",
          },
        },
      };

      const newUser = _deepClone(user);

      user.address.msg = "changed";
      user.address.info.status = "200";
      user.name = "changed";
      console.log(JSON.stringify(newUser));
    },
  },
  setup(props) {},
};
</script>

<style></style>
