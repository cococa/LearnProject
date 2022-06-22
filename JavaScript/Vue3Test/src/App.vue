<template>
  <div class="flex-col justify-center items-center">
    <router-view style="min-width:980px;height: 100vh;" class="max-w-screen-sm bg-gray-50 min-h-full max-h-full">
    </router-view>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "App",
  data() {
    return {
      height: 200,
      routerList: [],
    };
  },
  components: {
  },
  created() {
    this.routerList = this.$router.getRoutes();
    console.log("getData");
    this.getData();
    setTimeout(() => {
      if (this.$refs.divRef) {
        let descHeight = window
          .getComputedStyle(this.$refs.divRef)
          .height.replace("px", "");
        console.log("descHeight:" + descHeight);
        if (descHeight > 60) {
          this.textOver = true;
        } else {
          this.textOver = false;
        }
      }
    }, 1000);
  },
  methods: {
 
    getData() {
      const rowContent = {
        color: "#333",
        fontSize: 12,
        innerText: "",
        marginLeft: 0,
        marginRight: 0,
      };

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

p {
  display: inline;
  font-size: 5px;
}

.ctn {
  /* height: 75px; */
}

.p1 {
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
.arrow--1:after,
.arrow--1:before {
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
.arrow--2:after,
.arrow--2:before {
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
.arrow--3:after,
.arrow--3:before {
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
.arrow--4:after,
.arrow--4:before {
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
.arrow--5:after,
.arrow--5:before {
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
.arrow--6:after,
.arrow--6:before {
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
.arrow--7:after,
.arrow--7:before {
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
.arrow--8:after,
.arrow--8:before {
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
.arrow--9:after,
.arrow--9:before {
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
.arrow--10:after,
.arrow--10:before {
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
  content: "";
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

.btn {
  height: 200px;
  width: 30px;
  text-wrap: normal;
  background-size: 100% 100%;
  background-repeat: no-repeat;
  text-align: center;
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
  color: #fff;
  border-color: aqua;
  border-width: 3px;
  border-style: solid;
}

.top-btn {
  background: linear-gradient(-60deg, transparent 21px, #d12826 0) bottom right;
  /* margin-top: 21px; */
}

.bottom-btn {
  margin-top: -42px;
  /* height: 100px; */
  background: linear-gradient(130deg, transparent 21px, green 0) bottom right;
}

.left-btn {
  /* width: 200px; */
  /* background-size: 90%;  */
  padding: 6px 35px 6px 12px;
  background-repeat: no-repeat;
  background: linear-gradient(-65deg, transparent 22px, #58a 0);
}

.right-btn1 {
  margin-left: -25px;
  padding: 3px;
  background-repeat: no-repeat;
  background: linear-gradient(-65deg, transparent 22px, #58a 0);
}
.right-btn2 {
  padding: 6px 35px 6px 12px;
  background-repeat: no-repeat;
  background: linear-gradient(-65deg, transparent 22px, #000 0);
}

.parent {
  /* line-height: 90px; */
  background: green;
  /* height: 200px; */
}

.child {
  background-color: red;
  display: flex;
  flex-direction: row;
  align-items: center;
}



.test1{
  transform:skewX(-40deg);
  padding:0px 10px;
  width: 80px;
  height: 60px;
  text-align: center;
  background-color: rgba(0, 255, 0, 0.6);
  border: solid 2px red;
}

.test2{
  transform:skewX(40deg);
}

</style>
