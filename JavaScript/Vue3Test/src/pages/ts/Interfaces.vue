<template>  
  <div class="flex flex-1 flex-col">
    <!-- <vue3-markdown-it :source='source' /> -->
    
  </div>
</template>

<script lang='ts'>
import VueMarkdownIt from 'vue3-markdown-it';


interface LabeledValue{
  label : String
  len? : Number  // 可选属性
  readonly xx: Number  // 只读属性
}

function printLabel(labelObj : LabeledValue){
  console.log(labelObj.label);
}

// 一旦label1 被定义为 LabeledValue . 就不能添加别的属性  'x' does not exist in type 
// 如果想要在label1 中定义别的属性，可以去掉  : LabeledValue ，因为不会经过额外属性检查，所以编译器不会报错。
let label1 : LabeledValue = { label: "Size 10 Object" ,  xx : 12};

// label1.xx = 123;  // 报错，xx 属性只读

printLabel(label1);


//  ts 中， ReadonlyArray 可以代替只读的Array
// const 用于变量， readonly 用于属性
// const 在运行时检查， readonly 在编译时检查
// const 声明的变量不得改变值，这意味着，const 一旦声明变量，就必须立即初始化，不能留到以后赋值; 
// readonly 修饰的属性能确保自身不能修改属性，但是当你把这个属性交给其它并没有这种保证的使用者(允许出于类型兼容性的原因)，他们能改变


//----------函数类型-----------------

interface compareFunc{
    (a : number , b : number ) : boolean;
}

let compare : compareFunc;
compare = function (a : number , b : number) {
  return a > b 
}





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
    
  }
};
</script>


<style >

</style>



