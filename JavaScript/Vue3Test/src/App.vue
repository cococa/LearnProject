<template>
  <div class="flex justify-center items-center flex-col">
    <div class="h-32 w-32 dark:bg-gray-800 bg-red-900 ">
    </div>
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
    </dd>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue';

export default {
  name: 'App',
  data() {
    return {
      users: [
        'https://img0.baidu.com/it/u=3311900507,1448170316&fm=26&fmt=auto&gp=0.jpg',
        'https://img2.baidu.com/it/u=325567737,3478266281&fm=26&fmt=auto&gp=0.jpg',
      ],
      list: [1, 2, 3, 4, 5, 6, 7, 8, 9],
    };
  },
  components: {
    HelloWorld,
  },
};
</script>
