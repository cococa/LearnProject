<template>
  <div class="flex flex-1 flex-col">
    <div id="ball" class="ball"></div>
    <input
      type="range"
      min="0"
      max="1"
      step="0.01"
      v-model="sliderValue"
      @input="handleInput"
    />
  </div>
</template>

<script lang="ts">
export default {
  name: "xx",
  components: {},
  data() {
    return {
      sliderValue: 0,
    };
  },
  mounted() {
    const ball = document.getElementById("ball");
    ball?.setAttribute("style", `--x:-0s`);
  },
  methods: {
    handleInput(val) {
      const ball = document.getElementById("ball");
      ball?.setAttribute("style", `--x:-${val.target.value}s`);
      console.log(val.target.value);
    },
  },
  setup(props) {},
};
</script>

<style lang="scss">
.ball {
  border-radius: 50%;
  width: 100px;
  height: 100px;
  animation: ballanim forwards linear infinite 10s -5s paused;
  /* animation-play-state: paused; */
}

@keyframes ballanim {
  0% {
    background-color: red;
    transform: translateX(0);
  }
  100% {
    background-color: blue;
    transform: translateX(300px);
  }
}
</style>
