<template>  
  <div class="flex flex-1 flex-col ">
    <vue3-markdown-it :source='source' />
    <button>123</button>
  </div>
</template>

<script lang='ts'>
import VueMarkdownIt from 'vue3-markdown-it';

let isDone: boolean = false;
let x :  [string , number ]= ['123', 123];
console.log(x);

enum Color { Red , Green }

console.log("Color red =" + Color.Red);

function error (message : string) : never{
     throw new Error(message);
}

// error('file not found!');


// array 

let list1 : Array<number> = [1,2,3]
let list2 : number[] = [12,2,3]

console.log(list1);
console.log(list2);
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
    this.loadFile('./ts/01basic.md');
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
      console.log("xxxx");
      console.log(isDone);
      


  }
};
</script>


<style >

</style>



