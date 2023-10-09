import { defineStore } from "pinia";

interface IUserInfo {
  name: string;
  age: number;
}

interface State {
  userList: IUserInfo[];
  user: IUserInfo | null;
}

/**
 * 使用 typescript 和 option API
 * 
 */
export const useUserStore = defineStore("user", {
  state: (): State => ({
    userList: [],
    user: null,
  }),
  actions: {
    changeUser(user: IUserInfo) {
      this.user = user;
    }
  }
});
