
import { inject ,h } from 'vue'
export default {
  name: 'RenderComponent',
  render(){
    return h(
      'h1',   // 标签名称
      'this content from render function' // 子节点数组
    )
  },
  data() {
    return {
      
    };
  },
  setup(props) {
      
  }
};
