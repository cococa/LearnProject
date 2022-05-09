import path from "path";
import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig({
  //   publicPath: "./",
  base: "/",
  plugins: [vue()],
  build: {
    sourcemap: 'inline',
  },
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "src"),
      "@/util": path.resolve(__dirname, "src/util"),
    },
  },
});

// const { resolve } = require("path");

// export default function () {
//     return {
//         base:'baseUrl',
//         alias :{
//            'vue' : 'vue/dist/vue.esm-bundler.js'
//         },
//         resolve:{
//             alias:{
//                 '/@': resolve(__dirname, 'src'),
//                 '/@/util': resolve(__dirname, 'src/util')
//             }
//         }
//     }
// }
