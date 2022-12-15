<template>
  <div class="flex flex-1 flex-col">
    <a>Tag A </a>
    <div class="tag2">Tag2</div>
  </div>
</template>

<script lang="ts">
export default {
  name: "xx",
  components: {},
  data() {
    return {};
  },
  mounted() {},
  methods: {},
  setup(props) {},
};
</script>

<style>
body {
  --foo: #7f583f;
  --bar: #f7efd2;
}

a {
  color: var(--foo);
  text-decoration-color: var(--bar);
}

.tag2 {
  color: var(--noExist, red);
}
</style>
