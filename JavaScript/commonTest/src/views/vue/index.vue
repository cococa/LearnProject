<template>
  <div class="flex flex-1 flex-col">
    <div
      class="flex flex-row flex-1 p-6 bg-gray-200"
      v-for="(item, index) in routerList"
      :key="index"
      @click="push(item.path)"
    >
      <div class="flex-1 flex-row item">
        <div class="item-title flex-1">
          {{ index }}. {{ item.meta.title || "item.path" }}
        </div>
        <div>点击进入</div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { WebSocketServer } from "ws";

// console.log(WebSocket);
console.log(WebSocketServer);

// const wss = new WebSocketServer({
//   port: 8080,
//   perMessageDeflate: {
//     zlibDeflateOptions: {
//       // See zlib defaults.
//       chunkSize: 1024,
//       memLevel: 7,
//       level: 3,
//     },
//     zlibInflateOptions: {
//       chunkSize: 10 * 1024,
//     },
//     // Other options settable:
//     clientNoContextTakeover: true, // Defaults to negotiated value.
//     serverNoContextTakeover: true, // Defaults to negotiated value.
//     serverMaxWindowBits: 10, // Defaults to negotiated value.
//     // Below options specified as default values.
//     concurrencyLimit: 10, // Limits zlib concurrency for perf.
//     threshold: 1024, // Size (in bytes) below which messages
//     // should not be compressed if context takeover is disabled.
//   },
// });

export default {
  name: "xx",
  components: {},
  data() {
    return {
      routerList: [],
    };
  },
  mounted() {
    const app = this;
    this.routerList = this.$router.getRoutes().filter((item) => {
      return (
        item.path.indexOf("vue") > -1 && item.path.indexOf("vue/index") == -1
      );
    });
    console.log(this.routerList);
  },
  methods: {
    push(path) {
      this.$router.push(path);
    },
  },
  setup(props) {},
};
</script>

<style>
.item-title {
  font-size: 1.3rem;
  color: #333;
  padding: 10px 20px;
}

.item {
  padding: 16px;
  border-top-width: 0px;
  border-left-width: 0px;
  border-right-width: 0px;
  border-bottom-width: 1px;
  border-color: #999;
  border-style: solid;
  align-items: center;
}
</style>
