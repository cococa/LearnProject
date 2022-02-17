<template>
  <div class="flex-col justify-center items-center">
    <div  ref="divRef" :class="[textOver && !btnFold ? 'inner over' : 'inner','ctn']">
        <p>冬奥会自开幕以来冬奥会自开幕以来冬奥冬奥 奥会自开幕以来冬奥会自开幕以来</p>
        <p style="color:red;margin-left:10px">冬奥会自开幕以来冬奥会自开幕会自开幕以来冬奥会自开幕以来冬奥会自开幕以来</p>
            </div>
    <!-- <router-link v-for="(item ,index) in routerList" :key="index" :to="item.path">Go to {{item.path}}</router-link> -->
    <router-view class="max-w-screen-sm bg-gray-50 min-h-full max-h-full">
    </router-view>
    <!-- 
    <div class="h-32 w-32 dark:bg-gray-800 bg-red-900 ">
      {{name}}
    </div>
    
    <router-link to="/">Go to About</router-link>
    <button @click="onRouter">
      test router
    </button>
    <img
      class="w-32 h-32 sm:w-60 sm:h-60 rounded-full"
      alt="Vue logo"
      src="https://img0.baidu.com/it/u=2592042537,1864064944&fm=26&fmt=auto&gp=0.jpg"
    />
    <div class="w-12 h-12 bg-purple-400 rounded-full">
        <span class="animate-ping inline-flex h-full w-full rounded-full bg-purple-400 opacity-75"></span>
    </div>
    <HelloWorld msg="Hello Vue 3.0 + Vite" />
    <div
      class="h-64 grid grid-rows-3 grid-flow-col gap-4 min-w-full max-w-full"
    >
      <div
        class="
          flex-auto
          bg-yellow-200
          flex
          justify-center
          items-center
          rounded-3xl
          hover:bg-yellow-600
        "
        v-for="(item, index) in list"
        :key="index"
      >
        {{ item }}
      </div>
    </div>
    <input
      class="
        focus:border-light-blue-500
        focus:ring-1
        focus:ring-light-blue-500
        focus:outline-none
        w-full
        text-sm text-black
        placeholder-gray-500
        border border-gray-200
        rounded-md
        py-2
        pl-10
      "
      type="text"
      aria-label="Filter projects"
      placeholder="Filter projects"
    />
    <dd
      class="
        flex
        justify-end
        sm:justify-start
        lg:justify-end
        xl:justify-start
        -space-x-2
      "
    >
      <img
        v-for="(user, index) in users"
        :src="user"
        :key="index"
        width="48"
        height="48"
        class="w-7 h-7 rounded-full bg-gray-100 border-2 border-white"
      />
    </dd> -->
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
// import { getRoutes } from 'vue-router'
import axios from "axios";

export default {
  name: "App",
  data() {
    return {
      users: [
        "https://img0.baidu.com/it/u=3311900507,1448170316&fm=26&fmt=auto&gp=0.jpg",
        "https://img2.baidu.com/it/u=325567737,3478266281&fm=26&fmt=auto&gp=0.jpg",
      ],
      list: [1, 2, 3, 4, 5, 6, 7, 8, 9],
      routerList: [],
      setBackground: {
        backgroundImage:
          "url(http://116.131.22.58:18060/img/login_kuang.3dcd8e64.png)",
        backgroundRepeat: "no-repeat",
      },
      textOver: false, //文本是否超出3行
      btnFold: false, //按钮默认显示展开
      //img : require("./assets/border.png")
    };
  },
  components: {
    HelloWorld,
  },
  created() {
    this.routerList = this.$router.getRoutes();
    console.log("getData");
    this.getData();
    setTimeout(()=>{
        if (this.$refs.divRef) {
        let descHeight = window
          .getComputedStyle(this.$refs.divRef)
          .height.replace("px", "");
        console.log("descHeight:" + descHeight);
        if (descHeight > 60) {
          this.textOver= true;
        } else {
          this.textOver= false;
        }
      }
    },1000)
  },
  methods: {
    getData() {
      const rowContent = {
          color: '#333',
          fontSize : 12,
          innerText: '',
          marginLeft: 0,
          marginRight: 0
      }  


      axios
        .get("http://47.98.197.126:9999/mock/11/stz/home/station")
        .then((res) => {
          console.log("axios", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    onRouter() {
      //   console.log(this.$router);
      //  this.$router.push('/about')
    },
  },
  setup(props) {},
};
</script>

<style scoped>

.over {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  overflow: hidden;
}

p{
  display: inline;
  font-size: 5px;
}


.ctn{
  /* height: 75px; */
}

.p1{
  /* height: 75px;
  line-height: 75px; */
  font-size: 25px;
}

.wrap {
  /* width: 300px;
  height: 300px; */
  width: 150px;
  height: auto;
  background-size: cover;
  /* 　　background-position: center center;
background-size:100% 100%; */
  /* background-size:cover; */
  background-size: 100% 100%;
  background-position: center center;
  /* background-color: transparent; */
  display: flex;
  flex-direction: column;
  padding: 10px;
  color: white;
}
body {
  background: #f8f8f8;
}

.page {
  padding: 50px;
}

.arrow {
  border: 3px solid #97d4e8;
  border-radius: 4px;
  background: #c8e7f1;
  color: #2d7187;
  margin: 0 auto 40px;
  padding: 20px;
  text-align: center;
  width: 200px;
  height: 30px;
}

.arrow--1 {
  position: relative;
}
.arrow--1:after, .arrow--1:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 0;
  bottom: 100%;
}
.arrow--1:after {
  border-color: rgba(255, 255, 255, 0);
  border-bottom-color: #c8e7f1;
  left: 50%;
  margin-left: -10px;
  border-width: 10px;
}
.arrow--1:before {
  border-color: rgba(255, 255, 255, 0);
  border-bottom-color: #97d4e8;
  left: 50%;
  margin-left: -14px;
  border-width: 14px;
}

.arrow--2 {
  position: relative;
}
.arrow--2:after, .arrow--2:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 30;
  left: 100%;
}
.arrow--2:after {
  border-color: rgba(255, 255, 255, 0);
  border-left-color: #c8e7f1;
  top: 10px;
  border-width: 20px;
}
.arrow--2:before {
  border-color: rgba(255, 255, 255, 0);
  border-left-color: #97d4e8;
  top: -3px;
  /* margin-top: -14px; */
  border-width: 40px;
}

.arrow--3 {
  position: relative;
}
.arrow--3:after, .arrow--3:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 0;
  top: 100%;
}
.arrow--3:after {
  border-color: rgba(255, 255, 255, 0);
  border-top-color: #c8e7f1;
  left: 50%;
  margin-left: -10px;
  border-width: 10px;
}
.arrow--3:before {
  border-color: rgba(255, 255, 255, 0);
  border-top-color: #97d4e8;
  left: 50%;
  margin-left: -14px;
  border-width: 14px;
}

.arrow--4 {
  position: relative;
}
.arrow--4:after, .arrow--4:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 0;
  right: 100%;
}
.arrow--4:after {
  border-color: rgba(255, 255, 255, 0);
  border-right-color: #c8e7f1;
  top: 50%;
  margin-top: -10px;
  border-width: 10px;
}
.arrow--4:before {
  border-color: rgba(255, 255, 255, 0);
  border-right-color: #97d4e8;
  top: 50%;
  margin-top: -14px;
  border-width: 14px;
}

