import { toRefs, h, ref } from "vue";
export default {
  name: "RenderComponent",
  render() {
    if (this.list && this.list.length > 0) {
      return h(
        "ul", // 标签名称
        {
          class: ["text-red-400", "border-2", "border-solid"],
        },
        [
          ...this.list.map((item) => {
            return h("li", "-item-" + item);
          }),
          h("div", "name =" + this.name),
        ]
      );
    } else {
      return h(
        "div",
        {
          onClick: this.testClick,
        },
        [
          h("h1", "name =" + this.name),
          h("div", "list is empty , click to append data!"),
        ]
      );
    }
  },
  data() {
    return {};
  },
  props: {
    name: String,
    age: Number,
    type: {
      type: String,
      default: "default type string",
    },
  },
  setup(props) {
    console.log("--props-" + JSON.stringify(props));
    var { name } = toRefs(props);
    var list = ref([]);
    function testClick() {
      console.log(list);
      list.value.push("the data was append render function!");
      // console.log(list);
    }

    return {
      testClick,
      name,
      list,
    };
  },
};
