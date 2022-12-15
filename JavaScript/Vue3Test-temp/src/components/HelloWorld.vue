<template>
  <div class="flex justify-center items-center">
    <h1 class="rounded-3xl border-gray-500">{{ msg }}</h1>
    <button @click="count++">count is: {{ count }}</button>
    <p class="text-red-600">Edit to test hot module replacement.</p>
  
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String,
  },
  data() {
    return {
      count: 0,
    };
  },
};
</script>
