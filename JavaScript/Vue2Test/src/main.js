import Vue from 'vue'
import App from './App.vue'

const ccvue = new Vue({
  el: '#app',
  render: h => h(App)
})

window.ccvue = ccvue