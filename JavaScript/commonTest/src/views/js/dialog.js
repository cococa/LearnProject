import { createApp } from "vue";
import Dialog from "./Dialog.vue";

export function showMsg(msg, close) {
  const dialogDiv = document.createElement("div");
  dialogDiv.setAttribute("id", "globdialog");
  document.body.appendChild(dialogDiv);
  const app = createApp(Dialog, { title: "1222" });
  app.mount(dialogDiv);
  console.log(msg);
}
