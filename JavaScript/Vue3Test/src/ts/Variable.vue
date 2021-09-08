<template>  
  <div class="flex flex-1 flex-col ">
    <vue3-markdown-it :source='source' />
    <button>123</button>
  </div>
</template>

<script lang='ts'>
import VueMarkdownIt from 'vue3-markdown-it';

let x = 10;
// let x = 10;
var a = 100;
var a = 111;

console.log(`a = ${a}`);

x = 222;
console.log(`x = ${x}`);

const c1 = 10;
// c1 = 11;   // constant


// 解构
let input = [1, 2];
let [first, second] = input;
console.log(`the first ${first} and second ${second}`);

let [index1, index2] = [second,first];
console.log(`the index1 ${index1} and index2 ${index2}`);

// 对象解构
let { xx ,yy } = {xx : 10 , yy: 100};
console.log(xx,yy);




export default {
  name: 'xx',
  components: {
    VueMarkdownIt
  },
  data() {
    return {
      source: ''
    }
  },
  mounted() {
    this.loadFile('./ts/02variable.md');
  },
  methods: {
    loadFile(fileName){
        //  更新数据devInfo.txt文件接口      
        let xhr = new XMLHttpRequest(),
        okStatus = document.location.protocol === "file:" ? 0 : 200;
        xhr.open('GET', fileName, false);// 文件路径
        xhr.overrideMimeType("text/html;charset=utf-8");//默认为utf-8
        xhr.send(null);
        this.source = (xhr.responseText); //打印文件信息
    }
  },
  setup(props) {
    
  }
};
</script>


<style >

</style>