.arrow--5 {
  position: relative;
  border: none;
}
.arrow--5:after, .arrow--5:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 0;
  top: 100%;
}
.arrow--5:after {
  border-color: rgba(255, 255, 255, 0);
  border-top-color: #c8e7f1;
  left: 50%;
  margin-left: -10px;
  border-width: 10px;
}
.arrow--5:before {
  border-color: rgba(255, 255, 255, 0);
  border-top-color: #999;
  left: 50%;
  margin-left: -10px;
  border-width: 10px;
}

.arrow--6 {
  position: relative;
}
.arrow--6:after, .arrow--6:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 0;
  margin-top: -3px;
  top: 0;
}
.arrow--6:after {
  border-color: rgba(255, 255, 255, 0);
  border-top-color: #f8f8f8;
  left: 50%;
  margin-left: -10px;
  border-width: 10px;
}
.arrow--6:before {
  border-color: rgba(255, 255, 255, 0);
  border-top-color: #97d4e8;
  left: 50%;
  margin-left: -14px;
  border-width: 14px;
}

.arrow--7 {
  position: relative;
}
.arrow--7:after, .arrow--7:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 0;
  margin-right: -3px;
  right: 0;
}
.arrow--7:after {
  border-color: rgba(255, 255, 255, 0);
  border-right-color: #f8f8f8;
  top: 50%;
  margin-top: -10px;
  border-width: 10px;
}
.arrow--7:before {
  border-color: rgba(255, 255, 255, 0);
  border-right-color: #97d4e8;
  top: 50%;
  margin-top: -14px;
  border-width: 14px;
}

.arrow--8 {
  position: relative;
}
.arrow--8:after, .arrow--8:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 0;
  bottom: 0;
  margin-bottom: -3px;
}
.arrow--8:after {
  border-color: rgba(255, 255, 255, 0);
  border-bottom-color: #f8f8f8;
  left: 50%;
  margin-left: -10px;
  border-width: 10px;
}
.arrow--8:before {
  border-color: rgba(255, 255, 255, 0);
  border-bottom-color: #97d4e8;
  left: 50%;
  margin-left: -14px;
  border-width: 14px;
}

.arrow--9 {
  position: relative;
}
.arrow--9:after, .arrow--9:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 0;
  left: 0;
  margin-left: -3px;
}
.arrow--9:after {
  border-color: rgba(255, 255, 255, 0);
  border-left-color: #f8f8f8;
  top: 50%;
  margin-top: -10px;
  border-width: 10px;
}
.arrow--9:before {
  border-color: rgba(255, 255, 255, 0);
  border-left-color: #97d4e8;
  top: 50%;
  margin-top: -14px;
  border-width: 14px;
}

.arrow--10 {
  position: relative;
  border: none;
}
.arrow--10:after, .arrow--10:before {
  border: solid transparent;
  content: " ";
  display: block;
  height: 0;
  position: absolute;
  pointer-events: none;
  width: 0;
  bottom: 0;
  margin-bottom: 0;
}
.arrow--10:after {
  border-color: rgba(255, 255, 255, 0);
  border-bottom-color: #f8f8f8;
  left: 50%;
  margin-left: -10px;
  border-width: 10px;
}
.arrow--10:before {
  border-color: rgba(255, 255, 255, 0);
  border-bottom-color: none;
  left: 50%;
  margin-left: -10px;
  border-width: 10px;
}
.arrowaa {
                width: 20px;
                height: 4px;
                margin: 0 auto 7px;
                border-left: 4px solid transparent;
                border-right: 4px solid transparent;
                border-bottom: 4px solid #343c99;
                transform: rotate(45deg);
                transform-origin: left;
            }
            
            .arrowaa:after {
                content: '';
                display: block;
                width: 100%;
                height: 100%;
                border-left: 4px solid transparent;
                border-right: 4px solid transparent;
                border-top: 4px solid #343c99;
                position: absolute;
                right: -10px;
                top: -14px;
                transform: rotate(90deg);
                transform-origin: bottom;
            }

</style>
