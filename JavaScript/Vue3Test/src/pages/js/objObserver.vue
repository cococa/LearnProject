<template>
  <div class="flex flex-1 flex-col">
    <div v-for="(item, index) in codeArray" :key="index" class="item">
      <vue3-markdown-it :source="item.code" />
      <button @click="testClick(item.methodName)">
        testMethod({{ item.methodName }})
      </button>
    </div>
  </div>
</template>

<script lang="ts">
import VueMarkdownIt from "vue3-markdown-it";
import mixinCode from "../../mixins/mixinCode";

export default {
  name: "asd",
  components: {
    VueMarkdownIt,
  },
  mixins: [mixinCode],
  data() {
    return {
      name: "shencocoa",
    };
  },
  mounted() {},
  methods: {
    base1() {
      let p = {};
      let name = "";
      Object.defineProperty(p, "name", {
        enumerable: true,
        configurable: true,
        get() {
          console.log("get name");
          return name;
        },
        set(nv) {
          console.log("set name");
          name = nv;
        },
      });
      p.name = "111";
      console.log(p.name);
    },
    base2() {
      class Observer {
        value = {};
        constructor(value) {
          this.value = value;
          this.walk(this);
        }

        walk(data, value) {
          // Object.keys(data.value).forEach((key) => {
          const keys = Object.keys(data.value);    
          for (var i = 0; i < keys.length; i++) {  
            const key = keys[i]
            console.log("walk key =>> ", key);
            value = this.value[key];
            Object.defineProperty(data, key, {
              enumerable: true,
              configurable: true,
              get() {
                console.log("get" + key);
                return value;
              },
              set(newValue) {
                if (newValue === data[key]) {
                  return;
                }
                console.log("set" + key + " " + value + "==>" + newValue);
                value = newValue;
              },
            });
          };
        }
      }

      let ob = new Observer({
        name: "shencocoa",
        age: 18,
        langs:['swift','java']
      });

      ob.name = "123";
      console.log(ob.name);

      console.log(ob.age);
      
      // ob.langs.push('python');
      // console.log(ob.langs);



    },
    base3() {
      const list = [1, 3, 5, 7];
      console.log("=>", this);
      list.forEach((element) => {
        //箭头函数没有 this。如果访问 this，则会从外部获取。
        console.log("get name from list foreach @arrow function==>", this.name);
      });
      list.forEach(function (item) {
        //Cannot read properties of undefined (reading 'name')
        // console.log('get name from list foreach ==>',this.name);
        console.log(this);
      });
    },
  },
  setup(props) {},
};
</script>

<style scoped>
.item {
  margin-bottom: 10px;
}
</style>
