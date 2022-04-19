import { ref, toRefs, watch } from "vue";

export default function userCompose(deptId) {
  const user = ref({ username: "", age: 0, deptId: deptId.value });
  function getUser() {
    user.value = { username: "cocoa", age: 32, deptId: deptId.value };
  }
  watch(deptId, (newv, oldv) => {
    console.log("the deptid has chanded! " + newv + "  " + oldv);
    getUser();
  });
  return {
    user,
    getUser,
  };
}
