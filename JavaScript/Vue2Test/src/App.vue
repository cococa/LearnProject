<template>
  <div id="app">
    <img src="./assets/logo.png" />
    <div>{{ cc_count }}</div>
    <h1>{{ msg }}</h1>
    <button @click="changeCount">changeCount</button>
    <ul>
      <li><a href="https://vuejs.org" target="_blank">Core Docs</a></li>
      <li><a href="https://forum.vuejs.org" target="_blank">Forum</a></li>
      <li>
        <a href="https://chat.vuejs.org" target="_blank">Community Chat</a>
      </li>
      <li><a href="https://twitter.com/vuejs" target="_blank">Twitter</a></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      cc_count: 1,
      msg: "Welcome to Your Vue.js App"
    };
  },
  watch:{
      // cc_count: function(newValue, oldValue) {
      //   console.log(newValue, oldValue);
      // }
  },
  created() {
    console.log("created");
  },
  methods: {
    changeCount() {
      this.cc_count++;
    }
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1,
h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
