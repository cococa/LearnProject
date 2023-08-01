<template>
  <div class="flex flex-1 flex-col">
    <el-dialog
      v-model="dialogVisible"
      :title="title"
      width="30%"
      :before-close="handleClose"
    >
      <div id="elcontent"></div>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="dialogVisible = false">
            Confirm
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts">
import { ElDialog, ElButton } from "element-plus";
import { ref , render , onMounted} from "vue";

export default {
  name: "Dialog",
  components: {
    ElDialog,
    ElButton,
  },
  props: {
    title: {
      type: String,
      default: "Tips",
    },
    content: {
      type: String,
      default: '<div>this is message</div>',
    },
  },
  data() {
    return {};
  },
  mounted() {},
  methods: {},
  setup(props) {
    const dialogVisible = ref(true);
    const handleClose = () => {};
    

    onMounted(() => {
      setTimeout(() => {
        // const v = `<div class="foo">testRender DIV INNDER123</div>`;
        // const dialogContent = document.getElementById("elcontent");
        // render(v, dialogContent)
        // dialogContent?.appendChild(dialogContent);
      }, 2000);
    });


    return {
      dialogVisible,
      handleClose,
    };
  },
};
</script>

<style scoped></style>
